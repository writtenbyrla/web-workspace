<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.vo.StudentVO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "model.service.StudentService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	List<StudentVO> list = new StudentService().showStudent(null);
	request.setAttribute("list", list);
%>
    
  <!-- 
  	첫 페이지 리스트 뿌려주기 
  	service 호출해서 list에 담아
  	request.setAttribute로 바인딩!
  -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">	
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
.container .row{
	margin-top:50px;
	margin-bottom: 30px;
}
</style>


</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				<input type="text" name="word" id="word" class="form-control">
			</div>
			<div class="col">
				<input type="button" value="검색" id="searchBtn" class="btn btn-danger">
			</div>
		</div>
		
		<table class="table">
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
				<c:forEach items="${list}" var="student">
					<tr>
						<td>${student.studentNo}</td>
						<td>${student.studentName}</td>
						<td>${student.studentAddress}</td>
						<td>${student.department.departmentName}</td>
						<td>${student.department.category}</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>

		$('#searchBtn').click(function(){
			
			const word = $('#word').val();
			
			$.ajax({
				type: 'get',
				url: 'find.do',
				data: "word=" + word,
				dataType: 'json',
				//data: $('#frm').serialize(),
			
				success: function(data){
					const result = eval(data.result);
					console.log(result);
					
					let resultHtml='';
					for(let item of result) {
						resultHtml += 
							"<tr>"		
							+ "<td>" + item.studentNo + "</td>"
							+ "<td>" + item.studentName + "</td>"
							+ "<td>" + item.studentAddress + "</td>"
							+ "<td>" + item.department.departmentName + "</td>"
							+ "<td>" + item.department.category + "</td>"
							+ "</tr>"	
					}
					
					$('tbody').html(resultHtml);
				}	
				
			});
		});
		
	</script>
	
</body>
</html>