<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.ment {
		font-size : 35px;
		padding-left : 170px;
	}
	
	.main {
		padding-left : 550px;
	}
	
	textarea {
		font-size : 18px;
	}
	
	.btn_group {
		padding-left : 550px;
	}
	
	.btn_group input {
		margin : 10px;
		padding : 10px;
	}
</style>

</head>
<body>
<jsp:include page="/hotel/adminPageHeader.jsp"/>
<form name = "frm" action = "roomInfoEdit.do?rseq=${roomVo.rseq}" method = "post">

	<div class = "ment">
		객실 수정
	</div>
	
	<div class = "main">
		<table border = "1">
			<tr>
				<th>
					종류
				</th>
				
				<td>
					<!-- 객실 종류 -->
					<input type = "text" name = "kind" size = "50" maxlength = "1" value = "${roomVo.kind}">

				</td>
			</tr>
			
			<tr>
				<th>
					정보
				</th>
				
				<td>
					<!-- 정보 -->
					<textarea name= "content" rows= "14" cols="50">${roomVo.content}</textarea>
				</td>
			</tr>
			
			<tr>
				<th>
					가격
				</th>
				
				<td>
					<!-- 가격 -->
					<input type = "text" value = "${roomVo.price}">
				</td>	
			</tr>
			
			<tr>
				<th>
					이미지1
				</th>
				
				<td>
					<!-- 이미지 -->
					<input type = "text" value = "${roomVo.image1}">
				</td>	
			</tr>
			
			<tr>
				<th>
					이미지2
				</th>
				
				<td>
					<!-- 이미지 -->
					<input type = "text" value = "${roomVo.image2}">
				</td>	
			</tr>
			
			<tr>
				<th>
					이미지3
				</th>
				
				<td>
					<!-- 이미지 -->
					<input type = "text" value = "${roomVo.image3}">
				</td>	
			</tr>
			
			<tr>
				<th>
					이미지4
				</th>
				
				<td>
					<!-- 이미지 -->
					<input type = "text" value = "${roomVo.image4}">
				</td>	
			</tr>
			
			<tr>
				<th>
					useyn
				</th>
				
				<td>
					<!-- useyn -->
					${roomVo.useyn}
				</td>	
			</tr>
			
			<tr>
				<th>
					상세정보
				</th>
				
				<td>
					<!-- 상세정보 -->
					<textarea name= "detail" rows= "14" cols="50">${roomVo.detail}</textarea>
				</td>	
			</tr>
			
			<tr>
				<th>
					후원금
				</th>
				
				<td>
					<!-- 후원금 -->
					${roomVo.donation}
				</td>	
			</tr>
		</table>
	</div>
	
	<div class = "btn_group">
		<input type = "button" value = "취소" onclick = "history.back();">
		<input type = "submit" value = "수정" onclick = "alert('수정되었습니다.')" style = "color : white; background-color : blue;">
	</div>


</form>
</body>
</html>