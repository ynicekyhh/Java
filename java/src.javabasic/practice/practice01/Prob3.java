package practice.practice01;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner( System.in  );
		
		while( true ) {
			int num = 0;
			int result = 0;
			int i = 0;
			
			System.out.print("숫자를 입력하세요 : ");
			num = scanner.nextInt();
			
			if(num == 0) {	//end program
				break;
			}
			
			if(num % 2 == 0) {	//even
				i = 2;
			}else {	// odd
				i = 1;
			}
			for(; i <= num; i += 2) {
				result += i;
			}
			
			System.out.println("결과 값 : " + result);
		}
		scanner.close();

	}
}