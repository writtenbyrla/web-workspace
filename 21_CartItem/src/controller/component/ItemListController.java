package controller.component;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 아이템 목록 넘기기
		ArrayList<Item> itemList = ItemDAO.getInstance().getAllItem();
		request.setAttribute("itemList", itemList);
		
		// 쿠키 정보 받아서 넘기기
		Cookie[] cs = request.getCookies();
		ArrayList<String> cookieList = new ArrayList<>();
		
		if(cs!=null) {
			for(Cookie c : cs) {
				if(c.getName().startsWith("fruit-")) {
					cookieList.add(c.getValue());					
				}
			}	
		}
		request.setAttribute("cookieList", cookieList);
		
		
		return new ModelAndView("itemList.jsp");
	}

	
}
