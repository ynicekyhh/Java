package chapter04.util;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.push( "둘리" );
		stack.push( "마이콜" );
		stack.push( "도우넛" );
		stack.push( "길동" );
		
		System.out.println( stack.isEmpty() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.peek() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		
		//stack은 비어 있는 경우 pop() 호출 시 예외가 발생 --> linkedList는 null이면 비어있으나, ArrayList는 비어있지않으니까 예외
//		System.out.println( stack.pop() );
		
		System.out.println( stack.isEmpty() );
	}

}
