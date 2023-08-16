<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
	text-align: center;
	}
	
	div img{
		width: 150px;
		height: 150px;
	}
	div{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	

</style>
</head>
<body>

	<h1>Fruit Total List</h1>

		<c:forEach items="${itemList}" var="list">
			<div>
				<a href="itemView.do?itemId=${list.itemId}"><img src="${list.pictureUrl}"></a><br>
				상품명 : ${list.itemName}<br>
				가 격 : ${list.price}<br>
				
			</div>
		</c:forEach>
		
	<hr>
	
	<h1>오늘 본 상품들</h1>
	
	
	
	
	
</body>
</html>