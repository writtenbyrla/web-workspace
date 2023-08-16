package controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int itemId = Integer.parseInt(request.getParameter("item_id"));
		String path = "itemList.jsp";
		
		Item item = ItemDAO.getInstance().getItem(itemId);
		
		if(item!=null) {
			request.setAttribute("item", item);
			path = "itemView.jsp";
		}
		return new ModelAndView(path);
	}
	
	
	
}
