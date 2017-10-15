package chapter04.util;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		v.addElement( "둘리" );
		v.addElement( "마이콜" );
		v.addElement( "도우너" );
		
		//순회1
		Enumeration<String> e = v.elements();
		while( e.hasMoreElements() ) {
			String s = e.nextElement();
			System.out.println(s);
		}
		
		//삭제
		v.removeElement( 1 );
		
		System.out.println( "====================" );
		
		//순회2
 		int count = v.size();
		for( int i = 0; i < count; i++ ) {
			String s = v.elementAt( i );
			System.out.println( s );
		}
	}

}
