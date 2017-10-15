package chapter04.lang;

public class PointTest {

	public static void main(String[] args) {
		Point point = new Point();
		
		System.out.println( point.getClass().getName() );
		System.out.println( point.hashCode() );
		System.out.println( point.toString() );
		// getClass().getName() + "@" + hashCode()
		System.out.println( point );
	
		System.out.println( "====================");
		
		/* String 객체와 비교 */
		String s = new String( "hello" );
		System.out.println( s.getClass().getName() );
		System.out.println( s.hashCode() );
		System.out.println( s.toString() );
		// getClass().getName() + "@" + hashCode()
		System.out.println( s );
		
	}

}
