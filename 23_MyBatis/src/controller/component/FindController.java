package controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.StudentService;
import model.vo.StudentVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		
		//StudentVO student = new StudentVO();
//		
//		if() {
//			student.setStudentNo(word);			
//		} else if() {
//			student.setStudentName(word);
//		} else if() {
//			student.setStudentAddress(word);
//		} else if() {
//			student.setDepartmentNo(word);
//		} else if() {
//			
//		}
		
		List<StudentVO> list = new StudentService().showStudent(word);
		
		if(list!=null) {
			request.setAttribute("list", list);
		}
		
		
		return new ModelAndView("index.jsp");
	}

}
