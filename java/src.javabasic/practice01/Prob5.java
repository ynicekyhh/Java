package practice01;

public class Prob5 {
	public static void main(String[] args) {
/*		
 		int result = 0;
		int count = 0;
		int num = 0;

		for(int i = 1; i < 1000; i++ ) {
			num = i;

			while(num > 0) {	//30, 13, 33
				result = num % 10;
				if( result == 3 || result == 6 || result == 9) {
					count++;
				}
				num /= 10;
			}
			if(count > 0) {
				System.out.print(i + " ");
				for(;count>0;count--) {
					System.out.print("짝");
				}
				System.out.println();
			}				
		}//end for
*/	
		
		String numberString = "";
		char c;
		int count = 0;
		
		for(int i = 0; i< 100; i++) {
			numberString = String.valueOf(i);
			
			for(int j = 0; j < numberString.length(); j++) {
				c = numberString.charAt(j);
				if((c == '3') || (c == '6') || (c == '9') ) {
					count++;
				}
			}
			if(count > 0) {
				System.out.print(i + " ");
				for(;count>0;count--) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}
	}
}