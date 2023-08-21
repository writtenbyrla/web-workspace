package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "views/find_fail.jsp";
		
		String id = request.getParameter("id");
		String addr = request.getParameter("addr");
		
		String[] idList = request.getParameterValues("checkId");
		
		MemberVO vo = new MemberVO();
		if(id!="") vo.setId(id);
		if(addr!="") vo.setAddress(addr);
		
		List<MemberVO> list = new MemberService().findByIdMember(idList);
	
		
		if(list!=null) {
			request.setAttribute("memberList", list);
			path = "views/allShow.jsp";
		}
		// 데이터바인딩 한 값(request.setAttribute)이 있으므로 forward로 보내야 함 
		// 객체 생성해서 path담고 바로 넘기기
		return new ModelAndView(path);
	}

}
