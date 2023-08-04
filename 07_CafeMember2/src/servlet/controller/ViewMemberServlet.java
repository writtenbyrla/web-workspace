package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

public class ViewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ViewMemberServlet() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> memberList = null;
		try {
			memberList = dao.showAllMember();
		} catch (SQLException e1) {}
		
		// 2. 바인딩
		request.setAttribute("list", memberList);
	
		// 3. 내비게이션(이동할 경로) -> 
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
		rdp.forward(request, response); // 이때 페이지로 이동
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
