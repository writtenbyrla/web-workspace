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
	<h1>회원 정보 수정</h1>
	
	<form action="/UpdateServlet" method="post">
		<p>현재 아이디 : ${sessionScope.dto.getId()}</p>
		<p>현재 아이디 : <input type="text" name="id" placeholder="${sessionScope.dto.getId()}" value="${sessionScope.dto.getId()}" readonly></p>
		<p>변경할 패스워드 : <input type="text" name="newpwd"></p>
		<p>변경할 이름 : <input type="text" name="newname"></p>
		<p>변경할 주소 : <input type="text" name="newaddr"></p>
		<p><input type="submit" value="데이터 전송"></p>


	</form>


	
</body>
</html>