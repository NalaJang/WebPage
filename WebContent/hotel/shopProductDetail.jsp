<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${productDetail.name}</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');

	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 100px;
		font-family: 'Nanum Myeongjo', serif;
	}
	
	.up img {
		width : 50px;
		height : 55px;
		float : right;
		
		position : fixed;
		bottom : 40px;
		right : 40px;
	}
	
	.road {
		padding-bottom : 50px;
	}
	
	.info {
		padding-bottom : 20px;
		border-bottom : 1px solid grey;
	}
	
	.mainImg_others .small {
		width : 100px;
		margin : 10px;		
	}
	
	.right div{
		margin : 25px;
	}
	
	.name {
		font-size : 30px;
	}
	
	.content {
		padding-bottom : 20px;
		border-bottom : 1px solid grey;
	}
	
	.price {
		font-size : 20px;
	}
	
	.quan input {
		text-align : center;
	}
	
	.quan button {
		border:none;
		background:none;
		font-size : 20px;	
	}
	
	.otherwise {
		color : red;
	}
	
	.btn_group button{
		color : white;
		width : 200px;
		padding: 10px;
		margin : 10px;
		font-weight : bold;
		background-color : rgb(56, 116, 70);
	}
	.b1 span, .b2 span {
		font-size : 18px;
	}
	
	.detail {
		padding-top : 100px;		
	}
	
	.detail div {
		margin : 10px;
	}
	
	.detail.name {	
		font-size : 30px;
		padding-left : 600px;
	}
	
	.detail1, .detail2 {
		font-size : 18px;
		padding-left : 500px;
		text-align : center;
	}
	
	.img1, .img2 {
		padding-left : 500px;
	}
	
	span {
		font-weight : bold;
	}
	
	.info2 {
		margin-top : 100px;
		background-color : rgb(255, 253, 244);
	}
</style>

<script>

	//수량 변경 및 총 상품 가격 변경
	var sell_price;
	var quantity;
	
	function init () {
		sell_price = document.frm.sell_price.value;
		quantity = document.frm.quantity.value;
		document.frm.sum.value = sell_price;
		change();
	}
	
	function plus() {	//수량이 증가될 때
		var hm = document.frm.quantity;	//물품 수량
		var sum = document.frm.sum;		//총 상품 금액
		hm.value ++ ;
	
		sum.value = parseInt(hm.value) * sell_price;	//수량  * 판매 가격
	}
	
	function minus() {	//수량이 감소될 때
		var hm = document.frm.quantity;
		var sum = document.frm.sum;
			if (hm.value > 1) {
				hm.value -- ;
				sum.value = parseInt(hm.value) * sell_price;
			}
	}
	
	function change () {	//수량이 0 이하 로 떨어지지 않게
		hm = document.frm.quantity;
		sum = document.frm.sum;
	
			if (hm.value < 0) {
				hm.value = 0;	// 0으로 맞춰줌
			}
		sum.value = parseInt(hm.value) * sell_price;
	} 
	
	//바로 구매
	function order() {
		
		var pseq = ${productDetail.pseq};
		var qua = document.getElementById("quantity").value;
			
		if(confirm(qua + '개' + '\n\n구매하시겠습니까?')){
			
			document.frm.action = "shopOrderDirect.do?pseq=" + pseq + "&quantity=" + qua;
			document.frm.submit();
			
			alert("결제가 완료되었습니다.");
		} else {
			return false;
		}
		
	}
	
	//장바구니 담기
	function cartInsert() {
		
		alert("장바구니에 보관되었습니다.");
		
		var pseq = ${productDetail.pseq};
		var qua = document.getElementById("quantity").value;
		
		document.frm.action = "shopCartInsert.do?pseq=" + pseq + "&quantity=" + qua;
		document.frm.submit();
	}

</script>
</head>
<body onload="init();">
<jsp:include page = "/hotel/hotelHeader.jsp"/>
<form name = "frm" method = "post">
	
