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
 * Servlet implementation class ViewServletPractice
 */
public class ViewServletPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		context = getServletContext();
		
		// 객체에 담긴 값 가져오기
		MemberVO vo = (MemberVO) context.getAttribute("vo");
	
		PrintWriter out = response.getWriter();
		out.println(vo.getName() + vo.getAge() + vo.getAddr());
		out.close();
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
