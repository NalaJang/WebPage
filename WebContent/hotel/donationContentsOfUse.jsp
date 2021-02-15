<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.back {
		background-color : rgb(255, 253, 244);
	}
	
	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 300px;
	}
	
	.ment1 {
		padding-top : 20px;
		padding-bottom : 20px;
		margin-bottom : 20px;
		border-top : 1px solid grey;
		border-bottom : 1px solid grey;
	}
	
	.ment2 {
		color : white;
		font-size : 35px;
		padding-left : 170px;
		background-color : orange;
	}
	
	.ment3 {
		padding-top : 30px;
	}
	
	.left {
		padding-top : 30px;
	}
	
	.right {
		margin-left : 200px;
		padding-top : 30px;
	}
	
	.ment1, .ment3 {
		font-size : 25px;
	}
	
	.ment1, .content, .content2 {
		padding-left : 100px;
	}
	
	.content2 {
		padding-top : 30px;
	}
	
	.img img {
		width : 600px;
		padding-top : 20px;
		padding-left : 35px;
	}
	
	.campaign .icons {
		padding-top : 30px;
		padding-left : 200px;
		padding-bottom : 30px;
	}
	
	.campaign span {
		font-size : 35px;
	}
	
	.ment3 {
		padding-left : 155px;
	}
	
	.g1 {
		padding-top : 20px;
		padding-left : 100px;
	}
	
	.graph {
		height : 30px;
		background-color : grey;
		border-radius : 40px;
		width : 650px;
	}
	
	.graph span {	
		width : 85%;
		color : white;
		font-weight : bold;
		font-size : 23px;
		display : block;
		padding : 0 10px;
		height : 30px;
		line-height : 30px;
		text-align : right;
		background-color : orange;
		border-radius : 40px;	/*padding 과 % 를 같이 사용할때 쓴다.*/
		box-sizing : border-box;
		animation : stack 2s 1;	/*animation name, 2s동안 1번 실행*/
	}
	
	@keyframes stack {
		0% { width : 0; color : rgb(255, 255, 255, 0); font-size : 13px;} /*0 은 투명값*/
		10% {color : rgb(255, 255, 255, 1)}	/* 40% 때부터  폰트색 변화*/
		100% { width : 85%; font-weight : bold;}
	}
	
</style>
</head>
<body>
<jsp:include page = "/hotel/hotelHeader.jsp"/>

<div class = "back">
<div class = "container">
	
	<div class = "row">
		<div class = "col-4 left">
			<div class = "row ment1">
				<b>우리의 지구를 함께 지켜주세요</b>
			</div>
			
			<div class = "content">
				지구는 동시다발적인 환경문제로 심각한 위기에 처해있습니다.<br><br>
				하지만 우리에게는 아직 기회가 있습니다.<br>	
				저희는 기후변화, 해양 생태계 파괴와 산림 파괴, 유해 화학물질로부터 우리의 소중한 지구를 지키기 위해 쉼없이 달리고 있습니다.
				환경문제 해결을 위해서는 한시라도 빨리 행동해야 합니다.<br><br>
				여러분의 후원으로 저희는 환경 문제를 조사하고, 경각심을 불러 일으키는 보고서를 발표하고,
				창의적인 캠페인과 직접 행동을 펼칠 수 있습니다. 미래 세대가 깨끗한 세상에서 살 수 있도록, 지구를 위한 변화를 저희와 함께 만들어주세요!
			</div>
			
			<div class = "img">
				<img src = "http://localhost:8080/project/hotel/img/donation.jpg" alt = "">
			</div>
			
			<div class = "content2">
				<table border = "1">
					<tr>
						<td>
							캠페인의 정치적, 재정적 독립성을 유지하기 위해 정부와 기업의 후원을 일체 받지 않으며 개인 후원자님들의 후원으로만 활동하고 있습니다.<br>
							바로 여러분의 후원이 있기에 지구를 위한 긍정적인 변화를 만들 수 있습니다. 함께 변화를 만들어 주셔서 감사합니다!
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class = "col-6 right">
		
			<div class = "row ment2">
				후원금은 어떻게 사용되나요?
			</div>
			
			<div class = "row ment3">
				2020년 1월 ~ 12월 캠페인 진행 내역
			</div>
			
			<div class = "row g1">
				<div class = "graph">
					<span>85%</span>
				</div>
			</div>
			
			<div class = "campaign">
			
				<div class = "row icons">
					<div>
						<span class="material-icons">public</span>기후 에너지<span>49%</span>
					</div>
				</div>
				
				<div class = "row icons">
					<div>
						<span class="material-icons">waves</span>해양 보호<span>13%</span>
					</div>
				</div>
				
				<div class = "row icons">
					<div>
						<span class="material-icons">restaurant</span>건강한 식품 및 농업<span>4%</span>
					</div>
					
				</div>
				
				<div class = "row icons">
					<div>
						<span class="material-icons">local_gas_station</span>독성물질제거<span>17%</span>
					</div>
				</div>
				
				<div class = "row icons">
					<div>
						<span class="material-icons">nature_people</span>산림보호<span>8%</span>
					</div>
				</div>
				
				<div class = "row icons">
					<div>
						<span class="material-icons">share</span>기타통합캠페인<span>9%</span>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>
</div>
</div>

<jsp:include page = "/hotel/hotelTail.jsp"/>

</body>
</html>