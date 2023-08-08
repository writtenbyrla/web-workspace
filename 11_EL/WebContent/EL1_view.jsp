<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Attribute에 바인딩된 값을 받아옴</h2>
	
	<h3>1~50까지의 합산 결과 값 1)</h3>
	<%= request.getAttribute("result") %>
	
	<hr>
	

	<%--
	EL
	- Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
	- 객체를 바인딩한 ${이름}이 사용된다. --%>
	

	
	<h3>1~50까지의 합산 결과 2) EL</h3>
	<p>request : ${requestScope.result}</p>
	<p>session : ${sessionScope.result}</p>
	<p>${result}</p>
</body>
</html>