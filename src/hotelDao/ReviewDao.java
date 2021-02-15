package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.ReviewVo;
import projectControls.Component;

@Component("reviewDao")
public class ReviewDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	//----------------------------------------------------------------
	//							후기 등록
	//----------------------------------------------------------------
	public void reviewInsert(ReviewVo review, String email, String name) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO FREEBOARD(SUBJECT, CONTENT, EMAIL, NAME) VALUES(?,?,?,?)");
			pstmt.setString(1, review.getSubject());
			pstmt.setString(2, review.getContent());
			pstmt.setString(3, email);
			pstmt.setString(4, name);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//							후기 목록
	//----------------------------------------------------------------
	public ArrayList<ReviewVo> reviewList() throws Exception {
		conn = ds.getConnection();
		ArrayList<ReviewVo> reviewList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM FREEBOARD ORDER BY QSEQ DESC LIMIT 10");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reviewList.add(new ReviewVo().setQseq(rs.getInt("qseq"))
											 .setSubject(rs.getString("subject"))
											 .setContent(rs.getString("content"))
											 .setReply(rs.getString("reply"))
											 .setEmail(rs.getString("email"))
											 .setName(rs.getString("name"))
											 .setViews(rs.getInt("views"))
											 .setIndate(rs.getTimestamp("indate"))
											 .setEdit_indate(rs.getTimestamp("edit_indate")));
			}
			
			return reviewList;
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//							후기  내용 보기
	//----------------------------------------------------------------
	public ReviewVo getReview(int qseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM FREEBOARD WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
							return new ReviewVo()
									 .setQseq(rs.getInt("qseq"))
									 .setSubject(rs.getString("subject"))
									 .setContent(rs.getString("content"))
									 .setReply(rs.getString("reply"))
									 .setEmail(rs.getString("email"))
									 .setName(rs.getString("name"))
									 .setViews(rs.getInt("views"))
									 .setIndate(rs.getTimestamp("indate"))
									 .setEdit_indate(rs.getTimestamp("edit_indate"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return null;
	}

	//----------------------------------------------------------------
	//							후기  수정
	//----------------------------------------------------------------
	public int update(ReviewVo reviewVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE FREEBOARD SET SUBJECT =?, CONTENT =?, EDIT_INDATE = NOW() WHERE QSEQ =?");
			
			pstmt.setString(1, reviewVo.getSubject());
			pstmt.setString(2, reviewVo.getContent());
			pstmt.setInt(3, reviewVo.getQseq());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}
	
	//----------------------------------------------------------------
	//							후기  삭제
	//----------------------------------------------------------------
	public int delete(int qseq) throws Exception {
		conn = ds.getConnection();

		try {
			pstmt = conn.prepareStatement("DELETE FROM FREEBOARD WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return 0;

	}
	
	//----------------------------------------------------------------
	//							조회수 업데이트
	//----------------------------------------------------------------
	public int viewsUpdate(int qseq) throws Exception{
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE FREEBOARD SET VIEWS = VIEWS+1 WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}
	
	
	//----------------------------------------------------------------
	//							페이징
	//----------------------------------------------------------------
	/*
	public boolean nextPage(int pagenum) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM FREEBOARD WHERE QSEQ < ? ");
			pstmt.setString(1, getNext() - (pagenum - 1) * 10);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch(Exception e) {
				
			}
		}
	}
	return false;
	
	int totalContent = 0;// 전체 게시물 갯수
	int totalPage = 0;	// 총 페이지 수
	int countList = 10;	// 한 페이지에 출력 될 게시물
	int countPage= 10;	// 한 화면에 출력될 페이지 수
	
	public int[] paging(int page) throws Exception {
		//전체 게시물 갯수로 총 페이지 수 산출
		conn = ds.getConnection();
		
		
		pstmt = conn.prepareStatement("SELECT COUNT(*) FROM FREEBOARD");
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			totalContent += rs.getInt(1);
		}
		
		totalPage = totalContent / countList; //게시물 갯수 / 한 페이지에 출력될 게시물수
		
		if(totalPage > 0) {
			totalPage++;	//게시물 갯수의 나머지가 있다면 더하기 1
		}
		
		//페이징 범위 계산
		int startPage = ((page-1) / countPage) * countPage +1;
		int endPage = startPage + countPage -1;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		int[] startEnd = new int[2];	//결과를 전달해줄 배열
		startEnd[0] = startPage;
		startEnd[1] = endPage;
		
		try {
			rs.close();
		} catch(Exception e) {
			throw e;
		}
		
		return startEnd;
	}
	
	public ArrayList<ReviewVo> reviewList(int page) throws Exception {
		ArrayList<ReviewVo> reviewList = new ArrayList<>();
		conn = ds.getConnection();
		
		int startPage = (page -1) * countPage +1;	//시작 게시물
		int endPage = startPage * countPage;		//끝 게시물1
				
		try {
			pstmt = conn.prepareStatement("SELECT * FROM "
					+ "(select rownum as rnum, A.*from"
					+ "(select * from freeboard order by qseq desc) A )"
					+ "where runum >= ? and rnum <= ?"
			);
			
			pstmt.setInt(1, startPage);
			pstmt.setInt(2, endPage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVo review = new ReviewVo();
				review.setQseq(rs.getInt("qseq"));
				review.setEmail(rs.getString("email"));
				review.setSubject(rs.getString("subject"));
				review.setContent(rs.getString("content"));
				review.setReply(rs.getString("reply"));
				review.setViews(rs.getInt("views"));
				review.setIndate(rs.getTimestamp("indate"));
				
				reviewList.add(review);
				
			}
		} catch(Exception e) {
			throw e;
		}
		return null;
	}
	*/
	/*
	public ArrayList<ReviewVo> getList(String pageNum) throws Exception {
		ArrayList<ReviewVo> reviewList = new ArrayList<>();
		conn = ds.getConnection();

		try {
			pstmt = conn.prepareStatement(
					"select * from freeboard where qseq> (select max(qseq) from freeboard - ? and qseq <= (select max(qseq) from freeboard) - ? order by qseq desc");
			pstmt.setInt(1, Integer.parseInt(pageNum) * 10);
			pstmt.setInt(2, (Integer.parseInt(pageNum) - 1) * 10);

			while (rs.next()) {
				rs = pstmt.executeQuery();
				reviewList.add(new ReviewVo().setQseq(rs.getInt("qseq")).setSubject(rs.getString("subject"))
						.setContent(rs.getString("content")).setReply(rs.getString("reply"))
						.setEmail(rs.getString("email")).setViews(rs.getInt("views"))
						.setIndate(rs.getTimestamp("indate")));
			}

			return reviewList;

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

	}
	
	public boolean nextPage(String pageNum) throws Exception{
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from freeboard where qseq >=?");
			pstmt.setInt(1, Integer.parseInt(pageNum) * 10);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return false;
	}
*/
	
	/*
	
	*/
}
