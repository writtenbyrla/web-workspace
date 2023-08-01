package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 한글처리 양방향!
		 * */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// input값은 getParameter로 받아옴
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		
		// 성별: radio
		String gender = request.getParameter("gender");
		
		// 좋아하는 메뉴: checkbox / 배열로 받아와야 함, getParameterValues
		String[] menuList = request.getParameterValues("menu");
		
		
	
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>정보를 출력합니다</h2>");
		out.println("<p> 아이디 : " + id + "</p>");
		out.println("<p> 패스워드 : " + pwd + "</p>");
		out.println("<p> 성별 : " + (gender.charAt(0) == 'M' ? "남자" : "여자") + "</p>");
	
		out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	
	}




}
