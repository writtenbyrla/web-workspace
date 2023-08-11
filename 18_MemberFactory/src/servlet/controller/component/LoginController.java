package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
				
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		
		HttpSession session = request.getSession();
		
		if(vo!=null) {
			session.setAttribute("vo", vo);

		}
		
		// request일 때 데이터바인딩 필수, forward 방식으로 보내야 함
		
		// request가 아닌 session이므로 sendRedirect 방식으로 보내도 됨
		return new ModelAndView("views/login_result.jsp", true);
	}
	
	
	

}
