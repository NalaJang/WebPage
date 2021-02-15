package pagingPractice;

public class practice1 {
	
	public static void main(String[] args) {
		
		int page = 25;			//현재 페이지
		int countList = 10;		//한 페이지에 출력 될 게시물
		int countPage = 10;		//한 화면에 출력될 페이지 수
		int totalCount = 225;	//전체 게시물 갯수
		
		int totalPage = totalCount/countList;
				
		if(totalCount / countList > 0) {
			totalPage ++;
		}
		
		if(page > totalPage) {	//현재 페이지가 마지막 페이지로
			page = totalPage;
		}
		
		int startPage = ((page -1) / countPage) * countPage +1;
		int endPage = startPage + countPage -1;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		if(startPage > 1) {
			System.out.println("<a href=\"?page=1\">처음</a>");
		}
		
		if(page > 1) {	//현재 페이지가 1보다 클 경우
			System.out.println("<a href=\"?page=" + (page - 1)  + "\">이전</a>");
		}
		
		//현재 페이지는 굵은 글씨체로 표시하고 <a> 태그를 빼기 위해 아래와 같이 처리도 가능
		for(int iCount = startPage; iCount <= endPage; iCount++) {
			if(iCount == page ) {	// 현재 페이지라면
				System.out.println(" <b>" + iCount + "</b>");
			} else {
				System.out.println(" " + iCount + " ");
			}
		}
		
		if(page < totalPage) {
			System.out.println("<a href=\"?page=" + (page + 1)  + "\">다음</a>");
		}
		
		if(endPage < totalPage) {
			System.out.println("<a href=\"?page=" + totalPage + "\">끝</a>");
		}
	}

}
