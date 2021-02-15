<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 600px;
	}
	
	.middle {
		text-align : center;
		padding-left : 470px;
	}

	.ment {
		font-size : 35px;
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	.ment2 {
		padding-left : 470px;
	}
	
	.row.btn {
		padding-left : 470px;
	}
</style>

</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<div class = "container">

	<div class = "row ment">
		나의 문의 내역
	</div>
	
	<c:choose>
		<c:when test = "${qnaList.size() == 0}">
			<div class = "ment2">
				<b>문의 내역이 없습니다.</b>
			</div>
		</c:when>
		
		<c:otherwise>
			<div class = "row middle">
			
				<div>
					<table border = "1" style = "width : 600px;">
						<tr>
							<th>문의주제</th>
							<th>문의제목</th>
							<th>문의내용</th>
							<th>작성일   </th>
							<th>답변여부</th>					
						</tr>
						
						<c:forEach var = "qnaList" items = "${qnaList}">
							<tr>
								<!-- 타이틀 -->
								<td>
									<c:choose>
										<c:when test = "${qnaList.title eq 1}">객실문의</c:when>
										<c:when test = "${qnaList.title eq 2}">예약문의</c:when>
										<c:when test = "${qnaList.title eq 3}">상품문의</c:when>
										<c:when test = "${qnaList.title eq 4}">배송문의</c:when>
										<c:when test = "${qnaList.title eq 5}">후원문의</c:when>
										<c:when test = "${qnaList.title eq 6}">기타문의</c:when>
									</c:choose>
								</td>
								
								<!-- 문의제목 -->
								<td>${qnaList.subject}</td>
								
								<!-- 문의내용 -->
								<td><a href = "qnaContent.do?qseq=${qnaList.qseq}">${qnaList.content}</a></td>
								
								<!-- 작성일 -->
								<td>${qnaList.indate}</td>
								
								<!-- 답변처리현황 -->
								<td>
									<c:choose>
										<c:when test = "${qnaList.rep eq 1}">답변준비중</c:when>
										<c:otherwise>답변완료</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
	
			<div class = "row btn">
				<input type = "button" value = "문의하기" onclick = "location.href = 'qnaInsertForm.do'">
			</div>

		</c:otherwise>
	</c:choose>
</div>

<jsp:include page="/hotel/hotelTail.jsp"/>
</body>
</html>