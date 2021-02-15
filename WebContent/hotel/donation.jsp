<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		padding-bottom : 300px;
	}
	
	.ment {
		color : white;
		font-size : 35px;
		padding-left : 170px;
		background-color : orange;
	}
	
	.donation {
		height: 500px;
		padding : 30px;
		margin-top : 50px;
	}
	
	.donation div {
		margin : 30px;
	}
	
	.r1, .r2 {
		font-size : 18px;
	}
	
	.name {
		padding-left : 20px;
	}
	
	.email {
		padding-left : 9px;
		padding-bottom : 30px;
		border-bottom : 1px solid orange;
	}
	
	.date input, #money {
		width : 100px;
		padding : 10px;	
	}
	
	.btn input {
		color : white;
		width : 300px;
		padding : 20px;
		font-weight : bold;
		background-color : orange;
	}
	
	.btn:hover input {
		color : orange;
		background-color : white;
	}
	
	.img img{
		padding-top : 60px;
		width : 700px;
		hegith : 1000px;
	}
</style>

<script>
	//클릭한 버튼의 값을 text로
	function input_value1(){
	    document.getElementById("test").value = document.getElementById("val1").value;
	}
	function input_value2(){
	    document.getElementById("test").value = document.getElementById("val2").value;
	}
	function input_value3(){
	    document.getElementById("test").value = document.getElementById("val3").value;
	}	

	function donation(){
		if(document.getElementById("test").value == 0) {
			alert("금액을 입력 해주세요.");
		} else {
			
			alert("펭귄에게 잘 전해줄게요(●'◡'●)\n(첫 페이지로 돌아 갑니다.)");
			
			document.frm.action = "donationInsert.do";
			document.frm.submit();
		}
		}
</script>
</head>

<jsp:include page = "/hotel/hotelHeader.jsp"/>

<body>
<form name = "frm" method = "post">
<div class = "back">
<div class = "container">

	<div class = "row ment">
		당신의 후원이 변화를 만듭니다.
	</div>
		
	<div class = "row">
		<div class = "col-7 donation">
			
			<div class = "row r1">
				<b>회원가입 정보</b>
			</div>
			
			<div>
				후원내역 확인 등 마이페이지 이용 시 꼭 필요한 정보입니다.
			</div>
				
			<div class = "name">
				이름&nbsp;&nbsp;&nbsp;<input type = "text" name = "name" value = "${hotelMember.name}">
			</div>
			
			<div class = "phone">
				휴대전화&nbsp;<input type = "text" name = "phone" value = "${hotelMember.phone}">
			</div>
			
			<div class = "email">
				이메일&nbsp;&nbsp;&nbsp;<input type = "text" name = "email" value = "${hotelMember.email}">
			</div>

			<div class = "row r2">
				<b>후원 정보</b>
			</div>
			
			<div class = "date">
				후원주기
				<input type = "button" value = "정기">
				<input type = "button" value = "일시">
			</div>
			
			<div class = "money">
				후원금액
				<input id = "val1" type = "button" value = "30000" onclick = "input_value1()">
				
				<input id = "val2" type = "button" value = "50000" onclick = "input_value2()">
				
				<input id = "val3" type = "button" value = "100000" onclick = "input_value3()">
				
				<input id = "test" type = "text" name = "money" value = "" placeholder = "직접 입력"/>
				
			</div>
				
			<div class = "btn">
				<input type = "button" value = "후원하기" onclick = "donation()">
			</div>
			
		</div>
	
		<div class = "col-5 img">
			<img src = "http://localhost:8080/project/hotel/img/penguin2.jpg">
		</div>
		
	</div>
	
</div>
</div>
</form>
</body>

<jsp:include page="/hotel/hotelTail.jsp"/>
</html>