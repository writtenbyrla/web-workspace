package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String addr = request.getParameter("addr");
		
		/*
		 * 1. Attribute에 바인딩된 데이터를 받아와서 
		 * 2. 웹브라우저로 출력하는 로직을 작성
		 * */
		context = getServletContext();
		MemberVO vo = (MemberVO)context.getAttribute("vo"); // 형 변환(object -> MemberVO)
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>회원정보를 출력합니다.</h2>");
		out.println("<p>name: " + vo.getName() + "</p>");
		out.println("<p>age: " + vo.getAge() + "</p>");
		out.println("<p>addr: " + vo.getAddr() + "</p>");
		
		out.close();
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
	