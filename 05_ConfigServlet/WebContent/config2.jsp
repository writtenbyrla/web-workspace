<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%= request.getParameter("userName") %> 님은 
	<%= request.getParameter("count")%> 번째 입장하신 고객입니다.</p>
</body>
</html>