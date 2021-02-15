package pagingPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.ReviewVo;

public class PagingDao {
	
	int totalContent = 0;// 전체 게시물 갯수
	int totalPage = 0;	// 총 페이지 수
	int countList = 10;	// 한 페이지에 출력 될 게시물
	int countPage= 10;	// 한 화면에 출력될 페이지 수
	
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public int[] paging(int page) throws Exception {
		//전체 게시물 갯수로 총 페이지 수 산출
		conn = ds.getConnection();
		
		String sql = "SELECT COUNT(*) FROM FREEBOARD";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			totalContent += rs.getInt(1);
		}
		
		if(totalContent == 0) {
			return null;	//하나도 없으면 null 리턴
		}
		
		totalPage = totalContent / countList; //게시물 갯수 / 한 페이지에 출력될 게시물수
		if(totalPage > 0) {
			totalPage++;	//게시물 갯수의 나머지가 있다면 더하기 1
		}
		
		//페이징 범위 계산
		int startPage = ((page-1) / countPage) * countPage +1;
		int endPage = startPage + countPage -1;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		int[] startEnd = new int[2];	//결과를 전달해줄 배열
		startEnd[0] = startPage;
		startEnd[1] = endPage;
		
		try {
			rs.close();
		} catch(Exception e) {
			throw e;
		}
		
		return startEnd;
	}
	
	//리스트 보기
	public int readList(int page) throws Exception {
		conn = ds.getConnection();
		
		try {
			
			int[] paging = paging(page);
			if (paging == null) {
				return -1;	//false 일 경우 -1 리턴
			}
			
			String sql = "SELECT * FROM "
					+ "(select rownum as rnum, A.*from"
					+ "(select * from board order by id desc) A )"
					+ "where runum >= ? and rnum <= ?";
					
			int startPage = (page -1) * countPage +1;	//시작 게시물
			int endPage = startPage * countPage;		//끝 게시물1
			
			pstmt.setInt(1, startPage);
			pstmt.setInt(2, endPage);
			rs = pstmt.executeQuery();
			
			ArrayList<ReviewVo> list = new ArrayList<>();
			while(rs.next()) {
				ReviewVo review = new ReviewVo();
				
			}
		} catch(Exception e) {
			throw e;
		}
		return 0;
		
	}
	
}
