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
	.back {	
 		background-color : rgb(255, 253, 244);
	}
	
	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 300px;
	}	

	.ment1 {
		font-size : 35px;
		padding-left : 170px;
	}
	
	.cs {
		width : 450px;
		padding : 50px;		
		margin-top : 350px;
		background-color : rgb(235, 233, 233);
	}
	
	.ment2 {
		font-size : 18px;
	}
	
	.catagory {
		font-size : 20px;
		padding-top : 50px;
		text-align : center;
		padding-left : 130px;
	}
	
	.catagory ul {
		list-style-type: none;
	}
	
	.catagory ul a {
		color : black;
		text-decoration: none;
	}
	
	.catagory a:hover {
		background-color : #ddd;
	}
	
	.roomInfo p {
		margin-top: revert;
	}
	
	.kind {
		font-size : 30px;
		padding-bottom : 30px;		
	}
	
	.roomImage {
		padding-left : 100px;
		padding-bottom : 30px;		
	}
	
	.detail1, .detail2 {
		padding-left : 80px;	
	}
	
	.detail1 {
		font-size : 23px;
		padding-bottom : 30px;	
	}
	
	.detail2 {
		font-size : 15px;
	}
	
	.detail2 b {
		font-size : 18px;
	}
	
	.detail_left {		
		margin-right : 70px;
	}
	
	.detail_right {
		margin : 10px;
	}
	
	.membernum {
		padding-left : 10px;
		padding-bottom : 10px;
	}
	
	.otherwise {
		color : red;
		padding-top : 30px;
		padding-left : 30px;
	}
	
	.btn_group button {
		padding : 20px;
		color : white;
		font-weight : bold;
		background-color : rgb(17, 100, 140);
	}
		
	.b1, .b2 {
		margin-top : 60px;
		margin-left : 80px;		
	}
	
	.b1 span, .b2 span {
		font-size : 17px;
	}
	
	.ment1, .kind, .roomImage {
		padding-top : 30px;
	}
	
	.kind, .detail2 b {
		border-bottom : 1px solid gray;
	}
</style>

<script>
	
	//바로 예약
	function reservation() {
		
		var rseq = ${roomDetail.rseq};
		var num = document.getElementById("membernum").value;
		var checkin = document.getElementById("checkin").value;
		var checkout = document.getElementById("checkout").value;
		
		if(document.getElementById("checkin").value == 0 || document.getElementById("checkout").value == 0) {
			alert("날짜를 선택해주세요");		//날짜를 선택하지 않은 경우
			
		} else {
			if(confirm('바로 예약하시겠습니까?')) {
				
				document.frm.action = "reservationDirect.do?rseq=" + rseq + "&membernum=" + num + "&checkin=" + checkin + "&checkout=" + checkout;
				document.frm.submit();
				
				alert("결제가 완료되었습니다.");
			} else {
				return false;
			}
		}
	}
	
	//방바구니 담기
	function roomCartInsert(){
		
		if(document.getElementById("checkin").value == 0 || document.getElementById("checkout").value == 0) {
			alert("날짜를 선택해주세요");		//날짜를 선택하지 않은 경우
			
		} else {
			
			alert("방바구니에 보관되었습니다.");
	
			var rseq = ${roomDetail.rseq};
			var num = document.getElementById("membernum").value;
			
			document.frm.action = "roomCartInsert.do?rseq=" +rseq+ "&membernum=" +num;
			document.frm.submit();
		}
	}
</script>

</head>
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<body>
<form name = "frm" method = "post">
<div class = "back">

