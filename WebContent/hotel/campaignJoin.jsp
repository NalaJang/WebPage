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
	
	.title {
		font-size : 30px;
	}
	
	.ment {
		margin : 30px;
		padding-left : 30px;
	}
	
	.subject {
		margin : 60px;
		font-size : 25px;
		font-weight : bold;
		padding-left : 700px;
	}
	
	.middle, .bottom {
		padding-left : 300px;
	}
	
	.challenge div, .joinUs div {
		margin : 10px;
	}
	
	.sub_title {
		font-size : 18px;
		font-weight : bold;
	}
	
	.link {
		padding-left : 95px;
	}
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<div class = "container">

	<div class = "title">
		<b>캠페인에 동참하고 싶으신가요?</b>
	</div>
	
	<div class = "row ment">
		소셜미디어에서 저희의 캠페인을 공유하거나 생활 속에서 플라스틱 줄이기에 도전하기,<br>
		오프라인 이벤트에 참석하기, 자원봉사, 나만의 환경 캠페인 시작하기 등 다양한 방법으로 참여하실 수 있습니다.<br>
		더 많은 참여 방법을 알고 싶으시면 클릭하세요!
	</div>
		
	
	<div class = "row subject">
		펭귄을 위한 매일 챌린지
	</div>
	
	
	<div class = "row middle">
		<div class = "col-3 challenge">
			
			<div class = "row sub_title">
				일주일에 하루는 채식하기
			</div>
				
			<div class = "row img">
				<img src = "http://localhost:8080/project/hotel/img/campaign.jpg" alt = "">
			</div>
			
			<div class = "row link">
				<a href = "https://www.facebook.com/pg/greenpeacekorea/events/">동참하기</a>
			</div>
		</div>	
		
		<div class = "col-3 challenge">
		
			<div class = "row sub_title">
				자동차 대신 자전거 이용하기
			</div>
			
			<div class = "row img">
				<img src = "http://localhost:8080/project/hotel/img/campaign2.jpg" alt = "">
			</div>
			
			<div class = "row link">
				<a href = "https://www.facebook.com/pg/greenpeacekorea/events/">동참하기</a>
			</div>

		</div>
		
		<div class = "col-3 challenge">
		
			<div class = "row sub_title">
				지역에서 생산된 제품 사기
			</div>
			
			<div class = "row img">
				<img src = "http://localhost:8080/project/hotel/img/campaign3.jpg" alt = "">
			</div>
			
			<div class = "row link">
				<a href = "https://www.facebook.com/pg/greenpeacekorea/events/">동참하기</a>
			</div>
		</div>
	</div>
	
	
	<div class = "row subject">
		활동에 동참하세요!
	</div>
	
	<div class = "row bottom">
		
		<div class = "col-3 joinUs">
		
			<div class = "row sub_title">
				자원봉사 
			</div>
			
			<div class = "row ment2">
				전 세계 15,000명이 넘는 자원봉사자들이 평화적 직접행동에서부터 이벤트 진행, 
				과학 리서치 등 다양한 방법으로 그린피스의 활동을 지원해 주십니다. 
				자원봉사자나 활동가가 되고 싶으세요? 바로 지금 신청하세요.
			</div>
			
			<div class = "row link">
				<a href = "https://act.greenpeace.org/page/64950/petition/1">참여하기</a>
			</div>
		</div>
		
		
		<div class = "col-3 joinUs">
		
			<div class = "row sub_title">
				이벤트 참여하기
			</div>
	
			<div class = "row ment2">
				제로 웨이스트, 미니멀리즘, 채식 위주 식단, 슬로우 패션, 업사이클, DIY, 직접 만들고 수선하기. 
				이런 주제에 대해 더 배우고 싶으세요? 그린피스의 커뮤니티와 이벤트에 동참해 주시고, 영감과 아이디어를 함께 나눠 주세요.
			</div>
			
			<div class = "row link">
				<a href="https://www.facebook.com/pg/greenpeacekorea/events/">참여하기</a>
			</div>
		</div>
		
		<div class = "col-3 joinUs">
		
			<div class = "row sub_title">
				거리모금가를 소개합니다
			</div>
	
			<div class = "row ment2">
				가장 가까운 곳에서 시민여러분과 소통하는 거리모금가들은 환경 문제의 긴급성을 알리고 참여를 이끌어내는 역할을 합니다. 
				그린피스의 정치적, 재정적 독립성을 지키는 거리모금가의 활동에 대해 알아보세요!
			</div>
			
			<div class = "row link">
				<a href="https://www.facebook.com/pg/greenpeacekorea/events/">참여하기</a>
			</div>
		</div>
	</div>

</div>

<jsp:include page = "/hotel/hotelTail.jsp"/>

</body>
</html>