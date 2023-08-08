package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

@WebServlet("/AllMemberServlet")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemberDAO dao = new MemberDAO();
		try {
			ArrayList<MemberDTO> memberList = MemberDAO.getInstance().showAllMember();
			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("views/allShow.jsp").forward(request, response);
			
		} catch (SQLException e) {}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
