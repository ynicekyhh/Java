package chapter04.lang;

public class WrapperClassTest {

	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character( 'c' );
		Float f = new Float( 3.14 );
		Boolean b = new Boolean( true );
		
		//Auto Boxing
		Integer j = 10;
		
		//Auto Unboxing
//		int k = 20 + j.intValue();
		int k = 20 + j;
		
		swap( i, k );
	}
	
	public static void swap( Integer a, Integer b ) {
//		int temp = a;
//		a = b;	//Integer 객체니까 참조값을 변경시켜버림
		//객체이지만 내부를 수정 할 수 없다.
	}

}
