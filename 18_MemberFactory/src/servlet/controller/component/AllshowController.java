package servlet.controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class AllshowController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberVO> memberList = MemberDAO.getInstance().showAllMember();
		
		request.setAttribute("memberList", memberList);
		String path = "views/allShow.jsp";
		
		// request니까 forward 방식으로
		return new ModelAndView(path);
	}

}
