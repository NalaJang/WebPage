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
	
	.cart {
		padding-top : 50px;
	}
	
	.cart a {
		color : black;
	}
	
	.cart1 {
		padding-top : 50px;
		font-size : 20px;
	}
	
	img {
		width : 200px;
	}
	
	.delete {
		padding-top : 30px;
		padding-left : 550px;
	}
	
/* 	.total { */
/* 		padding-top : 30px; */
/* 		padding-left : 900px; */
/* 	} */
	
	.total b{
		font-size : 20px;
	}
	
	.total {
		margin : 20px;
		padding-top : 50px;
		padding-left : 550px;
	}
	
	.row.btn {
		margin-left : 1100px;
	}

	.btn button{
		color : white;
		width : 200px;
		padding : 10px;
		background-color : rgb(56, 116, 70);
	}
	
	.btn:hover button {
		color : rgb(56, 116, 70);
		background-color : white;
	}

</style>

<script>

	function cartDelete() {
		var count = 0;
		var cseq = "";
		var cb = document.getElementsByName("cseq");
	
		for (var i = 0; i< cb.length; i++) {
			if(cb[i].checked == true) {
				
				cseq = cseq + cb[i].value + ",";
				count++;
			}
		}
		
		if(count == 0) {
			alert("삭제할 상품을 선택해 주세요.");
			
		} else {
			location.href = "cartDelete_choice.do?cseq=" + cseq;

		}
	}
/*
	function cartDelete(){
		var count = 0;
		var cseq = "";
		var cb = document.getElementsByName("cseq");
		
		for (var i = 0; i< cb.length; i++) {
			if(cb[i].checked == true) {
				
				cseq = cseq + cb[i].value + "";
				count++;
			}
		}
	}
	*/
	function cart_newOrder() {
		var count = 0;
		var cseq = "";
		var cb = document.getElementsByName("cseq");

		for (var i = 0; i< cb.length; i++) {
			if(cb[i].checked == true) {
				
				cseq = cseq + cb[i].value + ",";
				count++;
			}
		}

		if(count == 0) {
			alert("결제할 상품을 선택해 주세요.");
		} else {
			location.href = "shopOrderInsert2.do?cseq="+cseq;
// 			document.frm.action = "shopOrderInsert2.do?cseq="+cseq;
// 			document.frm.submit();
		}
	}
	
	/*
	function cart_newOrder() {
		var cb = document.getElementsByName("cseq");
		
		for (var i = 0; i < cb.length; i++) {
			
			if (cb[i].checked == false) {
				alert("결제할 상품을 선택해 주세요.");
				
			} else {
				document.frm.action = "shopOrderInsert2.do";
				document.frm.submit();
			}
		}
	}
	*/
</script>
</head>
<body>
<!-- 헤더 -->
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" method = "post">
<div class = "container">
	
	<div class = "row middle">
	
		<div class = "col-4 menu">
		
			<div class = "row ment">
				장바구니
			</div>	
		
			<p><a href = "shopCartList.do">장바구니	 </a></p>
			<p><a href = "shopRoomCartList.do">방바구니</a></p>
			<p><a href = "shopOrderList2.do">주문내역	 </a></p>
			<p><a href = "reservationList.do">예약내역	 </a></p>
		</div>
		
		<div class = "col-5 cart">
			<c:choose>
				<c:when test = "${cartList.size() == 0}">
					<div class = "cart1">
							<b>장바구니가 비었습니다.</b>
					</div>
				</c:when>
				
				<c:otherwise>
					<table border = "1" style = "width : 900px;">
		
						<tr>
							<th>선택</th>
							<th colspan = "2">상품</th>
							<th>수량</th>
							<th>가격</th>
							<th>삭제</th>
						</tr>
						
						<c:forEach var = "cartList" items = "${cartList}">
							<tr>
								<!-- 상품 담은 날짜 -->
								<td colspan = "6"><fmt:formatDate value = "${cartList.indate}" pattern = "yy.MM.dd hh:mm"/></td>
							</tr>
							
							<tr>
								<!-- 체크박스 -->
								<td>
<%-- 									<input type = "checkbox" name = "cseq" value = "${cartList.cseq}"> --%>
									<input type = "checkbox" name = "cseq" value = "${cartList.pseq}@${cartList.quantity}">
								</td> <!-- value 값 주기 -->
								
								<!-- 상품명 -->
								<td><a href = "shopProductDetail.do?pseq=${cartList.pseq}">${cartList.pname}</a></td>
								
								<!-- 상품이미지 -->
								<td>
									<a href = "shopProductDetail.do?pseq=${cartList.pseq}">
										<img src = "http://localhost:8080/project/hotel/img/${cartList.image1}">
									</a>
								</td>
								
								<!-- 상품수량 -->
								<td>${cartList.quantity}</td>
								
								<!-- 상품가격 -->
								<td>&#8361;<fmt:formatNumber value = "${cartList.price2 * cartList.quantity}" pattern = "#,###"/></td>
								
								<!-- 삭제 -->
								<td><a href = "shopCartDelete.do?cseq=${cartList.cseq}">[삭제]</a>
									
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	
	</div>
	
	<c:choose>
		<c:when test = "${cartList.size() != 0}">
	
			<div class = "row delete">
				<input type = "button" value = "선택 삭제" onclick = "cartDelete()">
			</div>
				
			<div class = "row total">
				
				총 결제 금액
				<c:set var = "total" value = "0"/>
					<c:forEach var = "cart" items = "${cartList}">
						<c:set var = "total" value = "${total + (cart.price2 * cart.quantity)}"/>
					</c:forEach>
				<b>&#8361;<fmt:formatNumber value = "${total}" pattern = "#,###"/></b>
				
			</div>
				
			<div class = "row btn">
				<button type = "button" onclick = "cart_newOrder()">주문하기</button>
			</div>
			
		</c:when>
	</c:choose>
</div>
</form>

<jsp:include page = "/hotel/hotelTail.jsp"/>

</body>
</html>