package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class AllshowController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberVO> memberList = new MemberService().showAllMember();
		
		request.setAttribute("memberList", memberList);
		String path = "views/allShow.jsp";
		
		// request니까 forward 방식으로
		return new ModelAndView(path);
	}

}
