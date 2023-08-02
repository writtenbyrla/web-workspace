package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet1
 */
public class LifecycleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int count=0;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifecycleServlet1() {
    	System.out.println("1. LifecycleServlet 생성자..");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// init은 딱 한번만 실행, ServletConfig와 연결됨
		// 유튜브 목록처럼 한번만 호출되어야 할 경우는 init 메소드에서 작성됨
		System.out.println("2. init... 호출..");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 서버에서 종료되는 순간 나타나는 메소드
		System.out.println("4. destroy... 호출");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비즈니스 로직이 작성되는 부분
		System.out.println("3. service... 호출..");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>LifeCycle CallBack Method...</h2>");
		out.println("<p>Count :: " + ++count + "</p>");
		out.close();
	}

}
