package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.HotelQnAVo;
import projectControls.Component;

@Component("qnaDao")
public class QnADao {
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	//----------------------------------------------------------------
	//						      문의 목록
	//----------------------------------------------------------------
	public ArrayList<HotelQnAVo> qnaList(String email) throws Exception {
		ArrayList<HotelQnAVo> qnaList = new ArrayList<>();
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM QNA WHERE EMAIL=? ORDER BY QSEQ DESC");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HotelQnAVo HotelQnAVo = new HotelQnAVo();
				HotelQnAVo.setQseq(rs.getInt("qseq"));
				HotelQnAVo.setTitle(rs.getString("title"));
				HotelQnAVo.setSubject(rs.getString("subject"));
				HotelQnAVo.setContent(rs.getString("content"));
				HotelQnAVo.setReply(rs.getString("reply"));
				HotelQnAVo.setEmail(rs.getString("email"));
				HotelQnAVo.setRep(rs.getString("rep"));
				HotelQnAVo.setIndate(rs.getTimestamp("indate"));
				qnaList.add(HotelQnAVo);
			}
		}catch(SQLException e) {
			System.out.println("DB 에러");
			throw e;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return qnaList;
	}
	//----------------------------------------------------------------
	//						관리자가 볼 문의 목록
	//----------------------------------------------------------------	
	public ArrayList<HotelQnAVo> qnaListAll() throws Exception {
		ArrayList<HotelQnAVo> qnaListAll = new ArrayList<>();
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM QNA ORDER BY qseq DESC");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HotelQnAVo HotelQnAVo = new HotelQnAVo();
				HotelQnAVo.setQseq(rs.getInt("qseq"));
				HotelQnAVo.setTitle(rs.getString("title"));
				HotelQnAVo.setSubject(rs.getString("subject"));
				HotelQnAVo.setContent(rs.getString("content"));
				HotelQnAVo.setReply(rs.getString("reply"));
				HotelQnAVo.setEmail(rs.getString("email"));
				HotelQnAVo.setRep(rs.getString("rep"));
				HotelQnAVo.setIndate(rs.getTimestamp("indate"));
				HotelQnAVo.setReply_date(rs.getString("reply_date"));
				qnaListAll.add(HotelQnAVo);
			}
		} catch (Exception e) {
			System.out.println("DB 에러");
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
		return qnaListAll;
	}

	//----------------------------------------------------------------
	//							문의 등록
	//----------------------------------------------------------------
	public void insertqna(HotelQnAVo HotelQnAVo, String session_email) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO QNA (subject, content, email) VALUES(?,?,?)");
			pstmt.setString(1, HotelQnAVo.getSubject());
			pstmt.setString(2, HotelQnAVo.getContent());
			pstmt.setString(3, session_email);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
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
	//						문의 내역 보기
	//----------------------------------------------------------------
	public HotelQnAVo getqna(int qseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM QNA WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new HotelQnAVo()
						.setQseq(rs.getInt("qseq"))
						.setSubject(rs.getString("subject"))
						.setContent(rs.getString("content"))
						.setReply(rs.getString("reply"))
						.setEmail(rs.getString("email"))
						.setRep(rs.getString("rep"))
						.setReply_date(rs.getString("reply_date"))
						.setIndate(rs.getTimestamp("indate"));

			}
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//						답변 작성
	//----------------------------------------------------------------
	public int update(HotelQnAVo qna) throws Exception {
		conn = ds.getConnection();
		System.out.println("222");
		try {
			pstmt = conn.prepareStatement("UPDATE QNA SET REPLY=?, REP=2, REPLY_DATE=NOW() WHERE QSEQ =?");
			pstmt.setString(1, qna.getReply());
			pstmt.setInt(2, qna.getQseq());
			System.out.println("333");
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
