<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


<style>
	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 300px;
	}
	
	.img {
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	img {
		width : 900px;
	}
	
	.subject {
		font-size : 35px;
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	.content {
		padding-left : 170px;
		border-bottom : 1px solid grey;
	}
		
	.content span {
		font-weight : 400;
	}
	
	.list {
		padding-top : 50px;
		padding-left : 170px;
	}
	
	.list a {
		color : black;
	}
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<div class = "container">
	
		<!-- 제목 -->
		<div class = "row subject">
			<b>${board.subject}</b>
		</div>
		
		<div class = "row content">
		
			<!-- 이미지 -->
			<div class = "img">
				<img src = "${board.image1}">
			</div>
			
			<ul>
				<!-- 내용 -->
				<c:forTokens var = "content" items = "${board.content}" delims = "^">
					<p>${content}</p>
				</c:forTokens>
			</ul>
			
			<!-- 이미지 -->
			<div class = "img">
				<img src = "${board.image2}">
			</div>
			
			<ul>
				<!-- 내용 -->
				<c:forTokens var = "content2" items = "${board.content2}" delims = "^">
					<p>${content2}</p>
				</c:forTokens>
			</ul>
			<p>&nbsp;</p>
			
			<!-- 이미지 -->
			<div class = "img">
				<img src = "${board.image3}" alt = "">
			</div>
			
		</div>
	
	<!-- 글 목록 -->
	
	<div class = "list">
		<b>다른글</b><br>
		<c:forEach var = "boardList" items = "${boardList}">
			<c:if test = "${boardList.subject eq board.subject}"> [현재글] </c:if>
			<a href = "storyOfPenguinContent.do?num=${boardList.num}">${boardList.subject}</a><br>
		</c:forEach>
	</div>
</div>

<jsp:include page="/hotel/hotelTail.jsp"/>
</body>




<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>