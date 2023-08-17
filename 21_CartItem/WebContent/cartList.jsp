<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
	text-align: center;
	padding: 30px;
	}
	a{
	display: flex;
	position: fixed;
	right: 0;
	padding-right: 30px;
	}
	#cart{
	border: 1px solid gray;
	display: flex;
	margin-top: 70px;
	width: 100%;
	}
	table{
	width: 80%;
	display: flex;
	}

	tfoot{
	text-align: right;
	}
</style>
</head>
<body>
	<h1>장바구니</h1>
	
	<a href="itemList.do">쇼핑 계속하기</a>
	
	<div id="cart">
		<table border=1>
		<thead>
			<tr>
				<td>번호</td>
				<td>상품이미지</td>
				<td>상품명</td>
				<td>상품가격</td>
				<td>수량</td>
				<td><button>삭제</button></td>
			</tr>
		</thead>
		<tbody>

		</tbody>
		<tfoot>
			<tr>
          	<td colspan="6">총 결제금액: </td>

        	</tr>
		</tfoot>
			
		</table>
	
	</div>
	
	<!--
	<script>
		function view(){
			
			var itemId = ;
		    var cartValue = localStorage.getItem('cart-' + itemId);
				
				
				
			document.querySelector("tbody").innerHTML =
				localStorage.getItem("cart-"+); 
			
		}
	</script>
	  -->
	
	
</body>
</html>