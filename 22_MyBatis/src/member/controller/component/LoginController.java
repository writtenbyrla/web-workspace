package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
				
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPassword(password);
	
		MemberVO vo = new MemberService().login(m);
		
		HttpSession session = request.getSession();
		
		if(vo!=null) {
			session.setAttribute("vo", vo);

		}
		
		// request일 때 데이터바인딩 필수, forward 방식으로 보내야 함
		
		// request가 아닌 session이므로 sendRedirect 방식으로 보내도 됨
		return new ModelAndView("views/login_result.jsp", true);
	}
	
	
	

}
