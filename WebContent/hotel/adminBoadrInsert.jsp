<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>

<script>
	function back() {
		history.back();
	}
</script>

</head>
<body>
<jsp:include page = "/hotel/adminPageHeader.jsp"/>

<form name = "frm" action = "storyOfPenguinInsert.do" method = "post">

	<table border = "1">
		<tr>
			<th>
				제목
			</th>
			
			<th>
				<input type = "text" name = "subject">
			</th>
		</tr>
		
		<tr>
			<th>
				내용
			</th>
			
			<th>
				<textarea class = "form-control" name = "detail" maxlength = "1000" style = " width : 300px; height : 200px;"></textarea>
			</th>
		</tr>
	</table>
	
	<input type = "button" value = "뒤로" onclick = "history.back();">
	<input type = "button" value = "등록" onclick = "insert()">

</form>
</body>
</html>