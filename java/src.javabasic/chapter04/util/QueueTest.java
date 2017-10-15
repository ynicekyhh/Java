package chapter04.util;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		//add도 되지만, add는 queue에 사이즈 제한이 있는경우 등에 에러가 발생할 수 있고, offer-poll는 실패한다.
		queue.offer( "둘리" );
		queue.offer( "마이콜" );
		queue.offer( "도우넛" );
		queue.offer( "길동" );
		
		System.out.println( queue.isEmpty() );
		System.out.println( queue.poll() );
		System.out.println( queue.poll() );
		System.out.println( queue.peek() );
		System.out.println( queue.poll() );
		System.out.println( queue.poll() );
		
		System.out.println( queue.isEmpty() );
		
		//비어 있으면 null이 리턴된다.
		System.out.println( queue.poll() );
	}

}
