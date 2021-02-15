<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 300px;
	}
	
	.main, .reply {
		margin-bottom : 30px;
		padding-left : 550px;
	}
	
	.title, .subject {
		font-size : 18px;
	}
	
	.date {
		font-size : 13px;
	}

</style>

<script>
	function insert(){
		
		if(confirm("답변을 등록하시겠습니까?")) {
			alert("등록되었습니다.");
			document.frm.action = "qnaReplyUpdate.do?qseq="+${qnaVo.qseq};
			document.frm.submit();
			
		} else {
			return;
		}
	}
</script>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" method = "post">
<div class = "container">
	<div class = "main">
	
		<a href = "qnaList.do">문의내역 > </a>
	
		<table border = "1" style = "width : 600px;">
			<tr>
				<td>
					<div class = "title">
						<c:choose>
							<c:when test = "${qnaVo.title eq 1}">객실문의</c:when>
							<c:when test = "${qnaVo.title eq 2}">예약문의</c:when>
							<c:when test = "${qnaVo.title eq 3}">상품문의</c:when>
							<c:when test = "${qnaVo.title eq 4}">배송문의</c:when>
							<c:when test = "${qnaVo.title eq 5}">후원문의</c:when>
							<c:when test = "${qnaVo.title eq 6}">기타문의</c:when>
						</c:choose>
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div class = "subject">
						${qnaVo.subject}
					</div>
					<div class = "date">
						<fmt:formatDate value = "${qnaVo.indate}" pattern = "yy.MM.dd HH:mm"/>
					</div>
				</td>				
			</tr>
			
			<tr>
				<td>
					<div class = "content">
						${qnaVo.content}
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class = "reply">
		<c:forEach var = "replyList" items = "${replyList}">
			<table>
				<tr>
					<td>${replyList.reply_date}</td>
				</tr>
				
				<tr>
					<td>${replyList.reply}</td>
				</tr>
			</table>
			
		</c:forEach>
	</div>
	
	<div class = "reply">
		<c:choose>
		
			<c:when test = "${replyList.size() == 0}">
			
				<c:when test = "${hotelWorker != null}">
					<textarea class = "form-control" name = "reply" maxlength = "1000" required style = "width : 600px; height : 300px;"></textarea>
					<input type = "button" value = "답변작성하기" onclick = "insert()">
				</c:when>
			</c:when>
			
			<c:otherwise>
				<c:if test="${hotelWorker != null}">
				
					<textarea class = "form-control" name = "reply_update" maxlength = "1000" required style = "width : 600px; height : 300px;"></textarea>
					<input type = "button" value = "수정하기" onclick = "insert()">
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</form>

<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>