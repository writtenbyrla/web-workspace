package member.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI = request.getRequestURI();
		System.out.println("ReqeustURI :: " + requestURI);
		// ReqeustURI :: /find.do
		
		String[] requestURIList = requestURI.split("/");
	
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		// RequestURIList :: [, find.do]
		
		// RequestURIList에서 마지막 인덱스에 있는 값을 가져와서 command에 담음
		String command = requestURIList[requestURIList.length-1];
		System.out.println("Command :: " + command); 
		// find.do
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			// ModelAndView에 path가 포함되어 있음
			ModelAndView mv = controller.handle(request, response);
			
			if(mv!=null) {
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getPath());
				} else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
