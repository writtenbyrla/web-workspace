<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${!empty vo}">
		<h3>${vo.name}님 회원 정보 수정 완료!</h3>
		<a href="/index.jsp">첫 페이지로 이동</a>
	</c:when>
	<c:otherwise>
		<h3>회원 정보 수정 실패!</h3>
		<a href="/index.jsp">첫 페이지로 이동</a>
	</c:otherwise>
</c:choose>
</body>
</html>