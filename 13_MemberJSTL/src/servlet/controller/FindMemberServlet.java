package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;


@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼 데이터 받아오기
		String id = request.getParameter("id");
		
		// 2. DAO 리턴 받아서
//		MemberDAO dao = new MemberDAO();

		try {
			MemberDTO dto = MemberDAO.getInstance().findByIdMember(id);
			
			if(dto!=null) {
				// 3. 멤버 정보 바인딩
				request.setAttribute("dto", dto);
				
				// 4. 네비게이션 
				request.getRequestDispatcher("views/find_ok.jsp").forward(request, response);
			} else { // null인 경우
				response.sendRedirect("views/find_fail.jsp");
			}
		} catch (SQLException e) {}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
