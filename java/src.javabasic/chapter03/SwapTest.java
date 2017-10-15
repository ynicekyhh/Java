package chapter03;

public class SwapTest {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		
		System.out.println( "i=" + i + ",j=" + j);
		swap( i, j );
		System.out.println( "i=" + i + ",j=" + j);

		Value v1 = new Value();
		v1.setVal( 10 );
		Value v2 = new Value();
		v2.setVal( 20 );		
		System.out.println( 
				"v1=" + v1.getVal() + 
				",v2=" + v2.getVal() );
		swap2( v1, v2 );
		System.out.println( 
				"v1=" + v1.getVal() + 
				",v2=" + v2.getVal() );
	
	}
	
	public static void swap(int a, int b ) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void swap2( Value a, Value b ) {
		int temp = a.getVal();
		a.setVal( b.getVal() );
		b.setVal( temp );
	}
}
