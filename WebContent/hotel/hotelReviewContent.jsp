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
	
	.main {
		padding-left : 550px;
	}
	
	.subject {
		margin : 20px;
		font-size : 25px;
	}
	
	.date {
		margin-bottom : 10px;
		border-bottom : 1px solid grey;
	}
	
	.name, .date {
		font-size : 13px;
		margin-left : 5px;
	}
	
	.hr {
		margin : 30px;
		width : 600px;
		margin-left : 500px;
		border-top : 1px solid grey;
	}
	
	.content {
		margin : 30px;
		margin-left : 5px;
	}
	
	.ment {
		font-size : 20px;
		padding-bottom : 30px;
	}
	
	.ment, .replyInsert {
		padding-left : 500px;
	}
	
	.reply {
		margin-bottom : 30px;
	}
	
	.reply div {
		margin : 10px;
	}
	
	.reply_indate {
		font-size : 13px;
	}
	
</style>
</head>

<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<form name = "frm" action = "replyInsert.do" method = "post">
<input type = "hidden" name = "qseq" value = "${reviewVo.qseq}">

<div class = "container">

	<div class = "main">
	
	<a href = "hotelReviewList.do">여행후기 > </a>
	
		<table border = "1" style = "width : 500px;">
			<tr>
				<td>
					<!-- 후기 제목 -->
					<div class = "subject">
						<b>${reviewVo.subject}</b>
					</div>
					
					<!-- 작성자 -->
					<div class = "name">
						작성자 ${reviewVo.name}
					</div>
					
					<!-- 작성일 -->
					<div class = "date">
						<c:choose>
							<c:when test = "${reviewVo.edit_indate == null}">
							
								<fmt:formatDate value = "${reviewVo.indate}" pattern = "yy.MM.dd HH:mm"/>						
							</c:when>
							
							<c:otherwise>
								수정 <fmt:formatDate value = "${reviewVo.edit_indate}" pattern = "yy.MM.dd HH:mm"/>
							</c:otherwise>
						</c:choose>
					</div>
					
					<!-- 내용 -->
					<div class = "content">
						${reviewVo.content}
					</div>
				</td>
								
			</tr>
		</table>
		
		
	<!-- 작성자, 관리자에게만 삭제 또는 수정 버튼 보이기 -->
	<div class = "btn">
		<c:choose>
			<c:when test = "${hotelMember.email != null}">
				<c:if test = "${reviewVo.email eq hotelMember.email}">
				
					<a href = "reviewDelete.do?qseq=${reviewVo.qseq}">[삭제]</a>
					
					<a href = "reviewEditForm.do?qseq=${reviewVo.qseq}">[수정]</a>
				</c:if>
			</c:when>
			
			<c:when test = "${hotelWorker.email != null}">
				<a href = "reviewDelete.do?qseq=${reviewVo.qseq}">[삭제]</a>
			</c:when>
		</c:choose>
	</div>
	</div>

	
	<div class = "hr">
	
	</div>
	
	<div class = "ment">
		<b>댓글</b>
	</div>
	
	<div class = "replyInsert">
		
		<c:if test = "${hotelMember == null}">
			댓글을 작성하려면 <a href = "loginForm.do">로그인</a> 해주세요.
		</c:if>
		
		<c:if test = "${hotelMember != null}">
			<textarea class = "form-control" name = "content" maxlength = "1000" required style = "width : 500px; height : 60px;"></textarea>
			
			<div class = "btn">
				<input type = "submit" value = "댓글달기">
				<input type = "hidden" name = "qseq" value = "${reviewVo.qseq}"><!-- ***** -->
			</div>
		</c:if>
			
			
		<c:forEach var = "replyList" items = "${replyList}">
			
			<div class = "reply">
			
				<!-- 댓글 작성자 -->
				<div class = "reply_name"><b>${replyList.name}</b></div>
				
				<!-- 댓글 내용 -->
				<div class = "reply_content">
					<c:choose>
					
						<c:when test = "${replyList.admin_delete eq 'n'}">
							
							${replyList.content}
							
						</c:when>
						
						<c:otherwise>
							관리자에 의해 삭제 되었습니다.
						</c:otherwise>
					</c:choose>
				</div>
					<c:choose>
					
						<c:when test = "${hotelMember.email != null}">
							<c:if test = "${replyList.email eq hotelMember.email}">
							
								<a href = "replyDelete.do?replynum=${replyList.replynum}&qseq=${replyList.qseq}" onclick = "alert('삭제되었습니다.')">[삭제]</a>
							</c:if>
							
						</c:when>
						
						<c:when test = "${hotelWorker.email != null}">
							<a href = "admin_delete.do?replynum=${replyList.replynum}&qseq=${replyList.qseq}">[삭제]</a>
						</c:when>
		
					</c:choose>
								
				
				<!-- 댓글 작성시간-->
				<div class = "reply_indate"><fmt:formatDate value = "${replyList.indate}" pattern = "yy.MM.dd HH:mm"/></div>
				
				<div class = "hr">
				
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</form>
<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>