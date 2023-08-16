package controller;

import controller.component.ItemListController;
import controller.component.ItemViewController;

// ControllerFactory와 같은 역할(명칭만 다름)
public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("itemList.do")) {
			controller = new ItemListController();
		} else if(command.equals("itemView.do")){
			controller = new ItemViewController();
		}
		return controller;
	}
}
