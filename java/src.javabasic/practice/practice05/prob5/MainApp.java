package practice.practice05.prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack<String> stack = new MyStack<String>(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				// 런타임 에러
				// generic을 사용하지 않으면 코드 작성시 타입 체크를 하지 않음
				// Integer s = (Integer)stack.pop();
				String s = (String) stack.pop();
				
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack<String>(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
			//generic 객체 생성 : ?는 와일드카드, 모든 타입이 다 올 수 있다.
			MyStack<?> objectStack = new MyStack<String>(10);
//			MyStack<? extends Number> numberStack = 
//					new MyStack<Long>(10);	//?를 쓰면서 특정 일부 클래스로 한정시킬 수 있음
//			numberStack.push(10);	//?를 생성시 사용하면 이런경우 에러발생 --> 파라미터를 넘겨줄 때 ?로 특정 클래스로 지정해서 사용
			
		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}
