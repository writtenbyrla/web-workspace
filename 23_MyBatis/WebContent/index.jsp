<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.StudentVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
    
  <!-- 
  	첫 페이지 리스트 뿌려주기 
  	service 호출해서 list에 담아
  	request.setAttribute로 바인딩!
  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>

	<% List<StudentVO> list = (List) request.getAttribute("list"); %>
	
	<form action="/find.do" method="post">
		<input type="text" name="word">
		<input type="submit" value="검색" id="find">
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>주소</th>
				<th>학과</th>
				<th>계열</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	
	
	<script>
	
		
		$('#find').click(function(){
			
			var list = ${list};
			
			console.log(list);
			
			$('tbody').each(list, function(index, student) {
                var row = $("<tr>");
                row.append($("<td>").text(student.studentNo));
                row.append($("<td>").text(student.studentName));
                row.append($("<td>").text(student.studentAddress));
                row.append($("<td>").text(student.departmentName));
                row.append($("<td>").text(student.category));
                tableBody.append(row);
			});
		});
		
		
		
		
	
	</script>
	
</body>
</html>