package stack.calc;

import java.util.Arrays;

public class CalculatorApp {

	public static void main(String[] args) {
		try {
			
			Calculator calculator = Calculator.getInstance();

			double result = calculator.calculate("2 *         1");
			System.out.println(result);

			result = calculator.calculate("2 * 1.0 + 3 / 2  ");
			System.out.println(result);

			result = calculator.calculate("(1 + 2 * 3 ) /   7");
			System.out.println(result);

			result = calculator.calculate("( 1 + 2 ) * ( 3 / 4 ) + ( 5 + ( 6 - 7 )   )  ");
			System.out.println(result);

			// expression error!!
			result = calculator.calculate("(1 + 2  + 3  + 7");
			System.out.println(result);
			
			String[] split = "2 * 1 + 3 / 2  ".split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
			
			System.out.println( Arrays.toString( split ));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
