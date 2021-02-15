<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지(객실등록)</title>
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
	function insert() {
	 	if (document.frm.kind.value == "") {
			alert("객실종류를 입력해주세요");
			document.frm.kind.focus();
		}
		
		else if (document.frm.price.value == "") {
			alert("가격을 입력해주세요");
			document.frm.price.focus();
		}
	 	
		else if (document.frm.content.value == "") {
			alert("간단정보를 입력해주세요");
			document.frm.content.focus();
		}
		
		else if (document.frm.detail.value == "") {
			alert("상세정보를 입력해주세요");
			document.frm.detail.focus();
		}
		
		else if (document.frm.donation.value == "") {
			alert("후원금을 입력해주세요");
			document.frm.donation.focus();
		}
		
		else {
			if(confirm('객실을 등록하시겠습니까?')){
				alert("등록되었습니다.");
				document.frm.action = "roomInsert.do";
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

<!-- <form name = "frm" method = "post" enctype = "multipart/form-data"> -->
<form name = "frm" method = "post">


<h2>객실 등록</h2>

<table border = "1">

	<tr>
		<td>객실 종류</td>
		<td colspan = "2"><input type = "text" name = "kind" size = "40" maxlength = "1"></td>
	</tr>
	
	<tr>
		<td>가격 </td>
		<td colspan = "2"><input type = "text" name = "price" size = "40"></td>
	</tr>
		
	<tr>
		<td>내용</td>
		<td colspan = "2"><textarea name= "content" rows= "14" cols="60"></textarea></td>
	</tr>
	
	<tr>
		<td>이미지 1</td>
		<td><input type = "file" name = "image1"></td>
	</tr>
	
	<tr>
		<td>이미지 2</td>
		<td><input type = "file" name = "image2"></td>
	</tr>
	
	<tr>
		<td>이미지 3</td>
		<td><input type = "file" name = "image3"></td>
	</tr>
	
	<tr>
		<td>이미지 4</td>
		<td><input type = "file" name = "image4"></td>
	</tr>
	
	<tr>
		<td>useyn</td>
		<td colspan = "2"><input type = "text" name = "useyn" size = "40" maxlength = "1" placeholder = "y or n"></td>
	</tr>

	<tr>
		<td>상세정보</td>
		<td colspan = "2"><textarea class = "form-control" name = "detail" maxlength = "1000" style = " width : 300px; height : 200px;"></textarea></td>
	</tr>
	
	<tr>
		<td>후원금</td>
		<td colspan = "2"><input type = "text" name = "donation"></td>
	</tr>
</table>

	<div class = "btn_group">
		<input class = "b1" type = "reset" value = "지우기">
		<input class = "b2" type = "button" value = "등록" onclick = "insert()">
	</div>

</form>

</body>
</html>