package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.PenguinBoardVo;
import projectControls.Component;

@Component("penguinDao")
public class PenguinBoardDao {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	//----------------------------------------------------------------
	//							    게시글 등록
	//----------------------------------------------------------------
	public void insert(PenguinBoardVo penguinVo, String email) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO PENGUINBOARD(SUBJECT, CONTENT, CONTENT2, IMAGE1, IMAGE2, IMAGE3, EMAIL) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, penguinVo.getSubject());
			pstmt.setString(2, penguinVo.getContent());
			pstmt.setString(3, penguinVo.getContent2());
			pstmt.setString(4, penguinVo.getImage1());
			pstmt.setString(5, penguinVo.getImage2());
			pstmt.setString(6, penguinVo.getImage3());
			pstmt.setString(7, penguinVo.getEmail());
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				
			} catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//							    게시글 목록
	//----------------------------------------------------------------
	public ArrayList<PenguinBoardVo> boardList() throws Exception {
		conn = ds.getConnection();
		ArrayList<PenguinBoardVo> boardList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM PENGUINBOARD ORDER BY NUM DESC");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PenguinBoardVo penguinVo = new PenguinBoardVo().setNum(rs.getInt("num"))
																.setReadcount(rs.getInt("readcount"))
																.setSubject(rs.getString("subject"))
																.setContent(rs.getString("content"))
																.setContent2(rs.getString("content2"))
																.setImage1(rs.getString("image1"))
																.setImage2(rs.getString("image2"))
																.setImage3(rs.getString("image3"))
																.setEmail(rs.getString("email"))
																.setIndate(rs.getTimestamp("indate"))
																.setMainyn(rs.getString("mainyn"));
				boardList.add(penguinVo);
			}
			
			return boardList;
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				
			} catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//							    메인 게시글 목록
	//----------------------------------------------------------------
	public ArrayList<PenguinBoardVo> boardList_main() throws Exception {
		ArrayList<PenguinBoardVo> boardList = new ArrayList<>();
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM PENGUINBOARD WHERE MAINYN = 'Y'");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PenguinBoardVo penguinVo = new PenguinBoardVo().setNum(rs.getInt("num"))
																.setSubject(rs.getString("subject"))
																.setImage1(rs.getString("image1"))
																.setImage2(rs.getString("image2"))
																.setImage3(rs.getString("image3"));
				boardList.add(penguinVo);
			}
			
			return boardList;
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				
			} catch(Exception e) {
				
			}
		}
	}
		
	//----------------------------------------------------------------
	//							    게시글 보기
	//----------------------------------------------------------------
	public PenguinBoardVo getBoard(int num) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE PENGUINBOARD SET READCOUNT = READCOUNT+1 WHERE NUM =?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("SELECT * FROM PENGUINBOARD WHERE NUM =?");
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
							return new PenguinBoardVo().setNum(rs.getInt("num"))
														.setSubject(rs.getString("subject"))
														.setContent(rs.getString("content"))
														.setContent2(rs.getString("content2"))
														.setImage1(rs.getString("image1"))
														.setImage2(rs.getString("image2"))
														.setImage3(rs.getString("image3"))
														.setIndate(rs.getTimestamp("indate"));
							
			}			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				
			} catch(Exception e) {
				
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//					  	 게시글 수정
	//----------------------------------------------------------------
	public int update(PenguinBoardVo boardVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement
					("UPDATE PENGUINBOARD SET SUBJECT =?, CONTENT =?, CONTENT2 =?, "
							+ "IMAGE1 =?, IMAGE2 =?, IMAGE3 =?, MAINYN =? WHERE NUM =?");
			
			pstmt.setString(1, boardVo.getSubject());
			pstmt.setString(2, boardVo.getContent());
			pstmt.setString(3, boardVo.getContent2());
			pstmt.setString(4, boardVo.getImage1());
			pstmt.setString(5, boardVo.getImage2());
			pstmt.setString(6, boardVo.getImage3());
			pstmt.setString(7, boardVo.getMainyn());
			pstmt.setInt(8, boardVo.getNum());
			
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				
			} catch(Exception e) {
				
			}
		}
	}
	
	//----------------------------------------------------------------
	//						게시글 삭제
	//----------------------------------------------------------------
	public int delete(int num) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM PENGUINBOARD WHERE NUM =?");
			pstmt.setInt(1, num);
			
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				
			} catch(Exception e) {
				
			}
		}
	}
}
