<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지(고객목록)</title>
</head>
<body>
<jsp:include page="/hotel/adminPageHeader.jsp"/>
	<table border = "1">
	
		<tr>
			<th>번호</th>
			<th>회원이름</th>
			<th>이메일</th>
			<th>휴대폰번호</th>
			<th>비밀번호</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>useyn</th>
			<th>가입날짜</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var = "memberList" items = "${memberList}">
			<tr>
					
				<td>${memberList.no}</td>
				<td><a href = "memberEditForm.do?no=${memberList.no}">${memberList.name}</a></td>
				<td>${memberList.email}		</td>
				<td>${memberList.phone}		</td>
				<td>${memberList.pw}		</td>
				<td>${memberList.zip_num}	</td>
				<td>${memberList.address1}	</td>
				<td>${memberList.address2}	</td>
				<td>${memberList.useyn}		</td>
				<td>${memberList.indate}	</td>
				<td><a href = "memberDelete.do?email=${memberList.email}">[삭제]</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>