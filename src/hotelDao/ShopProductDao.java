package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.ProductVo;
import projectControls.Component;

@Component("productDao")
public class ShopProductDao {
		
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	//----------------------------------------------------------------
	//						상품 등록
	//----------------------------------------------------------------
	public int insert(ProductVo productVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement
					("INSERT INTO PRODUCT(NAME, KIND, PRICE1, PRICE2, CONTENT, IMAGE1, IMAGE2, IMAGE3, IMAGE4, USEYN, BESTYN, DETAIL, DETAIL2, STOCK) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, productVo.getName());
			pstmt.setString(2, productVo.getKind());
			pstmt.setInt(3, productVo.getPrice1());
			pstmt.setInt(4, productVo.getPrice2());
			pstmt.setString(5, productVo.getContent());
			pstmt.setString(6, productVo.getImage1());
			pstmt.setString(7, productVo.getImage2());
			pstmt.setString(8, productVo.getImage3());
			pstmt.setString(9, productVo.getImage4());
			pstmt.setString(10, productVo.getUseyn());
			pstmt.setString(11, productVo.getBestyn());
			pstmt.setString(12, productVo.getDetail());
			pstmt.setString(13, productVo.getDetail2());
			pstmt.setInt(14, productVo.getStock());
			
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
				e.printStackTrace();
			}
		}
	}
	
	//----------------------------------------------------------------
	//						상품 목록
	//----------------------------------------------------------------
	public ArrayList<ProductVo> productList() throws Exception {
		ArrayList<ProductVo> productList = new ArrayList<ProductVo>();
		conn = ds.getConnection();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo product = new ProductVo();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setPrice1(rs.getInt("price1"));
				product.setPrice2(rs.getInt("price2"));
				product.setContent(rs.getString("content"));
				product.setImage1(rs.getString("image1"));
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setUseyn(rs.getString("useyn"));
				product.setBestyn(rs.getString("bestyn"));
				product.setIndate(rs.getTimestamp("indate"));
				product.setDetail(rs.getString("detail"));
				product.setDetail2(rs.getString("detail2"));
				product.setStock(rs.getInt("stock"));
				
				productList.add(product);
			}
			return productList;
			
		} catch(SQLException e) {
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
				e.printStackTrace();
			}
		}
		
	}
	
	//----------------------------------------------------------------
	//						상품 삭제
	//----------------------------------------------------------------
	public int delete(int pseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM PRODUCT WHERE PSEQ=?");	
			pstmt.setInt(1, pseq);
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
				e.printStackTrace();
			}
		}
	}
	
	//----------------------------------------------------------------
	//						새로운 상품
	//----------------------------------------------------------------
	public ArrayList<ProductVo> listNewProduct() throws Exception {
		ArrayList<ProductVo> productList = new ArrayList<ProductVo>();
		conn = ds.getConnection();
		
		String sql = "select * from app.new_pro_view";
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				ProductVo product = new ProductVo();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage1(rs.getString("image1"));
				productList.add(product);
			}
			return productList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//						이달의 제품(베스트 상품)
	//----------------------------------------------------------------
	public ArrayList<ProductVo> listBestProduct() throws Exception {
		ArrayList<ProductVo> productList = new ArrayList<ProductVo>();
		conn = ds.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement("select * from best_pro_view");
			rs= pstmt.executeQuery();
			while(rs.next()) {
				ProductVo bestItem = new ProductVo();
				bestItem.setPseq(rs.getInt("pseq"));
				bestItem.setName(rs.getString("name"));
				bestItem.setPrice2(rs.getInt("price2"));
				bestItem.setContent(rs.getString("content"));
				bestItem.setImage1(rs.getString("image1"));
				productList.add(bestItem);
			}
			return productList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//						상품 항목 선택
	//----------------------------------------------------------------
	public ArrayList<ProductVo> selectCatagory(String kind) throws Exception {
		ArrayList<ProductVo> productList = new ArrayList<ProductVo>();
		conn = ds.getConnection();

		String sql = "SELECT * FROM PRODUCT WHERE KIND= ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo product = new ProductVo();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setPrice2(rs.getInt("price2"));
				product.setContent(rs.getString("content"));
				product.setImage1(rs.getString("image1"));
				
				productList.add(product);
			}
			
			return productList;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//						상품 상세페이지
	//----------------------------------------------------------------
	public ProductVo product_detail(int pseq) throws Exception {
		conn = ds.getConnection();
		
		String sql = "SELECT * FROM PRODUCT WHERE pseq=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				return new ProductVo()
						.setPseq(rs.getInt("pseq"))
						.setName(rs.getString("name"))
						.setKind(rs.getString("kind"))
						.setPrice1(rs.getInt("price1"))
						.setPrice2(rs.getInt("price2"))
						.setContent(rs.getString("content"))
						.setImage1(rs.getString("image1"))
						.setImage2(rs.getString("image2"))
						.setImage3(rs.getString("image3"))
						.setImage4(rs.getString("image4"))
						.setUseyn(rs.getString("useyn"))
						.setBestyn(rs.getString("bestyn"))
						.setDetail(rs.getString("detail"))
						.setDetail2(rs.getString("detail2"))
						.setStock(rs.getInt("stock"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//								상품 선택
	//----------------------------------------------------------------
	public ProductVo selectOne(int pseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PSEQ =?");
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new ProductVo().setName(rs.getString("name"))
									  .setKind(rs.getString("kind"))
									  .setPrice1(rs.getInt("price1"))
									  .setPrice2(rs.getInt("price2"))
									  .setContent(rs.getString("content"))
									  .setImage1(rs.getString("image1"))
									  .setImage2(rs.getString("image2"))
									  .setImage3(rs.getString("image3"))
									  .setImage4(rs.getString("image4"))
									  .setUseyn(rs.getString("useyn"))
									  .setBestyn(rs.getString("bestyn"))
									  .setIndate(rs.getTimestamp("indate"))
									  .setDetail(rs.getString("detail"))
									  .setDetail2(rs.getString("detail2"))
									  .setStock(rs.getInt("stock"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//								상품 수정
	//----------------------------------------------------------------
	public int update(ProductVo productVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement
					("UPDATE PRODUCT SET NAME=?, KIND=?, PRICE1=?, PRICE2=?, CONTENT=?, IMAGE1=?, IMAGE2=?, IMAGE3=?, IMAGE4=?, "
							+ "USEYN=?, BESTYN=?, DETAIL=?, DETAIL2=?, STOCK=? WHERE PSEQ=?");
			
			pstmt.setString(1, productVo.getName());
			pstmt.setString(2, productVo.getKind());
			pstmt.setInt(3, productVo.getPrice1());
			pstmt.setInt(4, productVo.getPrice2());
			pstmt.setString(5, productVo.getContent());
			pstmt.setString(6, productVo.getImage1());
			pstmt.setString(7, productVo.getImage2());
			pstmt.setString(8, productVo.getImage3());
			pstmt.setString(9, productVo.getImage4());
			pstmt.setString(10, productVo.getUseyn());
			pstmt.setString(11, productVo.getBestyn());
			pstmt.setString(12, productVo.getDetail());
			pstmt.setString(13, productVo.getDetail2());
			pstmt.setInt(14, productVo.getStock());
			pstmt.setInt(15, productVo.getPseq());
			
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
				e.printStackTrace();
			}
		}
	}
}
