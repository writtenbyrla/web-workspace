<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- c:forEach 쓰기 위해 lib에 jstl, standard 추가 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
	text-align: center;
	background-color: lightblue;
	}
	
	#section{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	#itemList{
		display: flex;		
	}
	
	#itemList img{
		margin: 20px;

	}
	
	#item{
		display: flex;
		flex-direction: column;
		text-align: center;
		margin: 20px;
	}
	
	img{
		width: 200px;
		height: 200px;
		object-fit: cover;
		border-radius: 50%;
	}
	
	hr{
	margin: 50px;
	}

</style>
</head>
<body>
	<div id="section">
		<h1>Fruit Total List</h1>

		<div id="itemList">
			<c:forEach items="${itemList}" var="item">
				<div id="item">
					<a href="itemView.do?id=${item.itemId}"> <img src="${item.pictureUrl}"></a>
					<p>상품명 : ${item.itemName}</p>
					<p>가 격 : ${item.price}</p>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<hr>

	<div id="section">
		<c:if test="${not empty cookieList}">
			<h1>오늘 본 상품들</h1>
			<div id="itemList">
				<c:forEach items="${cookieList}" var="fruit">
					<img src="${fruit}">
				</c:forEach>
			</div>
		</c:if>
	</div>

</body>
</html>