<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri =  "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		min-width : 1600px;
		text-align : center;
		padding-top : 100px;
		padding-bottom : 300px;
	}
	
	.row.btn {
		padding-top : 50px;
		margin-left : 400px;
	}
	
	.btn input{
		color : white;
		width : 200px;
		padding: 10px;
		background-color : rgb(56, 116, 70);
	}
	
	.btn:hover input {
		color : rgb(56, 116, 70);
		background-color : white;
	}
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<div class = "container">
	<div class = "ment">
		회원님의 비밀번호는  <br>
	<b>${findPw.pw}</b><br>
		     입니다.
	</div>
	
	<div class = "btn">
		<input type = "button" value = "로그인페이지로" onclick = "location.href = 'loginForm.do'">
	</div>
	
</div>

<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>