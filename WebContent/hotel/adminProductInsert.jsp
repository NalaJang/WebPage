<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
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
		if (document.frm.name.value == "") {
			alert("상품명을 입력해주세요");
			document.frm.name.focus();
		} 
		
		else if (document.frm.kind.value == "") {
			alert("상품종류를 입력해주세요");
			document.frm.kind.focus();
		}
		
		else if (document.frm.price1.value == "") {
			alert("가격을 입력해주세요");
			document.frm.price1.focus();
		}
		
		else if (document.frm.price2.value == "") {
			alert("가격을 입력해주세요");
			document.frm.price2.focus();
		}
		
		else if (document.frm.content.value == "") {
			alert("상품내용을 입력해주세요");
			document.frm.content.focus();
		}
		
		else if (document.frm.detail.value == "") {
			alert("상세정보를 입력해주세요");
			document.frm.detail.focus();
		}
		
		else if (document.frm.detail2.value == "") {
			alert("상세정보를 입력해주세요");
			document.frm.detail2.focus();
		}
		
		else {
			if(confirm('상품을 등록하시겠습니까?')){
				alert("상품이 등록되었습니다.");
				document.frm.action = "productInsert.do";
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


<h2>새로운 상품 등록</h2>

<table border = "1">
	<tr>
		<td>상품명</td>
		<td colspan = "2"><input type = "text" name = "name" size = "40"></td>
	</tr>
	
	<tr>
		<td>상품 종류</td>
		<td colspan = "2"><input type = "text" name = "kind" size = "40" maxlength = "1"></td>
	</tr>
	
	<tr>
		<td>재고</td>
		<td colspan = "2"><input type = "text" name = "stock" size = "40"></td>
	</tr>
	
	<tr>
		<td>가격 1</td>
		<td colspan = "2"><input type = "text" name = "price1" size = "40"></td>
	</tr>
	
	<tr>
		<td>가격 2</td>
		<td colspan = "2"><input type = "text" name = "price2" size = "40"></td>
	</tr>
		
	<tr>
		<td>상품 내용</td>
		<td colspan = "2"><input type = "text" name = "content" size = "40"></td>
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
		<td>bestyn</td>
		<td colspan = "2"><input type = "text" name = "bestyn" size = "40" maxlength = "1" placeholder = "y or n"></td>
	</tr>

	<tr>
		<td>상세정보1</td>
		<td colspan = "2"><textarea class = "form-control" name = "detail" maxlength = "1000" style = " width : 300px; height : 200px;"></textarea></td>
	</tr>
	
	<tr>
		<td>상세정보2</td>
		<td colspan = "2"><textarea class = "form-control" name = "detail2" maxlength = "500" style = " width : 300px; height : 200px;"></textarea></td>
	</tr>
</table>

	<div class = "btn_group">
		<input class = "b1" type = "reset" value = "지우기">
		<input class = "b2" type = "button" value = "등록" onclick = "insert()">
	</div>

</form>

</body>
</html>