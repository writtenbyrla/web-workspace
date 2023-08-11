package servlet.controller.component;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAO.getInstance().idExist(id);
		
		PrintWriter out = response.getWriter();
		
		if(vo!=null) {
			out.println("ID 사용 불가");
		} else {
			out.println("ID 사용 가능");
		}
		
		return new ModelAndView();
	}

}
