package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * 회원가입하면 정보를 바탕으로 MemberVO를 생성 ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩
 * 출력 결과는 viewMember.jsp 페이지에서 
 */
public class EntranceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext context;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
	
	public void init(ServletConfig config) throws ServletException {
		context = getServletContext();
		context.setAttribute("list", list);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("name"));
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(name, age, addr);
		list.add(vo);
		
		PrintWriter out = response.getWriter();
		out.println("<a href='viewMember.jsp'>결과 확인하러 가기</a>");
		
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
