package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.CampaignVo;
import projectControls.Component;

@Component("campaignDao")
public class CampaignDao {

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
	public void insert(CampaignVo campaignVo, String email) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO CAMPAIGN(SUBJECT, CONTENT, CONTENT2, IMAGE1, IMAGE2, IMAGE3, EMAIL) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, campaignVo.getSubject());
			pstmt.setString(2, campaignVo.getContent());
			pstmt.setString(3, campaignVo.getContent2());
			pstmt.setString(4, campaignVo.getImage1());
			pstmt.setString(5, campaignVo.getImage2());
			pstmt.setString(6, campaignVo.getImage3());
			pstmt.setString(7, campaignVo.getEmail());
			
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
	public ArrayList<CampaignVo> boardList() throws Exception {
		conn = ds.getConnection();
		ArrayList<CampaignVo> boardList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM CAMPAIGN ORDER BY NUM DESC");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CampaignVo campaignVo = new CampaignVo().setNum(rs.getInt("num"))
																.setReadcount(rs.getInt("readcount"))
																.setSubject(rs.getString("subject"))
																.setContent(rs.getString("content"))
																.setContent2(rs.getString("content2"))
																.setImage1(rs.getString("image1"))
																.setImage2(rs.getString("image2"))
																.setImage3(rs.getString("image3"))
																.setEmail(rs.getString("email"))
																.setIndate(rs.getTimestamp("indate"));
				boardList.add(campaignVo);
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
	public CampaignVo getBoard(int num) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE CAMPAIGN SET READCOUNT = READCOUNT+1 WHERE NUM =?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("SELECT * FROM CAMPAIGN WHERE NUM =?");
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
							return new CampaignVo().setNum(rs.getInt("num"))
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
	public int update(CampaignVo campaignVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement
					("UPDATE CAMPAIGN SET SUBJECT =?, CONTENT =?, CONTENT2 =?, "
							+ "IMAGE1 =?, IMAGE2 =?, IMAGE3 =? WHERE NUM =?");
			
			pstmt.setString(1, campaignVo.getSubject());
			pstmt.setString(2, campaignVo.getContent());
			pstmt.setString(3, campaignVo.getContent2());
			pstmt.setString(4, campaignVo.getImage1());
			pstmt.setString(5, campaignVo.getImage2());
			pstmt.setString(6, campaignVo.getImage3());
			pstmt.setInt(8, campaignVo.getNum());
			
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
			pstmt = conn.prepareStatement("DELETE FROM CAMPAIGN WHERE NUM =?");
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
