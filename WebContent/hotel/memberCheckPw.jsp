<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
	
	.container div {
		margin : 10px;
	}
	
	.pw {
		padding-top : 50px;
		padding-left : 715px;
	}
	
	.text {
		padding-left : 680px;
	}
	
	span {
		color : red;
		margin-left : 680px;
	}
	
	.row.btn {
		margin-left : 670px;
	}
	
	.btn input {
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

<script>
	function check() {
		var pw = ${hotelMember.pw};
		
		if(document.frm.pw.value != pw) {
			
			 document.getElementById("blank").innerHTML = "*비밀번호가 맞지 않습니다.";
			 
		} else {
			document.frm.action = "checkPw.do";
			document.frm.submit();
		}
	}
</script>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" method = "post">
<input type = "hidden" name = "no" value = "${memberVo.no}">


<div class = "container">
	
	<div class = "row pw">
		비밀번호 입력
	</div>
	
	<div class = "row text">
		<input type = "password" name = "pw" autofocus>
	</div>

	<div class = "row btn">
		<input type = "button" value = "확인" onclick = "check()">
	</div>
	
	<div>
		<span id = "blank"></span>	<!-- 비밀번호가 틀린 경우 -->
	</div>
	
</div>

</form>

<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>