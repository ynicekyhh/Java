package recursion;

public class FibonacciTest {
	public static int countOfCall = 0;
	
	public static void main(String[] args) {
		System.out.print( 
			"40:" + fibonacci( 40 ) + ":" + countOfCall );
	}

	public static int fibonacciLoop( int n ) {
		return 0;
	}
	
	public static int fibonacci( int n ) {
		countOfCall++;
		
		if( n == 0 ) {
			return 0;
		}
		
		if( n == 1 ) {
			return 1;
		}
		
		return fibonacci( n - 1 ) + fibonacci( n - 2 );
	}
}
