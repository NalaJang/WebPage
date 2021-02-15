package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.RoomInfoVo;
import projectControls.Component;

@Component("roomDao")
public class HotelRoomDao {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	//----------------------------------------------------------------
	//						객실 등록
	//----------------------------------------------------------------
	public int insert(RoomInfoVo room) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO ROOM(KIND, PRICE, CONTENT, IMAGE1, IMAGE2, IMAGE3, IMAGE4, DETAIL, DONATION) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, room.getKind());
			pstmt.setInt(2, room.getPrice());
			pstmt.setString(3, room.getContent());
			pstmt.setString(4, room.getImage1());
			pstmt.setString(5, room.getImage2());
			pstmt.setString(6, room.getImage3());
			pstmt.setString(7, room.getImage4());
			pstmt.setString(8, room.getDetail());
			pstmt.setInt(9, room.getDonation());
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//						객실 목록
	//----------------------------------------------------------------
	public ArrayList<RoomInfoVo> roomList() throws Exception {
		ArrayList<RoomInfoVo> roomList = new ArrayList<>();
		conn = ds.getConnection();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ROOM");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
								RoomInfoVo room = new RoomInfoVo();
								room.setRseq(rs.getInt("rseq"));
								room.setKind(rs.getString("kind"));
								room.setPrice(rs.getInt("price"));
								room.setContent(rs.getString("content"));
								room.setImage1(rs.getString("image1"));
								room.setImage2(rs.getString("image2"));
								room.setImage3(rs.getString("image3"));
								room.setImage4(rs.getString("image4"));
								room.setUseyn(rs.getString("useyn"));
								room.setIndate(rs.getTimestamp("indate"));
								room.setDetail(rs.getString("detail"));
								room.setDonation(rs.getInt("donation"));
								roomList.add(room);
			}
			return roomList;
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//						객실 상세페이지
	//----------------------------------------------------------------
	public RoomInfoVo room_detail(String kind) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ROOM WHERE KIND=?");
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new RoomInfoVo().setRseq(rs.getInt("rseq"))
										.setKind(rs.getString("kind"))
										.setPrice(rs.getInt("price"))
										.setContent(rs.getString("content"))
										.setImage1(rs.getString("image1"))
										.setImage2(rs.getString("image2"))
										.setImage3(rs.getString("image3"))
										.setImage4(rs.getString("image4"))
										.setDetail(rs.getString("detail"));
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
	//							객실 선택
	//----------------------------------------------------------------
	public RoomInfoVo selectOne(int rseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ROOM WHERE RSEQ=?");
			pstmt.setInt(1, rseq);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new RoomInfoVo().setRseq(rs.getInt("rseq"))
									   .setKind(rs.getString("kind"))
									   .setPrice(rs.getInt("price"))
									   .setContent(rs.getString("content"))
									   .setImage1(rs.getString("image1"))
									   .setImage2(rs.getString("image2"))
									   .setImage3(rs.getString("image3"))
									   .setImage4(rs.getString("image4"))
									   .setUseyn(rs.getString("useyn"))
									   .setDetail(rs.getString("detail"))
									   .setDonation(rs.getInt("donation"));
			}
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
		return null;
	}
	
	//----------------------------------------------------------------
	//							객실 정보 수정
	//----------------------------------------------------------------
	public int update(RoomInfoVo roomVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE ROOM SET KIND=?, PRICE=?, CONTENT=?, "
					+ "IMAGE1=?, IMAGE2=?, IMAGE3=?, IMAGE4=?, USEYN=?, DETAIL=?, DONATION=? WHERE RSEQ=?");
			
			pstmt.setString(1, roomVo.getKind());
			pstmt.setInt(2, roomVo.getPrice());
			pstmt.setString(3, roomVo.getContent());
			pstmt.setString(4, roomVo.getImage1());
			pstmt.setString(5, roomVo.getImage2());
			pstmt.setString(6, roomVo.getImage3());
			pstmt.setString(7, roomVo.getImage4());
			pstmt.setString(8, roomVo.getUseyn());
			pstmt.setString(9, roomVo.getDetail());
			pstmt.setInt(10, roomVo.getDonation());
			pstmt.setInt(11, roomVo.getRseq());
			
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//							객실 삭제
	//----------------------------------------------------------------
	public int delete(int rseq) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM ROOM WHERE RSEQ=?");
			pstmt.setInt(1, rseq);
			
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				
			}
		}
	}
}
