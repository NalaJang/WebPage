package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hotelDto.HotelWorkerVo;
import projectControls.Component;

@Component("worderDao")
public class HotelWorkerDao {
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	//----------------------------------------------------------------
	//							관리자 확인
	//----------------------------------------------------------------
	public HotelWorkerVo exist(String email, String pw) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM worker WHERE EMAIL=? AND PW=?");
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {				
			return new HotelWorkerVo().setEmail(rs.getString("email"))
								.setName(rs.getString("name"))
								.setPhone(rs.getString("phone"))
								.setPw(rs.getString("pw"));
								 
			}
		} catch(Exception e) {
			System.out.println("DB 에러");
			throw e;
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//							관리자 목록
	//----------------------------------------------------------------
	public List<HotelWorkerVo> workerList() throws Exception {
		conn = ds.getConnection();
		List<HotelWorkerVo> workerList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM WORKER ORDER BY NAME ASC");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HotelWorkerVo worker = new HotelWorkerVo();
				worker.setEmail(rs.getString("email"));
				worker.setName(rs.getString("name"));
				worker.setPhone(rs.getString("phone"));
				worker.setPw(rs.getString("pw"));
				workerList.add(worker);
			}
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return workerList;
	}
	

}
