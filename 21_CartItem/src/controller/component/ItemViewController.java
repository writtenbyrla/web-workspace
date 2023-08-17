package controller.component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int itemId = Integer.parseInt(request.getParameter("id"));
		
		// 조회수 올리기
		ItemDAO.getInstance().updateRecordCount(itemId);
		
		Item item = ItemDAO.getInstance().getItem(itemId);
		
		// 오늘 본 상품정보를 저장하는 쿠키 로직
		// 1) 쿠키 생성 Cookie c1 = new Cookie("key", "value");
		Cookie cookie = new Cookie("fruit-" + itemId, item.getPictureUrl());
		
		// 2) 쿠키 유효시간 지정
		cookie.setMaxAge(60*60*24);
		
		// 3) 쿠키 전송
		System.out.println(cookie.getName());
		response.addCookie(cookie);
		
		String path = "itemList.jsp";
		if(item!=null) {
			request.setAttribute("item", item);
			path = "itemView.jsp";
		}
		

		return new ModelAndView(path);
	}
	
	
	
}
