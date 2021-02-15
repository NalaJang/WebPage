package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.ReplyVo;
import projectControls.Component;

@Component("replyDao")
public class ReplyDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	
	//----------------------------------------------------------------
	//							댓글 등록
	//----------------------------------------------------------------
	public void replyInsert(int qseq, String email, String content , String name) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO REPLY(QSEQ, EMAIL, CONTENT, NAME) VALUES(?,?,?,?)");
			pstmt.setInt(1, qseq);
			pstmt.setString(2, email);
			pstmt.setString(3, content);
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
	//							댓글 목록
	//----------------------------------------------------------------
	public ArrayList<ReplyVo> replyList(int qseq) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = ds.getConnection();
		ArrayList<ReplyVo> replyList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM REPLY WHERE QSEQ=? ORDER BY REPLYNUM DESC");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				replyList.add(new ReplyVo().setReplynum(rs.getInt("replynum"))
											.setQseq(rs.getInt("qseq"))
											.setContent(rs.getString("content"))
											.setEmail(rs.getString("email"))
											.setName(rs.getString("name"))
											.setIndate(rs.getTimestamp("indate"))
											.setAdmin_delete(rs.getString("admin_delete")));
			}
			
			return replyList;
			
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
	//							댓글  선택하기
	//----------------------------------------------------------------
	public ReplyVo getReply(int qseq) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM REPLY WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
							return new ReplyVo()
									 .setQseq(rs.getInt("qseq"))
									 .setPseq(rs.getInt("pseq"))
									 .setReplynum(rs.getInt("replynum"))
									 .setContent(rs.getString("content"))
									 .setEmail(rs.getString("email"))
									 .setName(rs.getString("name"))
									 .setIndate(rs.getTimestamp("indate"));

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
	//							댓글  삭제
	//----------------------------------------------------------------
	public int delete(int replynum) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();

		try {
			pstmt = conn.prepareStatement("DELETE FROM REPLY WHERE REPLYNUM=?");
			pstmt.setInt(1, replynum);
			
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
	//							댓글  삭제(관리자)
	//----------------------------------------------------------------
	public int admin_delete(int replynum) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();

		try {
			pstmt = conn.prepareStatement("UPDATE REPLY SET ADMIN_DELETE = 'Y' WHERE REPLYNUM=?");
			pstmt.setInt(1, replynum);
			
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
