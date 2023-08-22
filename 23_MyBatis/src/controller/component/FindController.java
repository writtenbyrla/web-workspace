package controller.component;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.Controller;
import controller.ModelAndView;
import model.service.StudentService;
import model.vo.StudentVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		
		List<StudentVO> list = new StudentService().showStudent(word);
		
		// json 방식
		JSONObject json = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		
		json.put("result", result);
		
		PrintWriter out = response.getWriter();
		out.print(json);
	
		
		
		// ajax 방식
//		for(int i=0; i<list.size(); i++) {
//			out.print( 
//					"<tr>"		
//							+ "<td>" + list.get(i).getStudentNo() + "</td>"
//							+ "<td>" + list.get(i).getStudentName() + "</td>"
//							+ "<td>" + list.get(i).getStudentAddress() + "</td>"
//							+ "<td>" + list.get(i).getDepartment().getDepartmentName() + "</td>"
//							+ "<td>" + list.get(i).getDepartment().getCategory() + "</td>"
//							+ "</tr>"
//					);
//		}
		
		return null;
	}

}
