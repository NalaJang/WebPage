<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지(게시판목록)</title>
<style>
	.content {
		overflow: hidden;
	    text-overflow: ellipsis;
	    display: -webkit-box;
	    -webkit-line-clamp: 3; /* 라인수 */
	    -webkit-box-orient: vertical;
	    word-wrap:break-word; 
	    line-height: 1.2em;
	    height: 3.6em;  /* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
	}
</style>
</head>
<body>

<form action = "boardInsertForm.do" method = "post">
<jsp:include page="/hotel/adminPageHeader.jsp"/>

<input type = "submit" value = "게시글등록">

<table border = "1">
	<c:forEach var = "boardList" items = "${boardList}">
	
		<tr style = "text-align : center;">
			<th>번호	</th>
			<th>${boardList.num}</th>
		</tr>
	
		<tr>
			<th>제목</th>
			<td class = "content"><a href = "boardEditForm.do?num=${boardList.num}">${boardList.subject}</a></td>
		</tr>
		
		<tr>
			<th>내용1	</th>
			<td class = "content">${boardList.content}</td>
		</tr>
		
		<tr>
			<th>내용2	</th>
			<td class = "content">${boardList.content2}</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>${boardList.email}</td>
		</tr>
		
		<tr>
			<th>등록일</th>
			<td>${boardList.indate}</td>
		</tr>
		
		<tr>
			<th>mainyn</th>
			<td>${boardList.mainyn}</td>
		</tr>
		
		<tr>
			<td colspan = "2"><a href = "boardDelete.do?num=${boardList.num}" style = "color : red;">[삭제]</a></td>
		</tr>
		
		<tr>
			<td colspan = "2" style = "background-color : green;"></td>
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>