<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] arr = {"닭발", "족발", "가오리찜", "피자", "치킨", "간장게장"};
		request.setAttribute("arr", arr);
	%>
	
	<jsp:forward page="cForEach6_view.jsp" />
</body>
</html>