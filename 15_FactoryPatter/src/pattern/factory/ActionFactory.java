package pattern.factory;

import pattern.action.Action;
import pattern.action.AddAction;
import pattern.action.DeleteAction;

/*
 * Action들을 만들어내는 공장
 * Dispatcher에서 보내주는 command값에 따라서 생성하는 Action이 달라진다.
 * 여러개의 Action들을 만들어 내지만 Factory는 단 하나면 충분하기 때문에 싱글톤 패턴으로 작성된다.
 * */

public class ActionFactory {

	// 싱글톤 패턴으로 딱 한번 생성
	private static ActionFactory factory = new ActionFactory();
	
	private ActionFactory() {
		System.out.println("ActionFactory Creating");
	}
	
	public static ActionFactory getInstance() {
		return factory;
	}
	
	// Action을 생성하는 기능
	public Action createAction(String command) {
		Action action = null;
		
		if(command.equals("INSERT")) {
			action = new AddAction();
		}else if(command.equals("DELETE")) {
			action = new DeleteAction();
		}
		return action;
	}

}
