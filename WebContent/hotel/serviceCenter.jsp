<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- chat icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- phone icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style>
	.container {
		color : black;
		min-width : 1600px;
		font-weight : bold;
		padding-bottom :300px;
		text-decoration : none;
	}
	.ment {
		font-size : 30px;
		padding-top : 50px;
		padding-left : 200px;
		padding-bottom : 120px;
	}
	.catagory {
		padding-left : 500px;
	}
	
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<div class = "container">

	<div class = "row ment">
		고객 지원
	</div>
	
	<div class = "row catagory">
	
		<div class = "col-5 service1">
			<div>
				<b class="material-icons" style="font-size:150px">chat</b>
			</div>
			
			<div class = "ment2">
				<p><a href = "customerServiceQnA.do">문의하기</a></p>
				   <a href = "qnaList.do">나의 문의내역			 </a>
			</div>			
		</div>
		
		<div class = "col-5 service2">
			<div>
				<b class="material-icons" style="font-size:150px">phone</b>
			</div>
			
			<div class = "ment2">
				전화 문의
				<p>고객센터</p>
				<p>1234-4989</p>
				<p>월 ~ 금 09:30 ~ 17:30 (오프타임 12:00 ~ 13:00)</p>
				<p>토 / 일 / 공휴일 휴무</p>
			</div>
			
		</div>
		
	</div>
	
</div>
<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>