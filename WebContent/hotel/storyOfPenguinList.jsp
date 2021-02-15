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
		padding-bottom : 300px;
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
		margin : 0 auto;
		padding-left : 570px;
	}
	
	.board2 a {
		color : black;
		text-decoration : none;
	}
	
	.left {
		border-bottom : 1px solid grey;
	}
	
	.left, .right {
		padding-top : 10px;
		padding-bottom : 10px;
	}
	
	.board1, .board2 {
		padding-top : 50px;
	}
	
	img {
		width : 200px;
	}
	
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<div class = "container">

	<div class = "row ment">
		펭귄의 이야기
	</div>
	
	<c:choose>	
		<c:when test = "${boardList.size() == 0}">
			<div class = "row board1">
				아직 작성된 글이 없습니다.
			</div>
		</c:when>
		
		<c:otherwise>
			<div class = "row board2">
					
					<c:forEach var = "list" items = "${boardList}">
						<div class = "col-6 left">
							
							<a href = "storyOfPenguinContent.do?num=${list.num}">
								
								<!-- 주제 -->
								<b>${list.subject}</b><br>
								
								<!-- 작성일 -->
								<fmt:formatDate value = "${list.indate}" pattern = "yy-MM-dd"/>
								
								<!-- 조회수 -->
								조회수 ${list.readcount}
							</a>
						</div>
							
						<div class = "col-6 right">
							
							<a href = "storyOfPenguinContent.do?num=${list.num}">
							
								<!-- 이미지 -->
								<img src = "http://localhost:8080/project/hotel/img/${list.image1}">
							
							</a>
						</div>
					</c:forEach>
			</div>

		</c:otherwise>
	</c:choose>
	
</div>

<jsp:include page = "/hotel/hotelTail.jsp"/>

</body>
</html>