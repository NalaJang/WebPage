<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	.board {
		font-size : 18px;
		padding-left : 600px;
	}
	
	.board div {
		margin : 20px;
	}
	
	.row.btn {
		margin-left : 300px;
	}
	
	.btn input{
		color : white;
		width : 150px;
		padding: 5px;
		background-color : rgb(56, 116, 70);
	}
	
	.btn:hover input {
		color : rgb(56, 116, 70);
		background-color : white;
	}
</style>

</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<form name = "frm" action = "hotelReviewInsert.do" method = "post">

<div class = "container">

	<div class = "row ment">
		후기 작성
	</div>

	<div class = "board">
		<div class = "row">
			제목&nbsp;&nbsp;
			<input type = "text" name = "subject" style = "width : 400px;">
		</div>
		
		<div class = "row">
			내용&nbsp;&nbsp;
			<textarea class = "form-control" name = "content" maxlength = "1000" style = "width : 400px; height : 350px;"></textarea>
		</div>
		
		<div class = "row btn">
			<input type = "submit" value = "후기 올리기">
		</div>
	</div>

</div>


</form>
<jsp:include page = "/hotel/hotelTail.jsp"/>

</body>
</html>