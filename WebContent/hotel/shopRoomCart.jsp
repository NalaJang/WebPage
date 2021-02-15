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
	
	.total b{
		font-size : 20px;
	}
	
	.total {
		margin : 20px;
		padding-top : 50px;
		padding-left : 550px;
	}
	
	.row.btn {
		margin-left : 1050px;
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
	
	function cartDelete(){
		
		var cseq = 0;
		var count = 0;
		var cb = document.getElementsByName("cseq");
			
		for(var i = 0; i<cb.length; i++){
			if(cb[i].checked == true) {
				
				cseq = cb[i].value;
				
				count++;
			}
		}
		if(count == 0) {
			alert("삭제할 상품을 선택해 주세요.");
			
		} else {
			
			location.href = "roomCartdelete_choice.do?cseq=" + cseq;
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
/*
	function roomCart_newOrder(){
		
		var cseq = 0;
		var count = 0;
		var cb = document.getElementsByName("cseq");
			
		for(var i = 0; i<cb.length; i++){
			if(cb[i].checked == true) {
				
				cseq = cb[i].value;
				
				count++;
			}
		}
		if(count == 0) {
			alert("예약할 상품을 선택해 주세요.");
			
		} else {
			location.href = "reservationInsert.do?cseq=" + cseq;	//get방식으로 보내기
// 			document.frm.action = "reservationInsert.do?cseq=" + cseq;	//예약목록으로 이동
// 			document.frm.submit();
			
		}
	}
	*/
</script>
</head>
<body>

<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" method = "post">

<div class = "container">	
	
	<div class = "row middle">
	
		<div class = "col-4 menu">
		
			<div class = "row ment">
				방바구니
			</div>

			<p><a href = "shopCartList.do">장바구니	 </a></p>
			<p><a href = "shopRoomCartList.do">방바구니</a></p>
			<p><a href = "shopOrderList2.do">주문내역	 </a></p>
			<p><a href = "reservationList.do">예약내역  </a></p>
		</div>
				
		<div class = "col-5 cart">
			<c:choose>
				<c:when test = "${roomCartList.size() == 0}">
					<div class = "cart1">
						<b>방바구니가 비었습니다.</b>
					</div>
				</c:when>
			
				<c:otherwise>
					<table border = "1" style = "width : 900px;">
						<tr>
							<th>선택				 </th>
							<th colspan = "2">상품</th>
							<th>인원수			 </th>
							<th>체크인시간			 </th>
							<th>체크아웃시간		 </th>
							<th>가격				 </th>
							<th>후원금			 </th>
							<th>삭제				 </th>
						</tr>
						
						<c:forEach var = "roomCartList" items = "${roomCartList}">
							<tr>
								<!-- 체크박스 -->
								<td>
								
									<input type = "checkbox" name = "cseq" value = "${roomCartList.cseq}"><!-- value 값 주기 -->
									<input type = "hidden" name = "rseq" value = "${roomCartList.rseq}">
								</td>
									
								<!-- 객실 종류 -->
								<td>
									<a href = "roomDetail.do?kind=${roomCartList.rkind}">
										<c:choose>
											<c:when test = "${roomCartList.rkind eq 1}">스탠다드</c:when>
											<c:when test = "${roomCartList.rkind eq 2}">디럭스   </c:when>
											<c:when test = "${roomCartList.rkind eq 3}">그랜드   </c:when>
										</c:choose>
									</a>
								</td>
								
								<!-- 객실 이미지 -->
								<td>
									<a href = "roomDetail.do?kind=${roomCartList.rkind}">
										<img src = "http://localhost:8080/project/hotel/img/${roomCartList.image1}">
									</a>
								</td>
								
								<!-- 인원수 -->
								<td>${roomCartList.membernum}</td>
								
								<!-- 체크인 날짜 -->
								<td>${roomCartList.checkin}</td>
								
								<!-- 체크아웃 날짜 -->
								<td>${roomCartList.checkout}</td>
								
								<!-- 가격 -->
								<td>
								
									<fmt:parseDate value="${roomCartList.checkin}" var="checkin" pattern="yyyy-MM-dd"/>
									<fmt:parseNumber value="${checkin.time / (1000*60*60*24)}" integerOnly="true" var="checkin"></fmt:parseNumber> <!-- integerOnly : 정수 부분만 파싱할지의 여부 지정. 기본값은 false -->
									
									<fmt:parseDate value="${roomCartList.checkout}" var="checkout" pattern="yyyy-MM-dd"/>
									<fmt:parseNumber value="${checkout.time / (1000*60*60*24)}" integerOnly="true" var="checkout"></fmt:parseNumber>
							
																	<!-- 하루만 예약하더라도 계산 될 수 있게 +1 -->
									&#8361;<fmt:formatNumber value = "${(checkout - checkin +1)*roomCartList.price * roomCartList.membernum}" pattern = "#,###"/>
								</td>
								
								<!-- 후원금액 -->
								<td>
									&#8361;<fmt:formatNumber value = "${(checkout - checkin +1)*roomCartList.price * roomCartList.membernum * 0.05}" pattern = "#,###"/>
								</td>
								
								<!-- 삭제 -->
								<td><a href = "shopRoomCartDelete.do?cseq=${roomCartList.cseq}">[삭제]</a>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<c:choose>
		<c:when test = "${roomCartList.size() != 0}">
	
			<div class = "row delete">				
				<input type = "button" value = "선택 삭제" onclick = "cartDelete()">
			</div>
			
			<div class = "row total">
				총 결제금액 
				<c:set var = "total" value = "0"/>
					<c:forEach var = "roomCart" items = "${roomCartList}">
					
						<fmt:parseDate value="${roomCart.checkin}" var="checkin" pattern="yyyy-MM-dd"/>
						<fmt:parseNumber value="${checkin.time / (1000*60*60*24)}" integerOnly="true" var="checkin"></fmt:parseNumber> <!-- integerOnly : 정수 부분만 파싱할지의 여부 지정. 기본값은 false -->
						
						<fmt:parseDate value="${roomCart.checkout}" var="checkout" pattern="yyyy-MM-dd"/>
						<fmt:parseNumber value="${checkout.time / (1000*60*60*24)}" integerOnly="true" var="checkout"></fmt:parseNumber>


						<%-- &#8361;<fmt:formatNumber var = "price" value = "${(checkout - checkin +1)*roomCart.price * roomCart.membernum}"/> --%>
						
						<c:set var = "total" value = "${total + ((checkout - checkin +1)*roomCart.price * roomCart.membernum)}"/>
						
					</c:forEach>
				<b>&#8361; <fmt:formatNumber value = "${total}" pattern = "#,###"/></b>
				
			</div>
			
			<div class = "row btn">
				<button type = "button" onclick = "order()">예약하기</button>
				
<!-- 스크립트 -->				
				<script> //for each 안에 찾고자 하는 값이 있으면 스크립트는 여기에 적어준다.(ex. rseq)	
					function order(){
						
						var cseq = 0;
						var count = 0;
						var cb = document.getElementsByName("cseq");
						
						var rseq = document.frm.rseq.value; //***** 고유값 하나 이기 때문에 rseq 하나만 가져오면 된다.
						
						for(var i = 0; i<cb.length; i++){
							if(cb[i].checked == true) {
								
								cseq = cb[i].value;
								
								count++;
							}
							
						}
						if(count == 0) {
							alert("예약할 상품을 선택해 주세요.");
							
						} else {
							location.href = "reservationInsert.do?cseq=" + cseq + "&rseq=" + rseq;	//get방식으로 보내기
	//				 		document.frm.action = "reservationInsert.do?cseq=" + cseq;	//예약목록으로 이동
	//				 		document.frm.submit();
								
						}
					}
				</script>
			</div>
		</c:when>
	</c:choose>
	
</div>
</form>
</body>
</html>