<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
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
		padding-top : 100px;
		padding-bottom : 300px;
	}
	
	.menu {
		color : black;
		font-size : 25px;
		padding : 10px;
		text-decoration : none;
	}
	
	.menu b {
		padding-left : 200px;
	}
	
	.menu ul {
		margin : 15px;
		padding-top : 30px;
		padding-left : 190px;
		list-style-type: none;
	}
	
	.menu ul a {				
		border-bottom : 1px solid grey;
	}
	
	.menu a:hover {
		background-color : #ddd;
	}
	
	.product img {
		width : 300px;
	}
	
	.name, .price {
		text-align : center;
	}
	
	.price {
		padding-bottom : 50px;
	}
	
	.menu ul, .img {
		margin : 15px;
	}
	
	.menu ul a, .name a {
		color : black;
		text-decoration: none;
	}

	
</style>

</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<div class = "container">
	<div class = "row">
	
		<div class = "col-4 menu">
			<div class = "row">
				<b>카테고리</b>
			</div>
			
			<div>
				<ul>
					<li><a href = "shopProductCatagory.do?kind=1">주방</a></li>
					<li><a href = "shopProductCatagory.do?kind=2">욕실</a></li>
					<li><a href = "shopProductCatagory.do?kind=3">여행</a></li>
					<li><a href = "shopProductCatagory.do?kind=4">음료</a></li>
				</ul>
			</div>
		</div>
	
		<div class = "col-8 products">
		

			<div class = "row product">
			
					<c:forEach var = "catagory" items = "${catagory}">					
						<div class = "col-4">
						
							<div class = "img">
								<a href = "shopProductDetail.do?pseq=${catagory.pseq}"><img src = "http://localhost:8080/project/hotel/img/${catagory.image1}" alt = "${catagory.name}"></a>
							</div>
							
							<div class = "name">
								<a href = "shopProductDetail.do?pseq=${catagory.pseq}"><b>${catagory.name}</b></a>
							</div>
							
							<div class = "price">
								&#8361;<fmt:formatNumber value = "${catagory.price2}" pattern = "#,###"/>
							</div>
										
						</div>
					</c:forEach>
			</div>
		</div>
	<%-- 		<c:forEach var = "productList" items = "${productList}"> --%>
	<%-- 			<a href = "shopProductCatagory.do?kind=${productList.kind}"> --%>
	<%-- 				<c:choose> --%>
	<%-- 					<c:when test = "${productList.kind eq 1}">${productList}</c:when> --%>
	<%-- 					<c:when test = "${productList.kind eq 2}">욕실</c:when> --%>
	<%-- 					<c:when test = "${productList.kind eq 3}">여행</c:when> --%>
	<%-- 					<c:when test = "${productList.kind eq 4}">음료</c:when> --%>
	<%-- 				</c:choose> --%>
	<!-- 			</a><p> -->
				
	<%-- 			<a href = "shopProductDetail.do?pseq=${productList.pseq}">${productList.name}</a> --%>
				
				
	<%-- 		</c:forEach> --%>

	</div>
</div>


	

</body>

<jsp:include page="/hotel/hotelTail.jsp"/>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>