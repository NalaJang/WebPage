package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.ReservationVo2;
import projectControls.Component;

@Component("reservation")
public class HotelReservation {	//선생님 오더로 공부해보기
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	//----------------------------------------------------------------
	//							예약 추가
	//----------------------------------------------------------------
	public int insert(ReservationVo2 rv2) throws Exception {
		conn = ds.getConnection();

		try {
			pstmt = conn.prepareStatement("INSERT INTO RESERVATION(RSEQ, EMAIL, MEMBERNUM, CHECKIN, CHECKOUT) VALUES(?,?,?,?,?)");
			pstmt.setInt(1, rv2.getRvseq());
			pstmt.setString(2, rv2.getEmail());
			pstmt.setInt(3, rv2.getMembernum());
			pstmt.setDate(4, rv2.getCheckin());
			pstmt.setDate(5, rv2.getCheckout());
			
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
	//							예약 번호 가져오기
	//----------------------------------------------------------------
	public int getRvseq(String email) throws Exception {
		conn = ds.getConnection();
		int rvseq = 0;
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM RESERVATION WHERE EMAIL=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("rvseq") > rvseq) {
					rvseq = rs.getInt("rvseq");
				}
			}
			return rvseq;
			
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
	}

	//----------------------------------------------------------------
	//							예약 후 방바구니 목록에서 없애기
	//----------------------------------------------------------------
	public int updateRoomCart(String email, ArrayList<Integer> rvseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			for(int i = 0; i < rvseq.size(); i++) {
				pstmt = conn.prepareStatement("UPDATE ROOMCART SET RESULT = 2 WHERE EMAIL=? AND RVSEQ=?");
				pstmt.setString(1, email);
				pstmt.setInt(2, rvseq.get(i));
				pstmt.executeUpdate();
				
			}
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
	//							예약 목록
	//----------------------------------------------------------------
	public ArrayList<ReservationVo2> reservationList(String email) throws Exception {
		conn = ds.getConnection();
		
		ArrayList<ReservationVo2> rl = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM RESERVATION_VIEW WHERE EMAIL=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
								ReservationVo2 rv = new ReservationVo2();
								rv.setRvseq(rs.getInt("rvseq"));
								rv.setEmail(rs.getString("email"));
								rv.setIndate(rs.getTimestamp("indate"));
								rv.setRseq(rs.getInt("rseq"));
								rv.setMembernum(rs.getInt("membernum"));
								rv.setMname(rs.getString("mname"));
								rv.setPhone(rs.getString("phone"));
								rv.setZip_num(rs.getString("zip_num"));
								rv.setAddress1(rs.getString("address1"));
								rv.setAddress2(rs.getString("address2"));
								rv.setRkind(rs.getString("rkind"));
								rv.setRentyn(rs.getString("rentyn"));
								rv.setCheckin(rs.getDate("checkIn"));
								rv.setCheckout(rs.getDate("checkOut"));
								rv.setPrice(rs.getInt("price"));
								rv.setDonation(rs.getInt("donation"));
								rv.setResult(rs.getString("result"));
			}
			
			return rl;
			
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
	/*
	//----------------------------------------------------------------
	//							예약 상세내역
	//----------------------------------------------------------------
	public int reservation_detail(ReservationVo rVo) throws Exception {
		conn = ds.getConnection();
		
		try {			
			pstmt = conn.prepareStatement
					("INSERT INTO RESERVATION_DETAIL(RVSEQ, RSEQ, MEMBERNUM, RENTYN, CHECKIN, CHECKOUT) VALUES(?,?,?,?,?,?)");
			
			return pstmt.executeUpdate();
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
	*/
}

