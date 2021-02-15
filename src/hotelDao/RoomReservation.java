package hotelDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hotelDto.ReservationVo2;
import projectControls.Component;

@Component("reservation")
public class RoomReservation {
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
	public int insert(ReservationVo2 rv222) throws Exception {
		conn = ds.getConnection();
		ReservationVo2 rv2 = null;
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM ROOMCART WHERE EMAIL=?");
			pstmt.setString(1, rv222.getEmail());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				//if -> while 로 변경함
				rv2 = new ReservationVo2();
				
				rv2.setEmail(rs.getString("email"));
				rv2.setRseq(rs.getInt("rseq"));
				rv2.setMembernum(rs.getInt("membernum"));
				rv2.setCheckin(rs.getDate("checkIn"));
				rv2.setCheckout(rs.getDate("checkOut"));
			}
			
			rs.close();
			pstmt.close();
			
			pstmt = conn.prepareStatement("INSERT INTO RESERVATION(EMAIL, RVSEQ, RSEQ, MEMBERNUM, CHECKIN, CHECKOUT) VALUES(?,?,?,?,?,?)");
			pstmt.setString(1, rv2.getEmail());
			pstmt.setInt(2, rv2.getRvseq());
			pstmt.setInt(3, rv2.getRseq());
			pstmt.setInt(4, rv2.getMembernum());
			pstmt.setDate(5, rv2.getCheckin());
			pstmt.setDate(6, rv2.getCheckout());
				
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
	//					예약 추가(바로 예약)
	//----------------------------------------------------------------
	public int insert_direct(String email, int rseq, int membernum, Date checkin, Date checkout) throws Exception {
		conn = ds.getConnection();

		try {
			pstmt = conn.prepareStatement("INSERT INTO RESERVATION(EMAIL, RSEQ, MEMBERNUM, CHECKIN, CHECKOUT) VALUES(?,?,?,?,?)");
			pstmt.setString(1, email);
			pstmt.setInt(2, rseq);
			pstmt.setInt(3, membernum);
			pstmt.setDate(4, checkin);
			pstmt.setDate(5, checkout);
			
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
			pstmt = conn.prepareStatement("SELECT RVSEQ FROM RESERVATION WHERE EMAIL =?");
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
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}
	
	//----------------------------------------------------------------
	//					예약 후 방바구니 목록에서 없애기
	//----------------------------------------------------------------
	public int updateRoomCart(String email, int rseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE ROOMCART SET RESULT = 2 WHERE EMAIL=? AND RSEQ=?");
			pstmt.setString(1, email);

			pstmt.setInt(2, rseq);
			
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
	//							예약 목록
	//----------------------------------------------------------------
	public List<ReservationVo2> reservationList(String email) throws Exception {
		List<ReservationVo2> reservationList = new ArrayList<>();
		conn = ds.getConnection();
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		
		try {
			pstmt2 = conn.prepareStatement("SELECT * FROM RESERVATION_VIEW WHERE EMAIL=? order by RVSEQ desc");
			pstmt2.setString(1, email);
			rs2 =  pstmt2.executeQuery();
			
			while(rs2.next()) {
			
				System.out.println("dao.email = " + rs2.getString("email"));
				System.out.println("dao.rkind = " + rs2.getString("rkind"));
								ReservationVo2 rv = new ReservationVo2();
								rv.setRvseq(rs2.getInt("rvseq"));
								rv.setEmail(rs2.getString("email"));
								rv.setIndate(rs2.getTimestamp("indate"));
								rv.setMembernum(rs2.getInt("membernum"));
								rv.setMname(rs2.getString("mname"));
								rv.setPhone(rs2.getString("phone"));
								rv.setZip_num(rs2.getString("zip_num"));
								rv.setAddress1(rs2.getString("address1"));
								rv.setAddress2(rs2.getString("address2"));
								rv.setRkind(rs2.getString("rkind"));
								rv.setRentyn(rs2.getString("rentyn"));
								rv.setCheckin(rs2.getDate("checkIn"));
								rv.setCheckout(rs2.getDate("checkOut"));
								rv.setPrice(rs2.getInt("price"));
								rv.setDonation(rs2.getInt("donation"));
								rv.setResult(rs2.getString("result"));
								
								reservationList.add(rv);
			}
			return reservationList;
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {
				if (rs2 != null)
					rs2.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}
	
}
