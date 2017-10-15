package chapter03;

public class ArrayUtilTest {

	public static void main(String[] args) {
		
		int[] a = { 10, 20, 30, 40, 50 };
		double[] d = ArrayUtil.intToDouble( a );
		
		for( double val : d ) {
			System.out.println( val );
		}
	}

}
