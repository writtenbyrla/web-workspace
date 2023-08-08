package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		
		String id = request.getParameter("id");
		System.out.println(id);
		String password = request.getParameter("newpwd");
		System.out.println(password);
		String name = request.getParameter("newname");
		System.out.println(name);
		String address = request.getParameter("newaddr");
		System.out.println(address);
		
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setAddress(address);
		
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);
			
			MemberDAO.getInstance().updateMember(dto);
			response.sendRedirect("views/update_result.jsp");

		} catch (SQLException e) {
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
