package servlet.controller;

import servlet.controller.component.FindController;

public class ControllerFactory {
	
	// 싱글톤 패턴
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {}
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	// createController: 컨트롤러 생성하는 기능
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("find")) {
			controller = new FindController();
		}
		return controller;
	}
}
