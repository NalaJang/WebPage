<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


<style>
	.container {
		min-width : 1600px;
		padding-top : 20px;
		padding-bottom : 300px;
	}
	
	.img {
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	.subject {
		font-size : 35px;
		padding-left : 170px;
		padding-bottom : 30px;
	}
	
	.content {
		padding-left : 170px;
	}
		
	.content span {
		font-weight : 400;
	}
	
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<div class = "container">

	<div class = "row img">
		<img src = "http://localhost:8080/project/hotel/img/턱끈펭귄.jpg">
	</div>
	
	<div class = "row subject">
		<b>그린피스 “남극 턱끈펭귄 7만 쌍 사라졌다”</b>
	</div>
	
	<div class = "row content">
		<p><span style="font-weight: 400">
		미국 스토니브룩 대학의 헤더 린치(Heather Lynch) 교수가 이끄는 연구팀은 지난 1월부터 그린피스와 함께 환경감시선 에스페란자를 타고 남극으로 이동해 턱끈펭귄 개체 수를 조사했다.<br>
		턱을 가로지르는 검은색의 얇은 띠 무늬를 따서 이름 지은 턱끈펭귄은 황제핑귄, 이델리펭귄과 함께 남극을 대표하는 종이다.</span></p>
		
		<div class = "img">
			<img src = "http://localhost:8080/project/hotel/img/턱끈펭귄2.jpg">
		</div>
		
		<p><span>남극반도 북동부에 위치한 코끼리섬은 턱끈펭귄의 주요 서식지로 알려져있다. 연구팀은 사람이 접근할 수 없는 지역은 정밀 항공 촬영이 가능한 드론을 띄워 조사를 실시했다.<br>조사 결과 섬 내 서식 중인 모든 턱끈펭귄 무리에서 개체 수 감소가 발견됐다. 가장 많이 줄어든 무리의 경우, 1971년에 진행됐던 마지막 조사 대비 77%까지 줄어들었다. 섬에 서식하는 전체 턱끈펭귄 중 번식 가능한 쌍은 1971년의 12만2550쌍에서 현재 5만2786쌍으로 대폭 줄어들었다.  </span></p>
		<p><span>헤더 린치(Heather Lynch) 교수는 “턱끈펭귄 개체 수의 현저한 감소는 남극해 생태계가 50년 전과는 완전히 달라졌음을 시사한다. 생태계 변화로 먹이사슬이 뒤엉키고 턱끈펭귄도 영향을 받았을 것이다. 여러가지 요인들이 있겠지만 모든 정황이 기후변화를 근본 원인으로 지목하는 상황이다”라고 설명했다.   </span></p>
		<p><span>스토니브룩 대학 연구진은 또 미국 노스이스턴 대학 연구진과 함께 추가로 남극 로우섬(Low Island)에서도 동일한 조사를 진행하고 있다. 로우 섬에서의 턱끈펭귄 개체 수 조사는 이번이 최초로, 이곳엔 10만 쌍의 턱끈펭귄이 서식하는 것으로 알려져 있다. </span></p>
		<p><span>현지원 그린피스 해양 캠페이너는 “지금 펭귄들에게 필요한 건 기후변화로부터 회복할 수 있는 공간 즉, 보호구역의 지정이다. 그러기 위해서는 올해 3월 열리는 유엔 BBNJ 회의에서 한국 정부를 포함한 각국 정부들이 한 마음으로 해양 보호구역 지정으로 이어질 수 있는 조약의 체결을 위해 목소리를 내야 한다”라고 말했다. </span></p>
		<p><span>한편, 그린피스는 지난 7일부터 한국, 미국, 영국, 일본, 아르헨티나 등 전 세계 15개 국가에서 ‘사라지는 펭귄들(Disappearing penguins)’ 퍼포먼스를 동시 진행했다. 각국 정부에 기후 위기로부터 생물 다양성을 지키기 위해 해양 보호구역의 지정이 필수적이라는 메시지를 전달하고자 기획했다. </span></p>
		<p><span> </span></p>
		<p><span>*BBNJ: Biodiversity Beyond National Jurisdiction의 약자로 ‘국가관할권 이원 지역에서의 생물다양성’에 관한 UN 국제 회의다. 공해의 해양유전자원, (해양보호구역 지정을 포함한) 구역기반관리수단, 해양환경영향평가, 능력배양 및 기술 이전 등 4개의 안건을 다룬다. </span></p>
		<p>&nbsp;</p>
	</div>
	
	<div>
		다른글
		<a href = "#">그린피스 "남극 턱끈펭귄 7만 쌍 사라졌다"</a>
	</div>
</div>
<jsp:include page="/hotel/hotelTail.jsp"/>
</body>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>