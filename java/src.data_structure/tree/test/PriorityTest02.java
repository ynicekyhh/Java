package tree.test;

import queue.Queue;
import tree.Comparator;
import tree.PriorityQueue;

public class PriorityTest02 {

	public static void main(String[] args) {
//		Queue<String> pq = new LinkedList<String>();
		Queue<String> pq = new PriorityQueue<String>(10, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		pq.offer( "A" );
		pq.offer( "ABCDEF" );
		pq.offer( "ABC" );
		pq.offer( "ABCDEFGHI" );
		pq.offer( "ABCDE" );

		System.out.println( pq.poll() );
		System.out.println( pq.poll() );
		System.out.println( pq.poll() );
		System.out.println( pq.poll() );
		System.out.println( pq.poll() );
		// Exception!!
		//System.out.println( pq.poll() );
	}

}
