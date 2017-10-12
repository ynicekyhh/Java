package practice02.prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		Scanner scanner = new Scanner(System.in);
		int money = 0;
		
		System.out.print("금액: ");
		money = scanner.nextInt();
		
		for(int i : MONEYS) {
			if(money >= i) {
				System.out.println(i + "원 : " + money/i + "개");
				money %= i;
			}
		}
		
		scanner.close();
 	}
}