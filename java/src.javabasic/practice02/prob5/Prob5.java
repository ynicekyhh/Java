package practice02.prob5;

import java.util.Random;
import java.util.Scanner;

public class Prob5 {

	public static void main(String[] args) {

		// 게임 변수 초기화
		int minNumber = 1;
		int maxNumber = 100;

		// 정답 램덤하게 만들기
		Random random = new Random();
		int correctNumber = random.nextInt(maxNumber) + minNumber;
		Scanner scanner = new Scanner(System.in);
		int selectNumber = 0;
		
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		System.out.println("1-100");
		
		
		while(true) {
			System.out.print(minNumber++ + ">>");
			selectNumber = scanner.nextInt();
			
			if(selectNumber > correctNumber) {
				System.out.println("더 낮게");
			}else if(selectNumber < correctNumber) {
				System.out.println("더 높게");
				
			}else {
				System.out.println("맞았습니다.");
				System.out.print("다시하시겠습니까(y/n)>>");
				
				String answer = scanner.next();
				if( answer.equals("y") ){	//다시
					System.out.println("다시합니다.");
					minNumber = 1;
					correctNumber = random.nextInt(maxNumber) + minNumber;
					continue;
				}else if( answer.equals("n") ) {	//종료	
					System.out.println("종료합니다.");
					break;
				}
			}
		}
		
//		System.out.println( correctNumber );
		scanner.close();
	}

}