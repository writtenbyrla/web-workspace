package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성!
		/*
		 * 1. 양방향 한글 처리
		 * 2. 폼값 받아서
		 * 3. vo 객체 생성
		 * 4. 객체 바인딩 에 
		 * 5. 서블릿: ViewServlet (경로: view)한테 결과(이름, 나이, 주소) 출력
		 * */
		// a링크로 ViewServlet 결과 확인하러 가기
		
		// 1. 양방향 한글 처리
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		// 2. 폼값 받아서
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		
		// 3. vo 객체 생성
		MemberVO vo = new MemberVO(name, age, addr);
		
		// 4. 객체 바인딩 에
		context = get();
		context.setAttribute("vo", vo); // "vo"는 변수명 지정, vo는 위에서 담은 객체
		
		PrintWriter out = response.getWriter();
		
//		out.println("<a href=view?name="+name+"&age="+age+"&addr="+addr+">결과 확인하기</a>");
//		out.println("<a href='view'>결과 확인하기");
		out.println("<a href='result.jsp'>결과 확인하러 가기</a>");
		
		out.close();
				
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
