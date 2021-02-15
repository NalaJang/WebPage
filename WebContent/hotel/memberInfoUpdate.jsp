<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		mid-width : 1600px;
		padding-top : 50px;
		padding-bottom : 300px;
	}
	
	.container input {
		margin : 10px;
	}
	
	.email {
		padding-top : 50px;
		padding-left : 380px;
	}
	
	.name {
		padding-left : 395px;
	}
	
	.pw {
		padding-left : 360px;
	}
	
	.pw2 {
		padding-left : 330px;
	}
	
	.phone {
		padding-left : 350px;
	}
	
	.zip_num {
		padding-left : 360px;
	}
	
	.add1 {
		padding-left : 390px;
	}
	
	.add2 {
		padding-left : 345px;
	}
	
	.row.btn {
		display : flex;
		margin-top : 50px;
		margin-left : 320px;
		margin-right : 300px;
	}
	
	.b1 input {
		width : 200px;
		padding: 10px;
	}
	
	.b2 input {
		color : white;
		width : 200px;
		padding: 10px;
		background-color : rgb(56, 116, 70);
	}
	
	.b2:hover input {
		color : rgb(56, 116, 70);
		background-color : white;
	}
</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- ***** -->
<script>

	function post() {	//다음 카카오 우편번호 서비스
		
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var addr = ''; // 주소 변수
	            var extraAddr = ''; // 참고항목 변수
	
	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }
	
	            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	            if(data.userSelectedType === 'R'){
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraAddr !== ''){
	                    extraAddr = ' (' + extraAddr + ')';
	                }
	                // 조합된 참고항목을 해당 필드에 넣는다.
	                document.getElementById("address2").value = extraAddr;
	            
	            } else {
	                document.getElementById("address2").value = '';
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('zip_num').value = data.zonecode;
	            document.getElementById("address1").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("address2").focus();
	        }
	    }).open();
	}
	
	function quit() {
	var result = confirm("정말로 탈퇴하시겠습니까?");
		if(result) {
			alert("시무룩");
			
			document.frm.action = "memberUseynUpdate.do";//회원탈퇴
			document.frm.submit();
			
			
		}
	}

	function update(){									//정보수정
		alert("수정되었습니다.")
	
		document.frm.action = "memberInfoUpdate.do";
		document.frm.submit();
	}

</script>
</head>
<body>

<jsp:include page = "/hotel/hotelHeader.jsp"/>

<form name = "frm" method = "post">
<input type = "hidden" name = "no" value = "${memberInfo.no}">

<div class = "container">

	<div class = "email">
	
		이메일<input type = "text" name = "email" value = "${memberInfo.email}">	
		
	</div>
	
	<div class = "name">
	
		이름<input type = "text" name = "name" value = "${memberInfo.name}" required>
		
	</div>
	
	<div class = "pw">
	
		비밀번호<input type = "password" name = "pw" value = "${memberInfo.pw}" required>
		
	</div>
	
	<div class = "pw2">
	
		비밀번호확인<input type = "password" name = "pw2">
		
	</div>
	
	<div class = "phone">
	
		휴대폰번호<input type = "text" name = "phone" value = "${memberInfo.phone}" required>
		
	</div>

	<div class = "zip_num">
	
		우편번호
		<input type = "text" id = "zip_num" name = "zip_num" value = "${memberInfo.zip_num}" required readonly>
		<input type = "button" value = "주소 검색" onclick = "post()">

	</div>
	
	<div class = "add1">
	
		주소<input type = "text" id = "address1" name = "address1" size = "40" value = "${memberInfo.address1}" required readonly>
		
	</div>
	
	<div class = "add2">
	
		나머지주소<input type = "text" id = "address2" name = "address2" value = "${memberInfo.address2}" required>
		
	</div>
	
	<!--------------------
			    버튼
	--------------------->
	<div class = "row btn">
		<div class = "b1">
			<input type = "button" value = "탈퇴" onclick = "quit()">
		</div>
		
		<div class = "b2">
			<input type = "button" value = "수정" onclick = "update()">
		</div>
	</div>

</div>
</form>
</body>

<jsp:include page = "/hotel/hotelTail.jsp"/>

</html>