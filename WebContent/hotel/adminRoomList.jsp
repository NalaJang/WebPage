<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지(객실목록)</title>
</head>
<body>
<form action = "roomInsertForm.do" method = "post">
<jsp:include page="/hotel/adminPageHeader.jsp"/>

<input type = "submit" value = "객실등록" style = "padding : 10px;">
	<table border = "1">
	
		<tr>
			<th>방번호</th>
			<th>종류(숫자)</th>
			<th>정보</th>
			<th>가격</th>
			<th>image1</th>
			<th>image2</th>
			<th>image3</th>
			<th>image4</th>
			<th>useyn</th>
			<th>상세정보</th>
			<th>후원금</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var = "roomList" items = "${roomList}">
			<tr>
					
				<td>${roomList.rseq}</td>
				<td><a href = "roomInfoEditForm.do?rseq=${roomList.rseq}">${roomList.kind}</a></td>
				<td>${roomList.content}</td>
				<td>${roomList.price}</td>
				<td>${roomList.image1}</td>
				<td>${roomList.image2}</td>
				<td>${roomList.image3}</td>
				<td>${roomList.image4}</td>
				<td>${roomList.useyn}</td>
				<td>${roomList.detail}</td>
				<td>${roomList.donation}</td>
				<td><a href = "roomDelete.do?rseq=${roomList.rseq}">[삭제]</a></td>
			</tr>
		</c:forEach>
		
	</table>
</form>
</body>
</html>