<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
	h1{
	text-align: center;
	padding: 30px;
	}
	
	a{
	display: flex;
	justify-content: flex-end;
	padding-right: 30px;
	}

	table{
	width: 100%;
	}
	
	tbody{

	}
	
	tfoot{
	text-align: right;
	font-weight: bold;
	}
</style>
</head>
<body>
	<h1>장바구니</h1>

	<a href="itemList.do">쇼핑 계속하기</a>


	<table border=1>
		<thead>
			<tr>
				<th>번호</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>수량</th>
				<th><button onclick="deleteStorage()">삭제</button></th>
			</tr>
		</thead>
		<tbody>

		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">총 결제금액 : <span id="resultTotal"></span></td>
			</tr>
		</tfoot>

	</table>


	<script>
	let amount=1;
	let totalPrice = 0;
	refreshPage(); // 들어오는 순간 호출
	
	$('.up').on('click', function() {
		// 수량 +1
		$(this).next().html(eval($(this).next().html())+1);
		amount = $(this).next().html();
		// 상품가격(상위 td(parent로) 갔다가 그 이전에 있는 가격에 접근)
		totalPrice += eval($(this).parent().prev().html());
		$('#resultTotal').html(totalPrice);
		
	});
	
	$('.down').on('click', function() {
		if(amount > 1){
			// 수량 -1
			$(this).prev().html(eval($(this).prev().html())-1);	
			amount = $(this).prev().html();
			// 상품가격(상위 td(parent로) 갔다가 그 이전에 있는 가격에 접근)
			totalPrice -= eval($(this).parent().prev().html());
			$('#resultTotal').html(totalPrice);
		}

		
	});
	
	// 장바구니 담은 값 표 안에 넣기
	function refreshPage(){
		let html='';
		let count = 0;
		
		for(let key in localStorage){
			if(key==="length") break;
			const data = localStorage.getItem(key).split(",");
			//console.log(data); ['딸기', ' 4500', ' img/berry.jpg']
					
			html += '<tr>' +
	                 	'<td>' + ++count + '</td>' +
	                	 '<td><img src=' + data[2] + ' width=150 height=150></td>' +
	                     '<td>' + data[0] + '</td>' +
	                     '<td>' + data[1] + '</td>'+
	                     '<td>' + 
	                     	'<img src=img/up.jpg width=10 height=10 style=cursor:pointer; class=up>' +
	                     	'<div>' +amount+ '</div>' +
	                     	'<img src=img/down.jpg width=10 height=10 style=cursor:pointer; class=down>' +
	                     '</td>'+
	                     '<td><input value=' + key + ' type=checkbox class=deleteItem>' + '</td>'+
	                 '</tr>'		
	        totalPrice += eval(data[1]);
		}
		
		$('tbody').append(html);
		$('#resultTotal').html(totalPrice);
	}
	
	// 삭제 기능
	function deleteStorage() {
		const check = document.querySelectorAll(".deleteItem");
		console.log(check);
		for(let i=0; i<check.length; i++){
			if(check[i].checked === true){
				localStorage.removeItem(check[i].value);
				location.reload();
			}
		}
	}
		
	

	</script>

	
	
</body>
</html>