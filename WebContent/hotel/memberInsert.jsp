<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<style>
	.container {
		min-width : 1600px;
		padding-top : 50px;
		padding-bottom : 300px;
		
		margin : 0 auto;
	}
	
	.container input {
		margin : 10px;
	}

	.logo {		
		font-size : 30px;
		padding : 30px;
		padding-left : 690px;
		border-bottom : 1px solid grey;
	}
	
	.logo a {
		color : black;
	}
	
	.email {
		padding-top : 50px;
		padding-left : 590px;
	}
	
	.name {
		padding-left : 605px;
	}
	
	.pw {
		padding-left : 570px;
	}
	
	.pw2 {
		padding-left : 540px;
	}
	
	.phone {
		padding-left : 560px;
	}
	
	.zip_num {
		padding-left : 570px;
	}
	
	.add1 {
		padding-left : 600px;
	}
	
	.add2 {
		padding-left : 570px;
	}
	
	.row.btn {
		margin-top : 50px;
		margin-left : 660px;
	}
	
	.btn button {
		color : white;
		width : 200px;
		padding: 10px;
		background-color : rgb(56, 116, 70);
	}
	
	.btn:hover button {
		color : rgb(56, 116, 70);
		background-color : white;
	}

</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function  pwCheck(input) {
	    if (input.value != document.getElementById('pw').value) {
	        input.setCustomValidity('비밀번호가 맞지 않습니다.');
	    } else {
	        // 에러메세지 리셋
	        input.setCustomValidity('');
	    }
	}
	
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
	
</script>

</head>
<body>
<!-- action = "memberInsert.do" -->
<form name = "frm" onsubmit = "return alert('가입을 환영합니다😊');" action = "memberInsert.do" method = "post">
<div class = "container">
	
	<div class = "row logo">
	
		<a href = "main.do"><img src = "http://localhost:8080/project/hotel/img/펭귄.jpg"></a>
		
	</div>
	
	<div class = "email">
	
		이메일<input type = "email" name = "email" pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}" placeholder = "id@domain.com" required autofocus>
			
	</div>

	<div class = "name">
	
		이름<input type = "text" name = "name" required>	
		
	</div>
	
	<div class = "pw">
		비밀번호<input id = "pw" type = "password" name = "pw" minlength = "8" maxlength = "13" required>
<!--   oninvalid="this.setCustomValidity('aaa')" oninput = "setCustomValidity('bbb')"  -->
	</div>
	
	<div class = "pw2">
	
		비밀번호확인<input id = "pw2" type = "password" name = "pw2" maxlength = "13" oninput = "pwCheck(this)" required/>
		
	</div>
	
	<div class = "phone">
		휴대폰번호<input type = "text" name = "phone" maxlength = "13" pattern = "(010)-\d{3,4}-\d{4}" required = "required">(' - '를 포함하여 작성하세요.)

<!-- 		휴대폰번호<input type="text" name = "phone" minlength = "12" maxlength = "13" pattern = "(010)\d{3,4}\d{4}" required oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" /> -->
	</div>

	<div class = "zip_num">
	
		우편번호
		<input id = "zip_num" type = "text" name = "zip_num" readonly required>
		<input type = "button" value = "주소 검색" onclick = "post()">
	</div>
	
	<div class = "add1">
	
		주소<input id = "address1" type = "text" name = "address1" size = "40" readonly required>
		
	</div>
	
	<div class = "add2">
	
		상세주소<input id = "address2" type = "text" name = "address2">
		
	</div>
	
	<div class = "row btn">
		<button type = "submit" onclick = "insert()">가입하기</button>
	</div>
	
</div>

</form>
</body>
<jsp:include page = "/hotel/hotelTail.jsp"/>

</html>