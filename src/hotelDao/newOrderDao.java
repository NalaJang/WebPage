package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hotelDto.OrderVo;
import projectControls.Component;

@Component("orderDao")
public class newOrderDao {

	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	//----------------------------------------------------------------
	//							주문 추가
	//----------------------------------------------------------------
	public int addOrder(String email) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {			
			pstmt = conn.prepareStatement("INSERT INTO ORDERS(EMAIL) VALUES(?)");
			pstmt.setString(1, email);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}
	
	//----------------------------------------------------------------
	//							주문 추가(바로 구매)
	//----------------------------------------------------------------
	public int addOrder_direct(String email) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO ORDERS(EMAIL) VALUES(?)");
			pstmt.setString(1, email);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	//----------------------------------------------------------------
	//							주문 번호 가져오기
	//----------------------------------------------------------------
	public int getOseq(String email) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = ds.getConnection();
		
		int oseq = 0;
		try {
			pstmt = conn.prepareStatement("SELECT OSEQ FROM ORDERS WHERE EMAIL=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("oseq") > oseq) {	//max 값(최근주문) 가져오기
					oseq = rs.getInt("oseq");
				}
			}
			
			return oseq;
			
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
	//							주문 번호 가져오기(2)
	//----------------------------------------------------------------	
	public int getOdseq(int odseq) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ORDERS WHERE ODSEQ =?");
			pstmt.setInt(1, odseq);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderVo OrderVo = new OrderVo();
				OrderVo.setOdseq(rs.getInt("odseq"));
				OrderVo.setOseq(rs.getInt("oseq"));
				OrderVo.setEmail(rs.getString("email"));
				OrderVo.setIndate(rs.getTimestamp("indate"));
				OrderVo.setPseq(rs.getInt("pseq"));
				OrderVo.setQuantity(rs.getInt("quantity"));
				OrderVo.setMname(rs.getString("mname"));
				OrderVo.setZip_num(rs.getString("zip_num"));
				OrderVo.setPhone(rs.getString("phone"));
				OrderVo.setAddress1(rs.getString("address1"));
				OrderVo.setAddress2(rs.getString("address2"));
				OrderVo.setPname(rs.getString("pname"));
				OrderVo.setPrice2(rs.getInt("price2"));
				OrderVo.setImage1(rs.getString("image1"));
				OrderVo.setResult(rs.getString("result"));
				
			}
			
			
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
		return 0;
	}
	
	//----------------------------------------------------------------
	//						주문 후 장바구니 주문상품 없애기
	//----------------------------------------------------------------
	public int newUpdateCart(String email, List<Integer> pseq) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			
			for(int i = 0; i<pseq.size(); i++) {
				pstmt = conn.prepareStatement("UPDATE CART SET RESULT = 2 WHERE EMAIL =? AND PSEQ=?");
				
				pstmt.setString(1, email);
				pstmt.setInt(2, pseq.get(i));
				
				return pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return -1;
	}

	//----------------------------------------------------------------
	//							주문 내역
	//----------------------------------------------------------------
	public ArrayList<OrderVo> orderList(String email) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = ds.getConnection();
		
		ArrayList<OrderVo> orderList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ORDER_VIEW WHERE EMAIL=? order by oseq desc");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while (rs.next()) { // 주문수가 다수라서 while 로
				OrderVo OrderVo = new OrderVo();
				OrderVo.setOdseq(rs.getInt("odseq"));
				OrderVo.setOseq(rs.getInt("oseq"));
				OrderVo.setEmail(rs.getString("email"));
				OrderVo.setIndate(rs.getTimestamp("indate"));
				OrderVo.setPseq(rs.getInt("pseq"));
				OrderVo.setQuantity(rs.getInt("quantity"));
				OrderVo.setMname(rs.getString("mname"));
				OrderVo.setZip_num(rs.getString("zip_num"));
				OrderVo.setPhone(rs.getString("phone"));
				OrderVo.setAddress1(rs.getString("address1"));
				OrderVo.setAddress2(rs.getString("address2"));
				OrderVo.setPname(rs.getString("pname"));
				OrderVo.setPrice2(rs.getInt("price2"));
				OrderVo.setImage1(rs.getString("image1"));
				OrderVo.setResult(rs.getString("result"));
				orderList.add(OrderVo);
			}
			return orderList;
			
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
	//							주문 상세내역
	//----------------------------------------------------------------
	public int newOrder_detail(int oseq, List<Integer> pseq, List<Integer> quantity) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			for(int i = 0; i<pseq.size(); i++) {
				pstmt = conn.prepareStatement("INSERT INTO ORDER_DETAIL(OSEQ, PSEQ, QUANTITY) VALUES(?,?,?)");
				pstmt.setInt(1, oseq); //고유의 주문번호 이기 때문에 get(i) X
				pstmt.setInt(2, pseq.get(i));
				pstmt.setInt(3, quantity.get(i));
			
				return pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return -1;
	}
	
	//----------------------------------------------------------------
	//							주문 상세내역(바로 구매시)
	//----------------------------------------------------------------
	public int newOrder_detail_direct(int oseq, int pseq, int quantity) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement("INSERT INTO ORDER_DETAIL(OSEQ, PSEQ, QUANTITY) VALUES(?,?,?)");
			pstmt.setInt(1, oseq);
			pstmt.setInt(2, pseq);
			pstmt.setInt(3, quantity);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	//----------------------------------------------------------------
	//						   회원 모두의 주문 내역
	//----------------------------------------------------------------
	public ArrayList<OrderVo> orderListAll() throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = ds.getConnection();
		
		ArrayList<OrderVo> orderList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ORDER_VIEW");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
								OrderVo order = new OrderVo();
								order.setOdseq(rs.getInt("odseq"));
								order.setOseq(rs.getInt("oseq"));
								order.setEmail(rs.getString("email"));
								order.setIndate(rs.getTimestamp("indate"));
								order.setPseq(rs.getInt("pseq"));
								order.setQuantity(rs.getInt("quantity"));
								order.setMname(rs.getString("mname"));
								order.setZip_num(rs.getString("zip_num"));
								order.setPhone(rs.getString("phone"));
								order.setAddress1(rs.getString("address1"));
								order.setAddress2(rs.getString("address2"));
								order.setPname(rs.getString("pname"));
								order.setPrice2(rs.getInt("price2"));
								order.setResult(rs.getString("result"));
								orderList.add(order);
				
			}
			return orderList;
			
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
	//						   주문현황 업데이트
	//----------------------------------------------------------------
	public int updateResult(int odseq) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE ORDER_VIEW SET RESULT =2 WHERE odseq =?");
			pstmt.setInt(1, odseq);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	//----------------------------------------------------------------
	//						      주문상품 취소
	//----------------------------------------------------------------
	public int ordertDelete(int oseq) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM ORDERS WHERE OSEQ =?");
			pstmt.setInt(1, oseq);
			
			return pstmt.executeUpdate();

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
	//						   구매 확정
	//----------------------------------------------------------------
	public int updateResult2(int odseq) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE ORDER_VIEW SET RESULT =3 WHERE odseq =?");
			pstmt.setInt(1, odseq);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}
}
