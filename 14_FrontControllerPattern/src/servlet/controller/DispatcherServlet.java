package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;


@WebServlet(urlPatterns = "/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		try {
			if(command.equals("register")) {
				path = register(request, response);
			} else if(command.equals("login")) {
				path = login(request, response);
			} else if(command.equals("search")) {
				path = search(request, response);
			} else if(command.equals("update")) {
				path = update(request, response);
			} else if(command.equals("allshow")) {
				path = allshow(request, response);
			} else if(command.equals("logout")) {
				path = logout(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		request.getRequestDispatcher(path).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		MemberDAO.getInstance().registerMember(vo);
		
		return "index.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO vo = MemberDAO.getInstance().login(id, password);

		HttpSession session = request.getSession();
		
		if(vo!=null) {
			session.setAttribute("vo", vo);
		} 
		return "views/login_result.jsp";
	}
	
	protected String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String id = request.getParameter("id");

		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);

		if(vo!=null) {
			request.setAttribute("vo", vo);
			return "views/find_ok.jsp";
		}
		
		return "views/find_fail.jsp";
	
	
	}
	
	protected String allshow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		ArrayList<MemberVO> memberList = MemberDAO.getInstance().showAllMember();
		
		request.setAttribute("memberList", memberList);
		
		
		return "views/allShow.jsp";
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		MemberDAO.getInstance().updateMember(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("vo", vo);
		
		return "views/update_result.jsp";
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "views/Logout.jsp";
		}
		return "index.jsp";
	
	}
	

}
