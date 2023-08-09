package pattern.action;

/*
 * AddAction 컴포넌트
 * --> 인터페이스 기반으로 작성된 재사용이 강한 자바 클래스
 * */

public class AddAction implements Action {

	@Override
	public void execute() {
		/*
		 * 1. 폼값 받아서
		 * 2. 객체 생성
		 * 3. DAO 리턴 
		 * 4. 리턴된 값 바인딩
		 * 5. path를 최종적으로 리턴
		 * */
		System.out.println("INSERT OK!");
	}

}
