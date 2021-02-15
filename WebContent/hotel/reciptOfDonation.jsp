<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 	.container { */
/* 		mid-width : 1600px; */
/* 		padding-top : 50px; */
/* 		padding-bottom : 600px; */
/* 	} */
	.container {
		border : 1px solid black;
		padding-bottom : 40px;
	}
	
	.title {
		font-size : 23px;
		padding-top : 10px;
		padding-left : 250px;
	}
	
	.middle {
		padding-top : 20px;
		padding-left : 20px;
	}
	
	.middle div {
		margin : 10px;
	}
	
	.sub_title {
		font-size : 17px;	
	}
	
	img {
		width : 50px;
	}
</style>
</head>
<body>

<div class = "container">
	<div class = "title">
		<b>기부금 영수증</b>
	</div>
	
	<div class = "middle">
	
		<table border = "1">
			<tr>
				<td colspan = "8">1. 기부자</td>
			</tr>
			
			<tr>
				<td>성명(법인명)</td>
				<td>${hotelMember.name}</td>
				<td>주민등록번호</td>
				<td colspan = "5"></td>
			</tr>
			
			<tr>
				<td>주소</td>
				<td colspan = "7"></td>
			</tr>
			
			<tr>
				<td colspan = "8">2. 기부금 단체</td>
			</tr>
			
			<tr>
				<td>단체명</td>
				<td>재단법인 펭귄인더월드</td>
				<td>사업자등록번호<br>(고유번호)</td>
				<td colspan = "5"></td>
			</tr>
			
			<tr>
				<td>소재지</td>
				<td colspan = "7">서울시 용산구 한강대로 257</td>
			</tr>
			
			<tr>
				<td colspan = "8">3. 기부금 모집처(언론기관 등)</td>
			</tr>
			
			<tr>
				<td>단체명</td>
				<td></td>
				<td>사업자등록번호</td>
				<td colspan = "5"></td>	
			</tr>
			
			<tr>
				<td>소재지</td>
				<td colspan = "7"></td>
			</tr>
			
			<tr>
				<td colspan = "8">4. 기부내용</td>
			</tr>
			
			<tr style = "text-align : center">
				<td rowspan = "2">유형</td>
				<td rowspan = "2">코드</td>
				<td rowspan = "2">구분</td>
				<td rowspan = "2">연월일</td>
				<td colspan = "3">내용</td>
				<td rowspan = "2">금액</td>
			</tr>
			
			<tr style = "text-align : center">
				<td>품명</td>
				<td>수량</td>
				<td>단가</td>
			</tr>
			<c:forEach var = "list" items = "${donationList}">
				<tr style = "text-align : center">
					<td>지정기부금</td>
					<td>40</td>
					<td></td>
					<td><fmt:formatDate value = "${list.indate}" pattern = "yyyy/MM/dd"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td><fmt:formatNumber value = "${list.money}" pattern = "#,###" /></td>
				</tr>
			</c:forEach>
			
			<tr style = "text-align : center">
				<td colspan = "7">합계</td>
				<td><fmt:formatNumber value = "${donationTotal}" pattern = "#,###" /></td>
			</tr>
			
			<tr style = "text-align : center">
				
				<td colspan = "8"><fmt:formatDate value = "${date1}" pattern = "yyyy년 MM월 dd일"/>
				<%
					out.println(new SimpleDateFormat("yyyy년 MM월 dd일").format(new java.util.Date()));
				%>
				</td>
			</tr>
			
			<tr style = "text-align : center">
				<td colspan = "4">신청인(기부자)</td>
				<td colspan = "2">${hotelMember.name}</td>
				<td colspan = "2">(서명 또는 인)</td>
			</tr>
			
			<tr style = "text-align : center">
				<td colspan = "8">위와 같이 기부금을 기부받았음을 증명합니다.</td>
			</tr>
			
			<tr style = "text-align : center">
				<td colspan = "8"><fmt:formatDate value = "${date1}" pattern = "yyyy년 MM월 dd일"/>
				<%
					out.println(new SimpleDateFormat("yyyy년 MM월 dd일").format(new java.util.Date()));
				%>
				</td>
			</tr>
			
			<tr style = "text-align : center">
				<td rowspan = "2" colspan = "4">기부금수령인 </td>
				<td rowspan = "2" colspan = "4">펭귄인더월드 <img src = "http://localhost:8080/project/hotel/img/도장.JPG"></td>
			</tr>
		</table>
	</div>
</div>
	
</body>
</html>