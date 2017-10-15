package chapter03.exception;

public class ExceptionTest {
	
	public static void main( String[] args ) {
		int result = 0;
		int a = 1;
		
		try {
			System.out.println( "some code1" );
			result = 1000 / a;
			System.out.println( "some code2" );
			System.out.println( "some code3" );
		} catch( ArithmeticException e ) {
			//1. 사과
			System.out.println( "죄송합니다." );
			
			//2. 로그 남기
			System.out.println( "error:" + e );
			
			//3. 정상종료
			return;
		} finally {
			System.out.println( "자원정리" );
		}
		
		System.out.println( result );
	}
}
