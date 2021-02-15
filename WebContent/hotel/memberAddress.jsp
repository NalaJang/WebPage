<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		text-align : center;
		padding-top : 30px;
	}
	
	b {
		font-size : 20px;		
	}
	
	.content {
		padding : 30px;
	}
	
	.content input {
		padding : 10px;
	}
</style>

<script>
	function result(zipNum, sido, gugun, dong){
		opener.document.frm.address1.value =zipNum+""+sido + ""+ gugun+""+dong; //*****
		self.close();
	}
</script>
</head>
<body>
<form name = "frm" action = "memberAddress.do" method = "post">

<div class = "container">
	<div>
		<b>주소 찾기</b>
	</div>
	
	<div class = "content">
		<input type = "text" name = "content" placeholder = "동을 입력 해주세요." style = "width : 200px;">
		<input type = "submit" name = "search" value = "검색">
	</div>
	
	<c:forEach var = "ad" items = "${address}">
		<table border = "1" style = "width : 200px;">
			<tr>
				<td>주소</td>
				<td>우편번호</td>
			</tr>
			
			<tr>
				<td><a href = "#" onclick = "result()">${ad.sido}</a></td>
			</tr>
		</table>
	</c:forEach>
</div>
</form>
</body>
</html>