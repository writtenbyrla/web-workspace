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
		<c:when test="${param.num eq '1'}">
			안녕하세용
		</c:when>
		<c:when test="${param.num eq '2'}">
			안녕못해용
		</c:when>
		<c:otherwise>
			집에 가야겠어용
		</c:otherwise>
	</c:choose>

</body>
</html>