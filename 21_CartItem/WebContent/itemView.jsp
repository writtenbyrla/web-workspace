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
#section{
	display: flex;
	flex-direction: column;
	text-align: center;
}
h1{
	margin: 50px;
}
#menu{
	width: 500px;
	display: flex;
	justify-content: space-around;
	position: fixed;
	right: 0;
	margin-top:100px;
	margin-right: 50px;
	align-items: center;
	
}
#item img{
	width: 40%;
}
#item{
	display: flex;
	width: 100%;
	margin-top: 100px;
	padding: 20px;
}
#detail{
	align-self: center;

}
#detail p{
	display: flex;
	flex-direction: row;
	padding: 20px;
}


</style>
</head>
<body>
	<div id="section">
		<h1>${item.itemName}의 정보</h1>

		<!-- 조회수:db, 장바구니 담기, 장바구니 확인: localStorage, 상품목록보기 itemList.jsp -->
		<div id="menu">
			<span>조회수 : ${item.count}</span>
			<button id="cartInsert" data-id="${item.itemId}" value="${item.itemName}, ${item.price}, ${item.pictureUrl}">장바구니 담기</button>
			<a href="cartList.jsp">장바구니 확인</a>
			<a href="itemList.do">상품 목록 보기</a>
		</div>

		<div id="item">
			<img src="${item.pictureUrl}">
			
			<div id="detail">
			<p>종 류 : ${item.itemName}</p>
			<p>가 격 : ${item.price}</p>
			<p>설 명 : ${item.description}</p>
			</div>
		</div>
	</div>
		
	<script>
		$('#cartInsert').click(function(){
			console.log($(this).attr('data-id'));
			console.log($(this).val());
			localStorage.setItem('cart-' + $(this).attr('data-id'), $(this).val());
			alert('장바구니에 담았습니다!');
		});
	</script>

	
	
	
</body>
</html>