<div class = "container">

	<div class = "row">
		
		<!-- 객실 목록 -->
		<div class = "col-4 menu">
			
			<!--------------------
				      왼쪽 첫번째 ROW
			--------------------->
			<div class = "row ment1">			
				객실
			</div>

			<!--------------------
				    왼쪽 두번째 ROW
			--------------------->
			<div class = "row catagory">

				<ul>
					<li>
						<p><a href = "roomDetail.do?kind=1">스탠다드</a></p>
						<p><a href = "roomDetail.do?kind=2">디럭스   </a></p>
						   <a href = "roomDetail.do?kind=3">그랜드   </a>
					</li>
				</ul>
				
			</div>
			
			<!--------------------
				  왼쪽 세번째 ROW
			--------------------->
			<div class = "row cs">
				<div class = "col-6 ment2">
					<b>객실예약문의</b>
				</div>
				
				<div class = "col-6">
					<div class = "row">
						<b>TEL</b> 02-6060-4321
					</div>
					
					<div class = "row">
						<b>FAX</b> +82-2-123-4567
					</div>
				</div>	
			</div>
			
		</div>
		
		<!-- 객실 정보 -->
		<div class = "col-8 roomInfo">
				
				<!--------------------
					   오른쪽 첫번째 ROW
				--------------------->
				<div class = "row kind">
					<c:choose>
						<c:when test = "${roomDetail.kind eq 1}">스탠다드</c:when>
						<c:when test = "${roomDetail.kind eq 2}">디럭스   </c:when>
						<c:when test = "${roomDetail.kind eq 3}">그랜드   </c:when>
					</c:choose>
				</div>
				
				<!--------------------
					   오른쪽 두번째 ROW
				--------------------->
				<div class = "row roomImage">
					<img src = "http://localhost:8080/project/hotel/img/${roomDetail.image1}">
				</div>
				
				<!--------------------
					   오른쪽 세번째 ROW
				--------------------->
				<div class = "row detail1">
					${roomDetail.detail}
				</div>
				
				<!--------------------
					   오른쪽 네번째 ROW
				--------------------->
				<div class = "row detail2">
				
					<div class = "col-4 detail_left">
						<div class = "row">
							모던한 아름다움과 고급 침구 및 침대 그리고 고급 어메니티로 한 단계 업그레이드 된 휴식을 경험하세요.<br>				
							<p>모든 객실과 레스토랑에서 유무선 인터넷 연결이 가능합니다.</p>
						</div>
						
						<div class = "row">
							<p>${roomDetail.content}</p>
						</div>
										
						<div class = "row">
							<p><b>객실이용</b></p>
						</div>
						
						<div class = "row">
							40” LED TV (36채널)<br>
							책상<br>
							냉장고<br>
							무료커피/티백<br>
							무료 생수 2병 (1박 기준)<br>
							무료 유무선 인터넷<br>
							유니버셜 어댑터(220V 전용)<br>
							개인금고<br>
							아베다 욕실용품<br>
							2개의 목욕가운<br>
							<p></p>
						</div>
						
						<div class = "row">
							<p><b>부대시설</b></p>
						</div>
						
						<div class = "row">
							피트니스 센터 무료 이용(안전상의 이유로 16세 이상 입장 가능합니다)<br>
							비즈니스 코너 인터넷 무료 이용<br>
							투숙 기간 내 무료 주차 가능
						</div>
					</div>
					
					<div class = "col-6 detail_right">
						<div class = "row membernum">
							인원수&nbsp;&nbsp;
							<select id = "membernum" name = "membernum" size = "1" style = "width : 50px;">
								<option value = "1">1
								<option value = "2">2
								<option value = "3">3
								<option value = "4">4
							</select>
						</div>
						
						<div>
							체크인       	<input id = "checkin" type = "date" name = "checkin">
							체크아웃&nbsp;<input id = "checkout" type = "date" name = "checkout">

						</div>
						
						<div class = "row btn_group">
							
							<c:choose>
								<c:when test = "${hotelMember != null}">
									
									<div class = "b1">
										<button type = "button" onclick = "reservation()"><span class="material-icons">예약하기 book_online</span></button>	
										<input type = "hidden" name = "kind" value = "${roomDetail.kind}">						
									</div>
									
									<div class = "b2">
										<button type = "button" onclick = "roomCartInsert()"><span class="material-icons">방바구니에 담기 shopping_cart</span></button>
									</div>
								</c:when>
								
								<c:otherwise>
									<div class = "otherwise">*예약은 로그인 후 이용 해 주세요.</div>
								</c:otherwise>
							</c:choose>
						</div>

		<%-- 				<input type = "hidden" name = "rseq" value = "${roomDetail.rseq}"> --%>
		<%-- 				<input type = "hidden" name = "price" value = "${roomDetail.price}"> --%>
					</div>					
					
				</div>			
		</div>		
	</div>
	
</div>
</div>
</form>
</body>
<jsp:include page="/hotel/hotelTail.jsp"/>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>