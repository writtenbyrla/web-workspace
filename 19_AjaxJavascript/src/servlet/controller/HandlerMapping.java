package servlet.controller;

import servlet.controller.component.IdCheckController;

// ControllerFactory와 같은 역할(명칭만 다름)
public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("idCheck.do")) {
			controller = new IdCheckController();
		}
		return controller;
	}
}
