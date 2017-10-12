package practice04.prob01;

import java.util.ArrayList;
import java.util.List;

public class Printer {
//	public void println( int val ) {
//		System.out.println( val );
//	}
//
//	public void println( boolean val ) {
//		System.out.println( val );
//	}
//	
//	public void println( String val ) {
//		System.out.println( val );
//	}
//	
//	public void println( double val ) {
//		System.out.println( val );
//	}
	
	public<T> void println( T t ) {
		System.out.println( t );
	}
	
	public <T, P, Q> List<P> println( T t, Q q ){
		System.out.println( t + ":" + q );
		
		List<P> list = new ArrayList<P>();
		return list;
	}
	
	//가변 파라미터 메소드 만들기
	public void println2( String[] params ) {
		for( String s : params ) {
			System.out.println( s + ":" );
		}
		System.out.println( "" );
	}
	//파라미터 개수를 정하지 않고 넣고 싶을 때 사용(java 1.5부터 지원)
	public void println3( Object... params ) {
		for( Object s : params ) {
			System.out.println( s + ":" );
		}
		System.out.println( "" );
	}
}
