<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.main {
		padding-left : 450px;
	}
	
	input, textarea {
		font-size : 18px;
	}
</style>
<script>
	function insert() {
		if(document.frm.subject.value == "") {
			alert("제목을 입력해주세요");
			document.frm.subject.focus();
			
		} else if(document.frm.content.value == "") {
			alert("내용을 입력해주세요");
			document.frm.content.focus();
			
		} else if(document.frm.content2.value == "") {
			alert("내용을 입력해주세요");
			document.frm.content2.focus();
			
		} else {
			if(confirm('수정하시겠습니까?')){
				alert("수정되었습니다.");
				document.frm.action = "boardEdit.do?num=" + ${penguinVo.num};
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

<h2>게시판 등록</h2>

<div class = "main">
	<table border = "1">
		<tr>
			<th>제목</th>
			<td><input type = "text" name = "subject" size = "60" value = "${penguinVo.subject}"></td>
		</tr>
		
		<tr>
			<td>내용1</td>
			<td><textarea name= "content" rows= "14" cols="60">${penguinVo.content}</textarea></td>
		</tr>
		
		<tr>
			<td>내용2</td>
			<td><textarea name= "content2" rows= "14" cols="60">${penguinVo.content2}</textarea></td>
		</tr>
		
		<tr>
			<td>이미지1</td>
			<td><input type = "text" name = "image1" value = "${penguinVo.image1}"></td>
		</tr>
		
		<tr>
			<td>이미지2</td>
			<td><input type = "text" name = "image2" value = "${penguinVo.image2}"></td>
		</tr>
		
		<tr>
			<td>이미지3</td>
			<td><input type = "text" name = "image3" value = "${penguinVo.image3}"></td>
		</tr>
	</table>

	<input type = "reset" value = "취소">
	<input type = "button" value = "수정" onclick = "insert()" style = "color : white; background-color : blue;">
	
</div>
</form>
</body>
</html>