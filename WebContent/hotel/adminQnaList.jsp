<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지(문의내역)</title>
</head>
<body>
<jsp:include page="/hotel/adminPageHeader.jsp"/>

<table border = "1">
	<tr>
		<th>번호</th>
		<th>타이틀</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>답변처리현황</th>
		<th>답변시간</th>
	</tr>
	
	<c:forEach var = "qnaList" items = "${qnaList}">
		<tr>
			<!-- 번호 -->
			<td>${qnaList.qseq}</td>
			
			<!-- 문의 타이틀 -->
			<td>
				<a href = "qnaContent.do?qseq=${qnaList.qseq}">
					<c:choose>
						<c:when test = "${qnaList.title eq 1}">객실문의</c:when>
						<c:when test = "${qnaList.title eq 2}">예약문의</c:when>
						<c:when test = "${qnaList.title eq 3}">상품문의</c:when>
						<c:when test = "${qnaList.title eq 4}">배송문의</c:when>
						<c:when test = "${qnaList.title eq 5}">후원문의</c:when>
						<c:when test = "${qnaList.title eq 6}">기타문의</c:when>
					</c:choose>
				</a>
			</td>
			
			<!-- 문의제목 -->
			<td>${qnaList.subject}</td>
			
			<!-- 작성자 -->
			<td>${qnaList.email}</td>
			
			<!-- 작성일 -->
			<td>${qnaList.indate}</td>
			
			<!-- 답변처리현황 -->
			<td>
				<c:choose>
					<c:when test = "${qnaList.rep eq 1}">미처리</c:when>
					
					<c:otherwise>처리완료</c:otherwise>
				</c:choose>
			</td>
			
			<!-- 답변작성일 -->
			<td>${qnaList.reply_date}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>