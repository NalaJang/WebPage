package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.DonationVo;
import projectControls.Component;

@Component("donation")
public class DonationDao {

	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	//----------------------------------------------------------------
	//						후원 하기
	//----------------------------------------------------------------
	public int insert(DonationVo donationVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO DONATION(NAME, EMAIL, PHONE, MONEY) VALUES(?,?,?,?)");
			pstmt.setString(1, donationVo.getName());
			pstmt.setString(2, donationVo.getEmail());
			pstmt.setString(3, donationVo.getPhone());
			pstmt.setInt(4, donationVo.getMoney());
			
			return pstmt.executeUpdate();
			
		} catch(SQLException e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		
	}
	
	//----------------------------------------------------------------
	//							후원 내역
	//----------------------------------------------------------------
	public ArrayList<DonationVo> donationList(String email) throws Exception {
		ArrayList<DonationVo> donationList = new ArrayList<>();
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM DONATION WHERE EMAIL=? ORDER BY DNSEQ DESC");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DonationVo donationVo = new DonationVo();
				donationVo.setDnseq(rs.getInt("dnseq"));
				donationVo.setName(rs.getString("name"));
				donationVo.setEmail(rs.getString("email"));
				donationVo.setPhone(rs.getString("phone"));
				donationVo.setMoney(rs.getInt("money"));
				donationVo.setIndate(rs.getTimestamp("indate"));
				donationList.add(donationVo);
			}
			return donationList;
			
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
