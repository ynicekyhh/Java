package chapter04.lang;

public class WrapperClassTest2 {

	public static void main(String[] args) {
		System.out.println( Character.toLowerCase( 'a' ) );
		System.out.println( Character.isDigit( '1' ) );
		System.out.println( Character.isDigit( '@' ) );
		
		//정규 표현식
		//로직 검증 시에는 try - catch 문 대신 if - else 를 사용할 것
		String s = "-1234@asdf";
		if( s.matches("-?\\d+(\\.\\d+)") == false ) {
			System.out.println( "숫자가 아닙니다." );
		}else {
			int i = Integer.parseInt( s );
		}
		
		// 프로그램 로직(변수 검증) 할 때는 
		// try - catch 문으로 하지 말 것(exception 발생 시 메모리 추적으로 비용이 많이 든다.)
/*
		try {
			int i = Integer.parseInt( s );
		} catch( NumberFormatException e ) {
			System.out.println( "숫자가 아닙니다." );
		}
*/
		
		System.out.println( Integer.parseInt( "10", 10 ) );
		System.out.println( Integer.parseInt( "A", 16 ) );
		System.out.println( Integer.toBinaryString( 255 ) );
		System.out.println( Integer.toHexString( 255 ) );
		System.out.println( Double.parseDouble( "44.13e-16" ) );
		System.out.println( Long.parseLong( "1234567890" ) );
		
		System.out.println( String.valueOf( 12345 ) );
	}

}
