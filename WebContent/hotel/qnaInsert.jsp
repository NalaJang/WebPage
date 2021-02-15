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
	
	.btn_group {
		padding-top : 40px;
		padding-left : 450px;
	}
	
	.btn_group input {
		width : 200px;
		padding: 10px;
		margin : 10px;
		font-weight : bold;
		
	}
	
	.b2 {
		color : white;
		background-color : rgb(56, 116, 70);
	}
</style>
<script>

	function back(){
		history.back();	
	}
	
	function insert(){
		if(document.frm.content.value == "") {
			alert("내용을 입력해 주세요.");
			
		} else {
			
			alert("문의가 등록되었습니다.");
			
			document.frm.action = "qnaInsert.do";
			document.frm.submit();
		}
	}
</script>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<form name = "frm" method = "post">
<div class = "container">

	<div class = "row ment">
		문의하기
	</div>
	
	<div class = "middle">
		<table border = "1" style = "text-align : center;">
			<tr>
				<th colspan = "2">
					<select id = "subject" name = "subject" size = "1" style = "width : 300px;">
						<option value = "1">객실문의
						<option value = "2">예약문의
						<option value = "3">상품문의
						<option value = "4">배송문의
						<option value = "5">후원문의
						<option value = "6">기타문의				
					</select>
				</th>	
			</tr>
			
			<tr>
				<th>제목</th>
				
				<td>
					<input type = "text" name = "title" size = "50">
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea class = "form-control" name = "content" maxlength = "1000" style = "width : 400px; height : 350px;"></textarea>
				</td>
			</tr>		
		</table>
		
	</div>
	
	<div class = "btn_group">
		<input class = "b1" type = "button" value = "뒤로가기" onclick = "back()">
		<input class = "b2" type = "button" value = "작성완료" onclick = "insert()">
	</div>

</div>
</form>
</body>
</html>