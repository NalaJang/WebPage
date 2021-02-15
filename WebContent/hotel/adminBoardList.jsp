<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<jsp:include page = "/hotel/adminPageHeader.jsp"/>

<input type = "button" value = "게시글 등록" onclick = "storyOfPenguinInsertForm.do">

<h3>펭귄의 이야기</h3><hr>

<table border = "1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>이미지1</th>
		<th>이미지2</th>
		<th>이미지3</th>
		<th>조회수</th>
	</tr>
	
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
</body>
</html>