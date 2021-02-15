<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.main {
		padding-left : 500px;
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
			if(confirm('글을 등록하시겠습니까?')){
				alert("등록되었습니다.");
				document.frm.action = "boardInsert.do";
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

<h2>게시글 등록</h2>

<div class = "main">
	<table border = "1">
		<tr>
			<td>제목</td>
			<td><input type = "text" name = "subject" size = "50"></td>
		</tr>
		
		<tr>
			<td>내용1</td>
			<td><textarea name= "content" rows= "14" cols="50"></textarea></td>
		</tr>
		
		<tr>
			<td>내용2</td>
			<td><textarea name= "content2" rows= "14" cols="50"></textarea></td>
		</tr>
		
		<tr>
			<td>이미지1</td>
			<td><input type = "file" name = "image1"></td>
		</tr>
		
		<tr>
			<td>이미지2</td>
			<td><input type = "file" name = "image2"></td>
		</tr>
		
		<tr>
			<td>이미지3</td>
			<td><input type = "file" name = "image3"></td>
		</tr>
	</table>

	<input type = "reset" value = "취소">
	<input type = "button" value = "등록" onclick = "insert()" style = "color : white; background-color : blue;">
	
</div>
</form>
</body>
</html>