package practice.practice03.prob06;

import java.util.Scanner;

public class CalcApp {

	public static boolean isNumber(String str){
		try{
			Integer.parseInt(str);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String operator = null;
		int a = 0;
		int b = 0;
		String expression = null;
		String[] splitedStr = null;
		
		while( true ) {
			
			/*  코드를 완성 합니다 */
			System.out.print( ">> " );
			expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			splitedStr = expression.split(" ");
			
			if(
					( splitedStr.length != 3 ) ||
					( !isNumber(splitedStr[0]) ) || 
					( !isNumber(splitedStr[2]) )
				){
				System.out.println("입력오류");
			}else{
				a = Integer.parseInt(splitedStr[0]);
				b = Integer.parseInt(splitedStr[2]);
				
				operator = splitedStr[1];
				Calc calc = null;
				
				switch(operator){
				case "+":
					calc = new Add();
					break;
				case "-":
					calc = new Sub();
					break;
				case "*":
					calc = new Mul();
					break;
				case "/":
					calc = new Div();
					break;
				default:
					System.out.println("입력을 잘못하였습니다.");
					break;
				}
				calc.setValue(a, b);
				System.out.print(">> " + calc.calculate() + "\n");
			}//end if-else
		}//end while
		scanner.close();
	}

}
