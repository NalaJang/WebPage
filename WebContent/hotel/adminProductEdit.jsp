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
			if(confirm('상품을 수정하시겠습니까?')){
				alert("상품이 수정되었습니다.");
				document.frm.action = "productEdit.do?pseq="+${productDetail.pseq};
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


<h2>상품 수정</h2>

<table border = "1">
	<tr>
		<td>상품명</td>
		<td colspan = "2"><input type = "text" name = "name" size = "40" value = "${productDetail.name}"></td>
	</tr>
	
	<tr>
		<td>상품 종류</td>
		<td colspan = "2"><input type = "text" name = "kind" size = "40" maxlength = "1" value = "${productDetail.kind}"></td>
	</tr>
	
	<tr>
		<td>재고</td>
		<td colspan = "2"><input type = "text" name = "stock" size = "40" value = "${productDetail.stock}"></td>
	</tr>
	
	<tr>
		<td>가격 1</td>
		<td colspan = "2"><input type = "text" name = "price1" size = "40" value = "${productDetail.price1}"></td>
	</tr>
	
	<tr>
		<td>가격 2</td>
		<td colspan = "2"><input type = "text" name = "price2" size = "40" value = "${productDetail.price2}"></td>
	</tr>
		
	<tr>
		<td colspan = "2">상품 내용</td>
	</tr>
	
	<tr>
		<td colspan = "2"><textarea name= "content2" rows= "14" cols="50">${productDetail.content}</textarea></td>
	</tr>
	
	<tr>
		<td>이미지 1</td>
		<td><input type = "file" name = "image1" value = "${productDetail.image1}"></td>
	</tr>
	
	<tr>
		<td>이미지 2</td>
		<td><input type = "file" name = "image2" value = "${productDetail.image2}"></td>
	</tr>
	
	<tr>
		<td>이미지 3</td>
		<td><input type = "file" name = "image3" value = "${productDetail.image3}"></td>
	</tr>
	
	<tr>
		<td>이미지 4</td>
		<td><input type = "file" name = "image4" value = "${productDetail.image4}"></td>
	</tr>
	
	<tr>
		<td>useyn</td>
		<td colspan = "2"><input type = "text" name = "useyn" size = "40" maxlength = "1" value = "${productDetail.useyn}"></td>
	</tr>
	
	<tr>
		<td>bestyn</td>
		<td colspan = "2"><input type = "text" name = "bestyn" size = "40" maxlength = "1" value = "${productDetail.bestyn}"></td>
	</tr>

	<tr>
		<td colspan = "2">상세정보1</td>
	</tr>
	
	<tr>
		<td colspan = "2"><textarea name= "content2" rows= "14" cols="50">${productDetail.detail}</textarea></td>
	</tr>
	
	<tr>
		<td colspan = "2">상세정보2</td>
	</tr>
	
	<tr>
		<td colspan = "2"><textarea name= "content2" rows= "14" cols="50">${productDetail.detail2}</textarea></td>
	</tr>
</table>

	<div class = "btn_group">
		<input class = "b1" type = "reset" value = "지우기">
		<input class = "b2" type = "button" value = "수정" onclick = "edit()">
	</div>

</form>

</body>
</html>