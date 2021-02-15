package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.CampaignReviewVo;
import projectControls.Component;

@Component("campaignReviewDao")
public class CampaignReviewDao {
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
	public void reviewInsert(CampaignReviewVo campaignReview, String email, String name) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO CAMPAIGNREVIEW(SUBJECT, CONTENT, EMAIL, NAME) VALUES(?,?,?,?)");
			pstmt.setString(1, campaignReview.getSubject());
			pstmt.setString(2, campaignReview.getContent());
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
	public ArrayList<CampaignReviewVo> reviewList() throws Exception {
		conn = ds.getConnection();
		ArrayList<CampaignReviewVo> reviewList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM CAMPAIGNREVIEW ORDER BY QSEQ DESC LIMIT 10");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reviewList.add(new CampaignReviewVo().setQseq(rs.getInt("qseq"))
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
	public CampaignReviewVo getReview(int qseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM CAMPAIGNREVIEW WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
							return new CampaignReviewVo()
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
	public int update(CampaignReviewVo campaignReview) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE CAMPAIGNREVIEW SET SUBJECT =?, CONTENT =?, EDIT_INDATE = NOW() WHERE QSEQ =?");
			
			pstmt.setString(1, campaignReview.getSubject());
			pstmt.setString(2, campaignReview.getContent());
			pstmt.setInt(3, campaignReview.getQseq());
			
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
			pstmt = conn.prepareStatement("DELETE FROM CAMPAIGNREVIEW WHERE QSEQ=?");
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
			pstmt = conn.prepareStatement("UPDATE CAMPAIGNREVIEW SET VIEWS = VIEWS+1 WHERE QSEQ=?");
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

}
