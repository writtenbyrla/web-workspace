package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

@WebServlet("/SearchServlet")
public class searchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		MemberVO vo = null;
		vo.setName(name);
		
		try {
			
			vo = MemberDAO.getInstance().searchMember(vo);
			
			if(vo!=null) {
				
				request.setAttribute("vo", vo);
				request.getRequestDispatcher("find_ok.jsp").forward(request, response);
			} else {
				response.sendRedirect("find_fail.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
