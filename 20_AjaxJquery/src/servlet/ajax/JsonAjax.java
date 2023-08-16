package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import servlet.model.Member;


@WebServlet("/JsonAjax")
public class JsonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Json 형식의 비동기 코드를 작성하려면 json 라이브러리가 필요
		
		// JSONObject 객체 하나 생성
		JSONObject json = new JSONObject();
		
		// 1. 
//		json.put("name", "Jason");
//		json.put("age", 20);
//		json.put("addr", "Texas");
		
		// 2. 객체 방식 그대로 넘김
		Member member = new Member("Jason", 20, "Texas");
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(member);
		
		json.put("result", result); // member:"servlet.model.Member@7b799e60" 주소값이 넘어옴, 라이브러리(잭슨) 필요함
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
