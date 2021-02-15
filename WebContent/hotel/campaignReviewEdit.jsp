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
		padding-bottom : 300px;
	}
	
	.ment {
		font-size : 35px;
		padding-left : 170px;
	}
	
	.main {
		padding-left : 550px;
	}
	
	.btn_group {
		padding-top : 30px;
		margin-left : 600px;
	}
	
	.btn_group input{
		padding: 5px;
		margin : 20px;
		width : 150px;
	}
	
	.b2 {
		color : white;
		background-color : rgb(56, 116, 70);
	}
	
	.btn_group.b2:hover input {
		color : rgb(56, 116, 70);
		background-color : white;
	}
</style>

</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<form name = "frm" action = "campaignReviewEdit.do?qseq=${reviewVo.qseq}" method = "post">

<div class = "container">

	<div class = "ment">
		후기 수정
	</div>
	
	<div class = "main">
		<table border = "1">
			<tr>
				<td>
					제목
				</td>
				
				<td>
					<!-- 후기 제목 -->
					<input type = "text" name = "subject" size = "50" value = "${reviewVo.subject}">

				</td>
			</tr>
			
			<tr>
				<td>
					작성자
				</td>
				
				<td>
					<!-- 작성자 -->
					${reviewVo.name}
				</td>
			</tr>
			
			<tr>
				<td>
					내용
				</td>
				
				<td>
					<!-- 내용 -->
					<textarea class = "content" name = "content" maxlength = "1000" style = "width : 400px; height : 350px;">
						${reviewVo.content}
					</textarea>

				</td>	
			</tr>
		</table>
	</div>
	
	<div class = "btn_group">
		<input class = "b1" type = "button" value = "취소" onclick = "history.back();">
		<input class = "b2" type = "submit" value = "수정" onclick = "alert('수정되었습니다.')">
	</div>
</div>

</form>
<jsp:include page = "/hotel/hotelTail.jsp"/>
</body>
</html>