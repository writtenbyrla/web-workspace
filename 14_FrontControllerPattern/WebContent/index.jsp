<%@page import="servlet.model.vo.MemberDTO"%>
<%@page import="servlet.model.vo.MemberVO"%>
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
	<h1>회원 관리 기능</h1>
	
	<ul>
		<c:choose>
			<c:when test="${empty vo}">
				<%-- 로그인이 되어 있지 않은 경우: 회원가입~로그인 --%>
				<li><a href="views/register.html">회원가입</a></li>
				<%-- 회원가입: 아이디, 비밀번호, 이름, 주소 입력 받아서 
				-> RegisterServlet / post 방식
				-> session에 데이터 바인딩
				-> session에 값이 있는 경우 -> AllMemberServlet
							값이 없는 경우 -> index.jsp
				--%>
				<li><a href="views/login.html">로그인</a></li>
				<%--
				로그인 -> 아이디, 비밀번호 입력해서
				-> LoginServlet / post 방식
				-> 세션 데이터 바인딩 -> views/login_result.jsp(정보 출력)
		 		--%>
			</c:when>
			
			<c:otherwise>
				<%-- 로그인 되었을 때 --%>
				<li><a href="views/search.html">회원검색</a></li>
				<%--
				회원검색: 검색할 아이디를 입력받아서
				-> FindMemberServlet -> 검색 성공하면 views/find_ok.jsp(정보 출력)
									-> 실패하면 views/find_fail.jsp
				 --%>

				<li><a href="/front.do?command=allshow">전체회원보기</a></li>
				<%--
				전체 회원보기: views/allShow.jsp에 전체 리스트 출력
				 --%>

				<li><a href="front.do?command=logout">로그아웃</a></li>
				<%--
				로그아웃: 로그아웃하고 index.jsp로 오면 됨
		 		--%>

				<li><a href="views/update.jsp">회원 정보 수정</a></li>
				<%--
				회원정보수정: 로그인한 정보가 기재된 상태로 시작 
						ID값은 변경 불가능하게 처리
				-> UpdateServlet / post방식
				-> update_result.jsp : ~님의 정보를 수정했다 + a링크로 index.jsp로 이동
				 --%>
			</c:otherwise>
		</c:choose>
		
	</ul>
	

</body>
</html>