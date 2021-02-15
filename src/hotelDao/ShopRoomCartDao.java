package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.RoomCartVo;
import projectControls.Component;

@Component("roomCartDao")	//component("키 값")
public class ShopRoomCartDao {

	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	//----------------------------------------------------------------
	//						카트 목록
	//----------------------------------------------------------------
	public ArrayList<RoomCartVo> roomCartList(String email) throws Exception {
		
		conn = ds.getConnection();
		
		ArrayList<RoomCartVo> roomCartList = new ArrayList<>();
		String sql = "SELECT * FROM ROOMCART_VIEW WHERE EMAIL= ? ORDER BY CSEQ DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomCartVo roomCart = new RoomCartVo();
				roomCart.setCseq(rs.getInt("cseq"));
				roomCart.setRseq(rs.getInt("rseq"));
				roomCart.setEmail(rs.getString("email"));
				roomCart.setMname(rs.getString("mname"));
				roomCart.setRkind(rs.getString("rkind"));
				roomCart.setMembernum(rs.getInt("membernum"));
				roomCart.setIndate(rs.getTimestamp("indate"));
				roomCart.setCheckin(rs.getDate("checkIn"));
				roomCart.setCheckout(rs.getDate("checkOut"));
				roomCart.setPrice(rs.getInt("price"));
				roomCart.setImage1(rs.getString("image1"));
				roomCart.setDonation(rs.getInt("donation"));
				roomCart.setResult(rs.getString("result"));
				
				roomCartList.add(roomCart);
			}
			return roomCartList;
			
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
	//							카트 담기
	//----------------------------------------------------------------
	public int roomCartInsert(RoomCartVo roomCartVo, String email) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO ROOMCART(EMAIL, RSEQ, MEMBERNUM, CHECKIN, CHECKOUT) VALUES(?,?,?,?,?)");
			pstmt.setString(1, email);
			pstmt.setInt(2, roomCartVo.getRseq());
			pstmt.setInt(3, roomCartVo.getMembernum());
			pstmt.setDate(4, roomCartVo.getCheckin());
			pstmt.setDate(5, roomCartVo.getCheckout());
			
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
	//						      카트상품 삭제
	//----------------------------------------------------------------
	public int roomCartDelete(int cseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM ROOMCART WHERE CSEQ =?");
			pstmt.setInt(1, cseq);
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

