package chapter04.lang;

public class EqualsTest {

	public static void main(String[] args) {
		Point point1 = new Point(10, 20);
		Point point2 = new Point(10, 20);
		Point point3 = point2;

		// == 연산자에서 두 개의 항이 객체 참조 변수 인 경우
		// 두 객체의 동일 여부(동일성)
		System.out.println( point1 == point2 );
		System.out.println( point2 == point3 );
		
		// 두 객체의 동질성 비교를 할 때에는 equals 메소드를 사용
		// equals가 오버라이드가 안된 경우에는 == 완전히 동일
		System.out.println( point1.equals( point2 ) );
		System.out.println( point2.equals( point3 ) );
	
		
		System.out.println( "====================" );
		
		/* String 객체와 비교 */
		String s1 = new String( "hello" );
		String s2 = new String( "hello" );
		String s3 = s2;
		
		System.out.println( s1 == s2 );
		System.out.println( s2 == s3 );
		
		System.out.println( s1.equals(s2) );
		System.out.println( s2.equals(s3) );
		
		//hascode() 비교
		System.out.println( s1.hashCode() );
		System.out.println( s2.hashCode() );
		System.out.println( System.identityHashCode(s1) );
		System.out.println( System.identityHashCode(s2) );
		
		// String Literal
		String str1 = "hello";
		String str2 = "hello";
		String str3 = str2;
		
		System.out.println( str1 == str2 );
		System.out.println( str2 == str3 );
	
	}

}
