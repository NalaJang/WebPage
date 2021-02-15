<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<style>
	.container {
		mid-width : 1600px;
		padding-top : 50px;
		padding-bottom : 600px;
	}
	
	.container input {
		margin : 5px;
	}	
	
	.img {
		padding-left : 435px;
	}
	
	.email {
		padding-top : 30px;
		padding-left : 400px;
	}
	
	.pw {
		padding-left : 385px;
	}
	
	.join {
		padding-left : 430px;
	}
	
	.join a {
		color : grey;
	}
	
	.row.btn {
		padding-top : 10px;
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
	
	#blank {
		color : red;
		font-size : 15px;
		margin-left : 400px;
	}

</style>

<script>
/*
	function login() {
		var userEmail = document.frm.email.value;
		var userPw = document.frm.pw.value;
		
		if(!userEmail || !userPw) {
			alert("이메일과 비밀번호를 모두 입력해주세요.");
		} else {
			document.frm.action = "login.do";
			document.frm.submit();
		}
	}*/
	
	function login() {
		
	    var userEmail = document.getElementById("email").value; 
		var userPw = document.getElementById("pw").value; 
	 
	    if (!userEmail || !userPw) { 	 //공란일 때 로그인버튼을 눌렀을 경우
	      document.getElementById("blank").innerHTML = "*아이디와 비밀번호를 입력해주세요.";
	      
	    } else {
			document.frm.action = "login.do";
			document.frm.submit();
		}
	}
</script>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" method = "post">

<div class = "container">

	<!-------------------
		첫번째  ROW 이미지
	-------------------->
	<div class = "row img">
	
		<img src = "http://localhost:8080/project/hotel/img/펭귄.jpg" alt = "펭귄">
		
	</div>	
	
	<!-------------------
		   두번째 ROW 이메일
	-------------------->
	<div class = "row email">
	
		이메일			
		<input id = "email" type = "text" name = "email" autofocus>
		
	</div>		

	<!-------------------
		세번째 ROW 비밀번호
	-------------------->
	<div class = "row pw">
	
		비밀번호
		<input id="pw" type = "password" name = "pw">
		
	</div>	

	<div>
		<span id = "blank"></span>	<!-- 공란일 때 로그인버튼을 눌렀을 경우 -->
	</div>
	
	<!-------------------
		        네번째  ROW
	-------------------->
	<div class = "row join">
		<a href = "memberFindEmailForm.do">이메일</a> /
		<a href = "memberFindPwForm.do">비밀번호 찾기 | </a>
		<a href = "insertForm.do">  회원가입</a>
		
	</div>	
	
	<!-------------------
		다섯번째 버튼 ROW
	-------------------->
	<div class = "row btn">
	
		<input type = "button" value = "로그인" onclick = "login()">
		
	</div>	
			
</div>
</form>

</body>
<jsp:include page = "/hotel/hotelTail.jsp"/>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>