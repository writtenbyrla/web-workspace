package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext context;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
	
	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();
//		context.setAttribute("list", list);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("list", list);
		
		String name = request.getParameter("name");
		int age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;
		String addr = request.getParameter("addr");
		
		if(name!=null) {
			MemberVO vo = new MemberVO(name, age, addr);
			list.add(vo);
		}
		
		// 내비게이션(이동할 경로)
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
		rdp.forward(request, response); // 이때 페이지로 이동
		
//		PrintWriter out = response.getWriter();
//		out.println("<a href='viewMember.jsp'>결과 확인하러 가기</a>");
//		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
