<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지(상품수정)</title>
<style>
	form {
		padding-left : 600px;
	}
	table {
		text-align : center;
	}
	table input {
		padding : 8px;
	}
	.btn_group input {
		padding : 10px;
	}
	.b2 {
		color : white;
		background-color : blue;
	}

</style>
<script>
	function edit() {
		if (document.frm.zip_num.value == "") {
			alert("우편번호를 입력해주세요");
			document.frm.zip_num.focus();
		} 
		else if (document.frm.address1.value == "") {
			alert("주소를 입력해주세요");
			document.frm.address1.focus();
		}
		
		else if (document.frm.address2.value == "") {
			alert("나머지 주소를 입력해주세요");
			document.frm.address2.focus();
		}
		else {
			if(confirm('정보를 수정하시겠습니까?')){
				alert("정보가 수정되었습니다.");
				document.frm.action = "memberEdit.do?no="+${memberInfo.no};
				document.frm.submit();
			} else {
				return;
			}
			
		}
	}
</script>
</head>
<body>

<jsp:include page = "/hotel/adminPageHeader.jsp"/>

<form name = "frm" method = "post">


<h2>회원정보 수정</h2>

<table border = "1">
	<tr>
		<td>회원이름</td>
		<td colspan = "2"><input type = "text" name = "name" size = "40" value = "${memberInfo.name}" readonly></td>
	</tr>
	
	<tr>
		<td>이메일</td>
		<td colspan = "2"><input type = "text" name = "email" size = "40" value = "${memberInfo.email}" readonly></td>
	</tr>
	
	<tr>
		<td>휴대폰번호</td>
		<td colspan = "2"><input type = "text" name = "phone" size = "40" value = "${memberInfo.phone}"></td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td colspan = "2"><input type = "password" name = "pw" size = "40" value = "${memberInfo.pw}" readonly></td>
	</tr>
	
	<tr>
		<td>우편번호</td>
		<td colspan = "2"><input type = "text" name = "zip_num" size = "40" value = "${memberInfo.zip_num}"></td>
	</tr>

	<tr>
		<td>주소</td>
		<td><input type = "text" name = "address1" size = "40" value = "${memberInfo.address1}"></td>
	</tr>
	
	<tr>
		<td>나머지주소</td>
		<td><input type = "text" name = "address2" size = "40" value = "${memberInfo.address2}"></td>
	</tr>
	
	<tr>
		<td>useyn</td>
		<td colspan = "2"><input type = "text" name = "useyn" size = "40" maxlength = "1" value = "${memberInfo.useyn}"></td>
	</tr>
	
	<tr>
		<td>가입날짜</td>
		<td colspan = "2">${memberInfo.indate}</td>
	</tr>
</table>

	<div class = "btn_group">
		<input class = "b1" type = "reset" value = "지우기">
		<input class = "b2" type = "button" value = "수정" onclick = "edit()">
	</div>

</form>

</body>
</html>