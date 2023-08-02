package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet_SelfReview
 */
public class HttpFormServlet_SelfReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글처리 양방향
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 2. request 통해 값 받아오기
		// 2-1) id, password, gender(input)
		String id = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		
		// 2-2) menu(checklist)
		String[] menuList = request.getParameterValues("menu");
		
		// 3. respond
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<p>id : " + id + "</p>");
		out.println("<p>password : " + password  + "</p>");
		out.println("<p>gender : " + gender + "</p>");
		
		out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}

}
