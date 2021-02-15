<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri =  "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		min-width : 1600px;
		text-align : center;
		padding-top : 50px;
		padding-bottom : 300px;
	}
	
	.ment {
		font-size : 35px;
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	.menu {
		font-size : 20px;
	}
	
	.middle {
		padding-top : 30px;
	}
	
	.order {
		padding-top : 50px;
	}
	
	.order a {
		color : black;
	}
	
	.order1 {
		padding-top : 50px;
		font-size : 20px;
	}
	
	img {
		width : 150px;
	}
	
	.result {
		font-weight : bold;
		color : orange; 
	}
	
	.result2 {
		font-weight : bold;
		color : rgb(56, 116, 70);
	}
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<form name = "frm" method = "post">
<div class = "container">

	<div class = "row middle">
	
		<div class = "col-4 menu">
		
			<div class = "row ment">
				주문내역
			</div>	
		
			<p><a href = "shopCartList.do">장바구니	 </a></p>
			<p><a href = "shopRoomCartList.do">방바구니</a></p>
			<p><a href = "shopOrderList2.do">주문내역	 </a></p>
			<p><a href = "reservationList.do">예약내역	 </a></p>
		</div>
		
		<div class = "col-5 order">
			<c:choose>
				<c:when test = "${orderList.size() ==0}">
					<div class = "order1">
						<b>주문내역이 없습니다.</b>
					</div>
				</c:when>
				
				<c:otherwise>
					<table border = "1" style = "width : 900px;">
						<tr>
							<th colspan = "2">상품</th>
							<th>수량				 </th>
							<th>가격				 </th>
							<th>주문일			 </th>
							<th>상태				 </th>
						</tr>
						
						<c:forEach var = "orderList" items = "${orderList}">
							<tr>
								<!-- 상품명 -->
								<td>
									<a href = "shopProductDetail.do?pseq=${orderList.pseq}">${orderList.pname}</a>
								</td>
								
								<!-- 상품이미지 -->
								<td>
									<a href = "shopProductDetail.do?pseq=${orderList.pseq}">
										<img src = "http://localhost:8080/project/hotel/img/${orderList.image1}">
									</a>
								</td>
								
								<!-- 상품수량 -->
								<td>${orderList.quantity}</td>
								
								<!-- 상품가격 -->
								<td>&#8361;<fmt:formatNumber value = "${orderList.price2 * orderList.quantity}" pattern = "#,###"/></td>
								
								<!-- 주문날짜 -->
								<td><fmt:formatDate value = "${orderList.indate}" pattern = "yy-MM-dd"/></td>
								
								<!-- 처리현황 -->
								<td>
									<c:choose>
										<c:when test = "${orderList.result eq 1}">
											배송준비중
											<div><a href = "shopOrderDelete.do?oseq=${orderList.oseq}">[취소]</a></div>
										
										</c:when>
										
										<c:when test = "${orderList.result eq 2}">
											<div class = "result">배송중</div>
											<a href = "orderConfirm.do?odseq=${orderList.odseq}">[구매확정]</a>
										</c:when>
										
										<c:otherwise>
											<div class = "result2">구매완료</div>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</form>
</body>
</html>