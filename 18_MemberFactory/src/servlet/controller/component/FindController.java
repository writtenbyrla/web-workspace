package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "views/find_fail.jsp";
		
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		if(vo!=null) {
			request.setAttribute("vo", vo);
			path = "views/find_ok.jsp";
		}
		// 데이터바인딩 한 값(request.setAttribute)이 있으므로 forward로 보내야 함 
		// 객체 생성해서 path담고 바로 넘기기
		return new ModelAndView(path);
	}

}
