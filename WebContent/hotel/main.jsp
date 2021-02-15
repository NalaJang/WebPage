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
		min-width : 1400px;
		padding-top : 50px;
		padding-bottom : 300px;
	}
	
	.mainImage img {
		padding-bottom : 30px;
	}
	
	.middle {
		padding-bottom : 60px;
	}
	
	.ment {
		padding-left : 20px;
		font-size : 25px;
		color : rgb(56, 116, 70);
		padding-bottom : 30px;
	}
	
	.col-4 a {
		color : black;
	}
	
	.col-4 img {
		width : 450px;
		height : 250px;
	}
	
	.bestItem {
		padding-bottom : 30px;
	}
	
	.bestItem img {
		width : 300px;
	}
	
</style>

<script>

	/* window.onload =function () {
	   window.open("popUp.jsp",  "popupNo1", "width=630, height=680");
	} */
	
</script>
</head>

<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" method = "post">

<div class = "container">
	
	<div class = "mainImage">
		<img src = "http://localhost:8080/project/hotel/img/step.jpg" style = "width : 100%;">
	</div>
	
	<div class = "row middle">
		<div class = "col-4">
			<img src = "http://localhost:8080/project/hotel/img/전기차대여.jpg">
		</div>
		
		<!-- 객실 -->
		<div class = "col-4">
			<div>
				<img src = "http://localhost:8080/project/hotel/img/디럭스.jpg">
			</div>
			
			<div>
				<a href = "roomDetail.do?kind=1">객실 더 보기 ></a>
			</div>
		</div>
	</div>
	
	<div class = "row ment">
		<b>환경을 생각한 소비 ></b>
	</div>
	
	<!----- 베스트 제품 ---->
	<div class = "row bestItem">
		<c:forEach var = "bestItem" items = "${bestItem}">
			<div class = "col-3">
				<a href = "shopProductDetail.do?pseq=${bestItem.pseq}">
				<img src = "http://localhost:8080/project/hotel/img/${bestItem.image1}"></a>
			
				<span><b>${bestItem.name}</b></span><br>
				<span>&#8361;<fmt:formatNumber value = "${bestItem.price2}" pattern = "#,###"/></span>
			</div>
			 
		</c:forEach>
	</div>
	
	
	<div class = "row ment">
		<b>행동을 통한 긍정적인 변화 ></b>
	</div>
	
	<div class = "row bottom">
		
		<c:forEach var = "boardList" items = "${boardList}">
		
			<!-- 펭귄이야기  -->
			<div class = "col-4">
				<a href = "storyOfPenguinContent.do?num=${boardList.num}">
					<img src = "http://localhost:8080/project/hotel/img/${boardList.image1}">
				</a>
			</div>
			
		</c:forEach>
	</div>


</div>

</form>
<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>