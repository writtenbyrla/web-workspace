<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보</h1>
	<table border="1">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>회원아이디</th>
				<th>회원이름</th>
				<th>회원나이</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.userNo}</td>
				<td>${dto.userId}</td>
				<td>${dto.userName}</td>
				<td>${dto.userAge}</td>
			</tr>
		</tbody>
	</table>
	<a href="/index.jsp">메인페이지로 돌아가기</a>
</body>
</html>