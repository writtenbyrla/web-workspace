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
 * Servlet implementation class RegisterServletPractice
 */
public class RegisterServletPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 한글처리(filter에서)
		
		// 폼값 받아오기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		
		// 객체 생성
		MemberVO vo = new MemberVO(name, age, addr);
		
		// 객체 ServletContext통해 담기
		context = getServletContext();
		context.setAttribute("vo", vo);
		
		PrintWriter out = response.getWriter();
		out.println("<a href=result.jsp>결과 확인</a>");
		
		out.close();
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
