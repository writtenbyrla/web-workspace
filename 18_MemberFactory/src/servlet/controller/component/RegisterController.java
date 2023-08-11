package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		MemberDAO.getInstance().registerMember(vo);
		// DAO로 회원가입 후 로그인은 따로 처리할 경우 데이터바인딩 하지 않고 바로 index.jsp로 넘어감
		
		// 데이터 바인딩 - request, session, context(영역의 차이)
		// 셋 다 setAttribute로 데이터 바인딩
		
		// request <- 요청과 동시에 응답할 때 씀(가장 범위가 좁음)
		// request.setAttribute("vo", vo); 이거는 회원정보 보여주는 정도
		
		// session <- 보통 로그인/로그아웃 할 때
		// 회원가입 후 로그인으로 바로 넘어갈 경우에는 session.setAttribute로 데이터 바인딩 해줌
		
		// context 
		// 서버가 켜지는 순간부터 서버가 끝날 때까지 데이터를 쥐고 있음(servlet보다 먼저 켜짐)
		// 범위가 가장 넓고 과부화될 위험이 있음
		
		if(vo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			
		}
		
		return new ModelAndView("views/register_result.jsp");
	}
	
}