<div class = "container">

	<!------- 위로 가기 버튼 ------->
	<div class = "up" style = "cursor : pointer;" onclick = "window.scrollTo(0,0)">
		<img src = "http://localhost:8080/webapp/shoppingMall2/img/topIcon.jpg">
	</div>

	<!--------------------
	      첫번째 ROW 메뉴 카테고리
	--------------------->
	<div class = "row road">
		<c:choose>
			<c:when test = "${productDetail.kind eq 1}">주방</c:when>
			<c:when test = "${productDetail.kind eq 2}">욕실</c:when>
			<c:when test = "${productDetail.kind eq 3}">여행</c:when>
			<c:when test = "${productDetail.kind eq 4}">음료</c:when>
		</c:choose>
		
		 > <b>${productDetail.name}</b>
		
	</div>
	
	<!--------------------
	      두번째 ROW 상품 이미지
	--------------------->
	<div class = "row info">
	
		<div class = "col-7">
		
			<div class = "row mainImg">
				<img class = "big" id = "big" src = "http://localhost:8080/project/hotel/img/${productDetail.image1}">		
			</div>
			
			<div class = "row mainImg_others">
				<img class = "small" src = "http://localhost:8080/project/hotel/img/${productDetail.image1}" alt = "">
				<img class = "small" src = "http://localhost:8080/project/hotel/img/${productDetail.image2}" alt = "">
				<img class = "small" src = "http://localhost:8080/project/hotel/img/${productDetail.image3}" alt = "">
				<img class = "small" src = "http://localhost:8080/project/hotel/img/${productDetail.image4}" alt = "">
			</div>
			
			<script>
				//사진 클릭 시 큰 이미지로 변경
				var bigPic = document.frm.querySelector("#big");
				var smallPics = document.frm.querySelectorAll(".small");	//작은 사진 여러개
				
				for(var i = 0; i < smallPics.length; i++) {
					smallPics[i].addEventListener("click", changePic);		//smallPics[i].onclick = changePic; 하나의 이벤트만 사용 가능
				}
				
				function changePic(){										//사진 바꾸는 함수
					var smallPicAttribute = this.getAttribute("src");
					bigPic.setAttribute("src", smallPicAttribute);
				}
			</script>

		</div>
		
		<!--------------------
		           세번째 ROW 상품 정보
		--------------------->
		<div class = "col-5 right">
		
			<!-- 상품명 -->
			<div class = "row name">					
				<b>${productDetail.name}</b>				
			</div>
			
			<!-- 상품가격 -->
			<div class = "row price">			
				&#8361;<fmt:formatNumber value = "${productDetail.price2}" pattern = "#,###"/>
			</div>
			
			<!-- 상품내용 -->
			<div class = "row content">
				${productDetail.content}
			</div>			
			
			<div class = "row quan">
				
				<div class = "col-3">
					수량 
				</div>
				
				<!-- 수량선택 -->
				<div class = "col-6">
					<button type = "button" onclick = "minus()">-</button>
					
					<input type=hidden name="sell_price" value="${productDetail.price2}">
					<input type="text" id = "quantity" name="quantity" value="1" size="3" max = "${productDetail.stock}" onchange="change();" readonly>
					
					<button type = "button" onclick = "plus()">+</button>
				</div>					
				
			</div>
			
			<div class = "row total_price">
				<div class = "col-3">
					총 상품 금액
				</div>
				
				<div class = "col-6">
					<input type="text" name="sum" size="11" style = "text-align : center;" readonly>원
				</div>
			</div>
				
			<div class = "row btn_group">
				<div class = "b1">
					<c:choose>
						<c:when test = "${hotelMember != null}">
							<button type = "button" onclick = "order()"><span class="material-icons">바로 구매 shopping_bag</span></button>
						</c:when>
						
						<c:otherwise>
							<div class = "otherwise">*상품 담기는 로그인 후 이용해 주세요.</div>
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class = "b2">
					<c:choose>
						<c:when test = "${hotelMember != null}">
							<button type = "button" onclick = "cartInsert()"><span class="material-icons">장바구니에 담기 shopping_cart</span></button>
						</c:when>
					</c:choose>
				</div>
				<%-- <input type = "hidden" name = "pseq" value = "${cartVo.pseq}"> --%>
				<%-- <input type = "hidden" name = "price" value = "${cartVo.price2}"> --%>
				
			</div>
				
		</div>
	</div>
	
		<!--------------------
		            상품 상세정보
		--------------------->
	<div class = "row detail name">
		<b>${productDetail.name}</b>
	</div>
	
	<div class = "row detail img1">
		<img src = "http://localhost:8080/project/hotel/img/${productDetail.image2}" alt = "">
	</div>
	
	<div class = "row detail detail1">
		<ul>
			<c:forTokens var = "detail" items = "${productDetail.detail}" delims = "^">
				<p>${detail}</p>
			</c:forTokens>
		</ul>
	</div>
	
	<div class = "row detail img2">
		<img src = "http://localhost:8080/project/hotel/img/${productDetail.image3}" alt = "">
	</div>
	
	<div class = "row detail detail2">
		<ul>
			<c:forTokens var = "detail" items = "${productDetail.detail2}" delims = "^">
				<p>${detail}</p>
			</c:forTokens>
		</ul>
	</div>
	
	<!--------------------
	         배송, 교환 안내
	--------------------->
	<div class = "info2">
	
		<div class = "info_deliver">
			<p><span>▶ 배송안내</span></p>
	
			   - 결제 완료일로부터 주말 및 공휴일 제외 2 ~ 5일 안에 배송됩니다.<br>
			<p>- 도서산간 및 제주 지역의 경우 추가 운임이 발생합니다.</p>
		</div>
		
		<div class = "info_return">
			<p><span>▶ 교환 및 반품 안내</span></p>
			
			   - 전자상거래법에 의거하여 교환 및 반품 요청은 수령일로부터 <b>10일</b> 이내 입니다.<br>
			   - 고객의 단숨 변심이나 실수로 인한 교환 및 반품의 경우 왕복 배송비는 고객이 부담하셔야 합니다.<br>
			<p>- 상품을 사용하였을 경우에는 교환 및 반품이 불가합니다. (*상품 하자의 경우 예외)</p>
			
			<p><span>▶ 제품불량에 따른 교환 및 반품 정책</span></p>
			
			<p>- 제품 수령일을 기준으로 10일이내 가능하며 뚜렷한 파손 및 제품 기능에 중대한 영향이 있는 경우에 한하여 가능합니다.</p>
			
			<p><span>▶ 단순 변심에 의한 교환 및 환불 정책</span></p>
			
			<p>- 제품 공급을 위한 운송비 전액(왕복 및 재발송)을 제한 금액이 환불됩니다.</p>
			
			<p><span>▶ 교환 및 반품이 불가능한 경우</span></p>
			
			- 포장을 개봉하였거나 훼손되어 상품 가치가 상실된 경우<br>
			-고객님의 사용 또는 일부 소비에 의해 상품의 가치가 현저히 감소한 경우<br>
			- 교환 및 반품 접수 기간(10일)의 경과 혹은 시간의 경과에 의해 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우
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