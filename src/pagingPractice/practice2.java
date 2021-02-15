package pagingPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.protocol.x.Notice;

import hotelDto.NoticeVo;

public class practice2 {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public List<Notice> getNoticeList() throws Exception{
		
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page) throws Exception{
		List<Notice> list = new ArrayList<>();
		conn = ds.getConnection();
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE '%"+query+"%'ORDER BY REGDATE DESC) N WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1+ (page-1) * 10);
			pstmt.setInt(2, page * 10);
			
			rs = pstmt.getResultSet();
			while(rs.next()) {
				
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				NoticeVo notice = new NoticeVo(
						id,
						title,
						writerId,
						regdate,
						hit,
						files,
						content
						);
//				list.add(notice);
				
			}
		} catch(Exception e) {
			throw e;
		}
		return list;
	}
	
	public List<Notice> getNoticeList(int page) throws Exception{
		
		return getNoticeList("title", "", page);
	}

	public int getNoticeCount() throws Exception {
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) throws Exception{
		
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM (SELECT ROWNUM NUM, N.* FROM(SELECT * FROM NOTICE WHERE "+ field +" LIKE '%"+query+"%' ORDER BY REGDATE DESC)N) ";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		count = rs.getInt("count");
		return count;
	}
	
	public Notice getNotice(int id) throws Exception { //detail
		
		Notice notice = null;
		
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				/*
				NoticeVo = new NoticeVo(
						nid,
						title,
						writerId,
						regdate,
						hit,
						files,
						content
						);	
						*/			
			}
			
		} catch(Exception e) {
			throw e;
		}
		return notice;
	}
	
	public Notice getNextNotice(int id) throws Exception {
		
		String sql = "SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID =?) AND ROWNUM =1)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			
		} catch(Exception e) {
			throw e;
		}
		return null;
	}
	
	public Notice getPrevNotice(int id) throws Exception  {
		String sql = "SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?) AND ROWNUM = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			
		} catch(Exception e) {
			throw e;
		}
		return null;
	}
}
