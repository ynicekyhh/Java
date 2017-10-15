package practice.practice03.prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		System.out.println("'이름 가격 재고' 순으로 총 3개의 상품을 입력하세요.");
		
		for(int i = 0; i < COUNT_GOODS; i++ ) {
			goods[i] = new Goods();
			String[] str = scanner.nextLine().split(" ");

			if( !Goods.checkString(str) ) {
				return;
			}
			
			goods[i].setName(str[0]);
			goods[i].setPrice(Integer.parseInt(str[1]));
			goods[i].setGoodsStock(Integer.parseInt(str[2]));
		}
		
		for(int i = 0; i < COUNT_GOODS; i++ ) {
			System.out.println(goods[i].getName() + "(가격:" + goods[i].getPrice() + "원)이 " + goods[i].getGoodsStock() + "개 입고 되었습니다.");
		}
		
		scanner.close();
	}
}
