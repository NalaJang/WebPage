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

	.back {
		background-color : rgb(255, 253, 244);
	}
	
	.container {
		mid-width : 1600px;
		padding-top : 50px;
		padding-bottom : 600px;
	}
	
	.ment {
		font-size : 35px;
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	.btn {
		margin-left : 155px;
	}
	
	.middle, .total {
		padding-left : 500px;
	}
		
	.total {
		margin : 30px;
	}

</style>

<script>
	function recipt(){
	var url = "recipt.do";
	window.open(url, "post",
			"toolbar = no, menubar = no, scrollbars = yes, resizable = no, width = 690, height = 690, top = 300, left = 300");
}
</script>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<div class = "back">
<div class = "container">

	<div class = "ment">
		후원내역
	</div>
	
	<c:if test = "${donationList.size() != 0}">
		<div class = "btn">
			<input type = "button" value = "기부금영수증보기" onclick = "recipt()">
		</div>
	</c:if>
	
	<div class = "middle">
		<c:choose>
			<c:when test = "${donationList.size() == 0}">
				<div class = "ment2">
					펭귄보호에 동참 해주세요. 💕

					<p><a href = "donationInsertForm.do">함께 하러가기</a></p>
				</div>
				
			</c:when>
			
			<c:otherwise>
				<table border = "1" style = "width : 400px; text-align : center;">
				
					<tr>
					
						<th>후원자</th>
						<th>기부금</th>
						<th>날짜   </th>
					</tr>
					
					<c:forEach var = "list" items = "${donationList}">
						<tr>
						
							<td>${list.name}  </td>
							<td><fmt:formatNumber value = "${list.money}" pattern = "#,###" /></td>
							<td><fmt:formatDate value = "${list.indate}" pattern = "yyyy-MM-dd"/></td>
				
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class = "row total">
	
		<c:if test = "${donationTotal != 0}">
			${hotelMember.name} 님께서 기부하신 금액은<br>
			<b><fmt:formatNumber value = "${donationTotal}" pattern = "#,###"/>원 입니다.</b>
		</c:if>
		
	</div>
	
</div>
</div>
<jsp:include page="/hotel/hotelTail.jsp"/>
</body>
</html>