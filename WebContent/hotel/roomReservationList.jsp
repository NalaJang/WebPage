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
	
	.reservation {
		padding-top : 80px;
	}
	
	.reservation1 {
		padding-top : 50px;
		font-size : 20px;
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
				예약 내역
			</div>

			<p><a href = "shopCartList.do">장바구니	 </a></p>
			<p><a href = "shopRoomCartList.do">방바구니</a></p>
			<p><a href = "shopOrderList2.do">주문내역	 </a></p>
			<p><a href = "reservationList.do">예약내역	 </a></p>

		</div>
		
		<div class = "col-5 reservation">
			<c:choose>
				<c:when test = "${reservationList.size() == 0}">
					<div class = "reservation1">
							<b>예약 내역이 없습니다.</b>
					</div>
				</c:when>
				
				<c:otherwise>
					<table border = "1" style = "width : 900px;">
						<tr>
							<th>방번호	</th>
							<th>인원수	</th>
							<th>체크인	</th>
							<th>체크아웃	</th>
							<th>가격		</th>
							<th>후원금	</th>
							<th>결제일	</th>
						</tr>
						
						<c:forEach var = "list" items = "${reservationList}">
							<tr>
								
								<!-- 방종류 -->
								<td>
									<c:choose>
										<c:when test = "${list.rkind eq 1}">스탠다드</c:when>
										<c:when test = "${list.rkind eq 2}">디럭스</c:when>
										<c:when test = "${list.rkind eq 3}">그랜드</c:when>
									</c:choose>
								</td>
								
								<!-- 인원수 -->
								<td>${list.membernum}</td>
								
								<!-- 체크인 --> 
								<td>${list.checkin}</td>
								
								<!-- 체크아웃 -->
								<td>${list.checkout}</td>
								
								<!-- 결제가격 -->
								
								<td>
								<fmt:parseDate value="${list.checkin}" var="checkin" pattern="yyyy-MM-dd"/>
									<fmt:parseNumber value="${checkin.time / (1000*60*60*24)}" integerOnly="true" var="checkin"></fmt:parseNumber> <!-- integerOnly : 정수 부분만 파싱할지의 여부 지정. 기본값은 false -->
									
									<fmt:parseDate value="${list.checkout}" var="checkout" pattern="yyyy-MM-dd"/>
									<fmt:parseNumber value="${checkout.time / (1000*60*60*24)}" integerOnly="true" var="checkout"></fmt:parseNumber>
									
									&#8361;<fmt:formatNumber value = "${(checkout - checkin +1)*list.price * list.membernum}" pattern = "#,###"/>
									<%-- &#8361;<fmt:formatNumber value = "${list.price}" pattern = "#,###"/> --%>
									</td>
								
								<!-- 후원금 -->
								<td>&#8361;<fmt:formatNumber value = "${(checkout - checkin +1)*list.price * list.membernum * 0.05}" pattern = "#,###"/></td>
								
								<!-- 결제일 -->
								<td><fmt:formatDate value = "${list.indate}" pattern = "yy-MM-dd"/></td>
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