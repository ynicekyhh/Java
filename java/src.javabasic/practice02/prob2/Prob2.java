package practice02.prob2;

import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int intArray[] = new int[5];
		double avg = 0;
		
		System.out.println("5개의 숫자를 입력하세요.");
		for(int i = 0; i < intArray.length; i++ ) {
			avg += in.nextInt();
		}
		avg /= intArray.length;
		System.out.println("평균은 " + avg + "입니다.");
		in.close();
	}
}
