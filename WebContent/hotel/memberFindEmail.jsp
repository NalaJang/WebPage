<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	.container input {
		margin : 5px;
	}
	
	.ment {
		font-size : 35px;
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	.name {
		padding-top : 30px;
		padding-left : 600px;
	}
	
	.phone {
		padding-left : 552px;
	}
	
	.btn_group {
		padding-top : 30px;
		margin-left : 500px;
	}
	
	.back {
		width : 200px;
		padding: 10px;
	}
	
	.submit {
		color : white;
		width : 200px;
		padding: 10px;
		background-color : rgb(56, 116, 70);
	}
	
	.submit:hover {
		color : rgb(56, 116, 70);
		background-color : white;
	}
</style>

</head>
<body>

<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" action = "memberFindEmail.do" method = "post">

<div class = "container">
	
	<div class = "ment">
		이메일 찾기
	</div>
	
	<div class = "row name">
		이름<input type = "text" name = "name">
	</div>
	
	<div class = "row phone">
		휴대폰번호<input type = "text" name = "phone">
	</div>
		
	<div class = "btn_group">
	
		<input class = "back" type = "button" value = "뒤로" onclick = "history.back();">

		<input class = "submit" type = "submit" value = "확인">

	</div>

</div>
</form>

<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>