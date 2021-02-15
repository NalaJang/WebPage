package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hotelDto.CartVo;
import projectControls.Component;

@Component("cartDao")	//component("키 값")
public class ShopCartDao {

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
	public List<CartVo> cartList(String email) throws Exception {

		conn = ds.getConnection();
		
		List<CartVo> cartList = new ArrayList<>();
		String sql = "SELECT * FROM CART_view WHERE EMAIL= ? order by cseq desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartVo cart = new CartVo();
				cart.setCseq(rs.getInt("cseq"));
				cart.setEmail(rs.getString("email"));
				cart.setPseq(rs.getInt("pseq"));
				cart.setMname(rs.getString("mname"));
				cart.setPname(rs.getString("pname"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setPrice2(rs.getInt("price2"));
				cart.setIndate(rs.getTimestamp("indate"));
				cart.setImage1(rs.getString("image1"));
				
				cartList.add(cart);
			}
			return cartList;
			
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
			} catch (Exception e) {

			}
		}
		
	}
	
	//----------------------------------------------------------------
	//							카트 담기
	//----------------------------------------------------------------
	public int cartInsert(String email, int pseq, int quantity) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO CART(EMAIL, PSEQ, QUANTITY) VALUES(?,?,?)");
			pstmt.setString(1, email);
			pstmt.setInt(2, pseq);			
			pstmt.setInt(3, quantity);
			
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
	//						      카트상품 삭제
	//----------------------------------------------------------------
	public int cartDelete(int cseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM CART WHERE CSEQ =?");
			pstmt.setInt(1, cseq);
			
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
	//						      카트상품 선택 삭제
	//----------------------------------------------------------------
	public int cartDelete_choice(List<Integer> pseq, List<Integer> quantity) throws Exception {
		conn = ds.getConnection();
		
		try {
			
			for(int i = 0; i<pseq.size(); i++) {
				
				pstmt = conn.prepareStatement("DELETE FROM CART WHERE PSEQ =? AND QUANTITY =?");
				pstmt.setInt(1, pseq.get(i));
				pstmt.setInt(2, quantity.get(i));
				
				return pstmt.executeUpdate();
			}
			

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
		return -1;
	}
}
