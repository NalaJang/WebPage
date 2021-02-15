<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지(상품목록)</title>
</head>
<body>
<form action = "productInsertForm.do" method = "post">
<jsp:include page="/hotel/adminPageHeader.jsp"/>

<input type = "submit" value = "상품등록">
	<table border = "1">
	
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>종류</th>
			<th>가격1</th>
			<th>가격2</th>
			<th>상품정보</th>
			<th>수량</th>
			<th>image1</th>
			<th>image2</th>
			<th>image3</th>
			<th>image4</th>
			<th>useyn</th>
			<th>bestyn</th>
			<th>등록날짜</th>
			<th>상세정보</th>
			<th>삭제</th>
		</tr>
		
		
		<c:forEach var = "productList" items = "${productList}">
			<tr>
					
				<td>${productList.pseq}</td>
				<td><a href = "productEditForm.do?pseq=${productList.pseq}">${productList.name}</a></td>
				<td>${productList.kind}</td>				
				<td>${productList.price1}</td>
				<td>${productList.price2}</td>
				<td>${productList.content}</td>
				<td>${productList.stock}</td>
				<td>${productList.image1}</td>
				<td>${productList.image2}</td>
				<td>${productList.image3}</td>
				<td>${productList.image4}</td>
				<td>${productList.useyn}</td>
				<td>${productList.bestyn}</td>
				<td>${productList.indate}</td>
				<td>${productList.detail}</td>
				<td><a href = "productDelete.do?pseq=${productList.pseq}">[삭제]</a></td>

			</tr>
		</c:forEach>
		
	</table>
</form>
</body>
</html>