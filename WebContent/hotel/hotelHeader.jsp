<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');

	.header_container {
		width : 1850px;
		margin : 0 auto;		
		text-align : center;
		border-bottom : 2px solid rgb(56, 116, 70);
		
	}
	.header_container a {
		color : black;
	}
	
	
	.login {
		float : right;
	}
	
	.logo {
		font-size : 30px;
		padding : 30px;
		padding-left : 800px;
	}
	
	.logo img {
		width : 100px;
	}
	
	.hotelMenu {
		font-size : 20px;
		position : relative;
		display : inline-block;	/* dropDown*/
	}
	
	.header_content {					/* dropDown*/
		font-size : 15px;
		display: none;
		position: absolute;
		width : 100%;
		height : 250px;
		background-color: white;
		z-index: 1;
	}
	
	.header_content a {				/* dropDown*/
		color: black;
		padding: 12px 16px;
		text-decoration: none;
		display: block;
	}
	
	.header_content a:hover {			/* dropDown*/
		background-color: #ddd;
	}
	
	.hotelMenu:hover .header_content {	/* dropDown*/
		display : block;
		border-top : 1px solid green;
	}
	
</style>
<div class = "back">
<div class = "header_container">

	<div class = "row login">
		<c:choose>
		
			<c:when test = "${hotelMember != null}">
<%-- 				<a href = "memberInfoUpdate.do?no=${hotelMember.no}">나의 정보 | </a> --%>
				<a href = "checkPwForm.do"> 나의 정보 | </a>
				<a href = "shopCartList.do"> 장바구니 | </a>
				<a href = "customerServiceForm.do"> 고객센터 | </a>
				 ${hotelMember.name} 님  <a href = "logout.do"> 로그아웃</a>
			</c:when>
			
			<c:when test = "${hotelWorker != null}">
				<a href = "adminPage.do">관리자 페이지</a>
				${hotelWorker.name}<a href = "logout.do">로그아웃</a>
			</c:when>
			
			<c:otherwise>
				<a href = "loginForm.do">로그인 | </a>
				<a href = "insertForm.do"> 회원가입 | </a>
				<a href = "customerServiceForm.do"> 고객센터</a>
			</c:otherwise>
			
		</c:choose>
	</div>
	
	<div class = "row logo">
		<a href = "main.do"><img src = "http://localhost:8080/project/hotel/img/펭귄.jpg">펭귄인더월드</a>
	</div>
	
	<div class = "row hotelMenu">
		
		<div class = "col-2">	
				
			<a href = "">객실</a>	
			
			<div class = "header_content">

				<a href = "roomDetail.do?kind=1">스탠다드</a>
				<a href = "roomDetail.do?kind=2">디럭스</a>
				<a href = "roomDetail.do?kind=3">그랜드</a>
				
			</div>
		</div>
		
		<div class = "col-2">
		
			<a href = "">여행 코스</a>
			
			<div class = "header_content">
				<a href = "#">1박 2일</a>
				<a href = "#" onclick = "alert('빠른시일내에 준비하겠습니다.🤙')">2박 3일</a>
			</div>
					
		</div>
		
		<div class = "col-2">
		
			<a href = "">SHOP</a>
			
			<div class = "header_content">
			
<%-- 				<c:forEach var = "productList" items = "${productList}"> --%>
<%-- 					<a href = "shopProductCatagory.do?kind=${productList.kind}"> --%>
<%-- 						<c:choose> --%>
<%-- 							<c:when test = "${productList.kind eq 1}">주방</c:when> --%>
<%-- 							<c:when test = "${productList.kind eq 2}">욕실</c:when> --%>
<%-- 							<c:when test = "${productList.kind eq 3}">여행</c:when> --%>
<%-- 							<c:when test = "${productList.kind eq 4}">음료</c:when> --%>
<%-- 						</c:choose> --%>
<!-- 					</a><p> -->
<%-- 				</c:forEach> --%>
				
				
					<a href = "shopProductCatagory.do?catagory&kind=1">주방</a>
					<a href = "shopProductCatagory.do?catagory&kind=2">욕실</a>
					<a href = "shopProductCatagory.do?catagory&kind=3">여행</a>
					<a href = "shopProductCatagory.do?catagory&kind=4">음료</a>
			
				
			</div>
			
		</div>
		
		<div class = "col-2">
		
			<a href = "">후원</a>
			
			<div class = "header_content">
				<a href = "donationInsertForm.do">후원하기</a>
				<a href = "donationList.do">나의 후원내역     </a>
				<a href = "donationCOU.do">후원금 사용내역	</a><p>
			
			</div>
			
		</div>
		
		<div class = "col-2">
		
			<a href = "">펭귄보호활동</a>
			
			<div class = "header_content">
				<a href = "storyOfPenguinList.do">펭귄의 이야기</a>
				<a href = "campaignList.do">펭귄보호 활동</a>
				<a href = "campaignJoinForm.do">활동 참여</a><p>
			</div>
			
		</div>
		
		<div class = "col-2">
		
			<a href = "#">게시판</a>
			
			<div class = "header_content">
				<a href = "campaignReviewList.do">활동 후기</a>
				<a href = "hotelReviewList.do">여행 후기</a>
			</div>
		</div>

	</div>

</div>
<!-- a href = # onclick = 함수() -> 스크립트 alert -->
</div>
<!DOCTYPE html>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- 구글 ICON 링크 -->
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">   
    
<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
