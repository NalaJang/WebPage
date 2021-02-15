package note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import projectControls.Component;

@Component("userDao")
public class UsersDao {
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	//데이터 저장
	public int insert(UsersVo user) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO USERS(USER_ID, USER_PW) VALUES(?,?)");
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pw());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			
			try {
				pstmt.close();
				conn.close();
				
			} catch (Exception e) {
				
			}
		}
	}
	
	//데이터 출력
	public UsersVo exist(String id, String pw) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ? and USER_PW = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new UsersVo().setUser_id(rs.getString("name"))
									.setUser_pw(rs.getString("pw"));
				
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
			try {
				pstmt.close();
				conn.close();
				
			} catch (Exception e) {
				
			}
		}
		return null;
	}
}
