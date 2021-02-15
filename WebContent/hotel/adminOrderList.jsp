<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지(주문내역)</title>

<script>
// 	function deliver() {
// 		var odseq = document.getElementById("odseq");
		
// 		document.frm.action = "orderResultUpdate.do?odseq="+odseq;
// 		document.frm.submit();
// 	}
</script>
</head>
<body>
<form name = "frm" method = "post">
<jsp:include page = "/hotel/adminPageHeader.jsp"/>

<table border = "1">
	<tr>
		<td>번호			</td>
		<td>주문처리현황	</td>
		<td>주문사 성명		</td>
		<td>주문자 이메일	</td>
		<td>주문일		</td>
		<td>상품번호		</td>	
		<td>상품명		</td>
		<td>수량			</td>
		<td>가격			</td>
	</tr>
	
	<c:forEach var = "orderList" items = "${orderList}">
		<tr>
			<td>${orderList.odseq}					</td>
			<td><a href = "#">${orderList.result}</a></td>
			<td>${orderList.mname}					</td>
			<td>${orderList.email}					</td>
			<td>${orderList.indate}					</td>
			<td>${orderList.pseq}					</td>
			<td>${orderList.pname}					</td>
			<td>${orderList.quantity}				</td>
			<td>${orderList.price2}					</td>
			
			<c:choose>
				<c:when test = "${orderList.result eq 1}">
					<td><a href = "orderResultUpdate.do?odseq=${orderList.odseq}">[배송시작]</a></td>	
				</c:when>
				
				<c:when test = "${orderList.result eq 2}">
					<td><input id = "button" type = "button" value = "배송중" disabled></td>
				</c:when>
				
				<c:otherwise>
					<td>배송완료</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
</table>

</form>
</body>
</html>