<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 600px;
	}
	
	.ment {
		font-size : 35px;
		padding-left : 170px;
	}
	
	.board1 {
		font-size : 25px;
		padding-left : 570px;
	}
	
	.board2 {
		padding-left : 570px;
		text-align : center;
	}
	
	.board2 a {
		color : black;
		text-decoration : none;
	}
	
	.board1, .board2 {
		padding-top : 50px;
	}
	
	.list {
		margin : 30px;
		padding-left : 700px;
	}
	.list.pageNum a {
		margin : 20px;
	}
	
	.pageNum {
		color : orange;
		font-weight : bold;
	}
	
	.btn.next {
		padding-left : 700px;
	}
	
	.row.btn {
		margin-top : 30px;
		margin-left : 950px;
	}
	
	.btn button{
		color : white;
		width : 200px;
		padding: 5px;
		background-color : rgb(56, 116, 70);
	}
	
	.btn:hover button {
		color : rgb(56, 116, 70);
		background-color : white;
	}
	
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<div class = "container">

	<div class = "row ment">
		여행 후기
	</div>
	
	<c:choose>	
		<c:when test = "${hotelReviewList.size() == 0}">
			<div class = "row board1">
				아직 작성된 글이 없습니다.
			</div>
		</c:when>
		
		<c:otherwise>
			<div class = "row board2">
				<table border = "1" style = "width : 600px;">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					
					<c:forEach var = "review" items = "${hotelReviewList}">					
					<tr>
						<!-- 번호 -->
						<td>${review.qseq}</td>
						
						<!-- 제목 -->
						<td style = "width : 200px;"><a href = "hotelReviewContent.do?qseq=${review.qseq}">${review.subject}</a>
							
						</td>
						
						<!-- 작성자 -->
						<td>${review.name}</td>
						
						<!-- 작성일 -->
						<td><fmt:formatDate value = "${review.indate}" pattern = "yy.MM.dd hh:mm"/></td>
						
						<!-- 조회수 -->
						<td>${review.views}</td>
					</tr>					
					</c:forEach>
					
				</table>
			</div>

		</c:otherwise>
	
	</c:choose>
	
	<div class = "row btn">
		<button type = "button" onclick = "location.href = 'hotelReviewInsertForm.do'">후기 작성하기</button>
	</div>
	
</div>

<jsp:include page = "/hotel/hotelTail.jsp"/>

</body>
</html>