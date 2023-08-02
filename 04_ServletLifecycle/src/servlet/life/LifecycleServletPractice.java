package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServletPractice
 */
public class LifecycleServletPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// count 변수 지정 및 초기화
	private int count = 0;
	// path(경로 지정 및 초기화)
	private String path = "d:\\test\\count.txt";

	// 1. 생성자
    public LifecycleServletPractice() {

    }


    // 2. init 한 번 호출, 저장된 count 파일 불러오기
    // BufferedReader, FileReader 
	public void init(ServletConfig config) throws ServletException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String result = br.readLine();
			count = Integer.parseInt(result);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// 4. 종료 시 count 횟수 저장하기
	// PrintWriter, FileWriter
	public void destroy() {
		File file = new File(path);
		file.getParentFile().mkdirs();
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	// 3. count 올리는 메소드 작성
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글변환
		response.setCharacterEncoding("text/html;charset=utf-8");
		
		// printwriter로 값 출력
		PrintWriter out = response.getWriter();
		
		// count 출력
		out.println(++count);
		
		// out 닫기
		out.close();
		

	
	
	}

}
