package controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<Item> itemList = ItemDAO.getInstance().getAllItem();
		
		request.setAttribute("itemList", itemList);
		
		return new ModelAndView("itemList.jsp");
	}

	
}
