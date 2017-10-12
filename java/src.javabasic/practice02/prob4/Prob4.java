package practice02.prob4;
public class Prob4 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		int j = str.length();
		char[] c = new char[j];
		
		for(int i = 0; i < str.length(); i++) {
			
			c[j-1] = str.charAt(i);			
			j--;
		}
		
		return c;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		for(char c : array) {
			System.out.print(c);
		}
		System.out.println();
	}
}
