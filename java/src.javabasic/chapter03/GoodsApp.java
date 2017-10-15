package chapter03;

import chapter03.mypackage.Goods2;

public class GoodsApp {

	public static void main(String[] args) {
		System.out.println( "git test" );
		
		Goods goods = new Goods();
		//private 접근자는 내부에서만 접근이 가능하다.
		//goods.name = "nikon"; //에러
		goods.setName( "nikon");
		//goods.price = 200000;
		int price = -1;
		goods.setPrice( price );
		//goods.countSold = 10;
		goods.setCountSold( 10 );
		//goods.countStock = 100;
		goods.setCountStock( 100 );
		
		System.out.println(
				//private 접근자는 내부에서만 접근이 가능하다.
				//"name:" + goods.name + //에러
				"name:" + goods.getName() +
				",price:" + goods.getPrice() +
				",countSold:" + goods.getCountSold() +
				",countStock:" + goods.getCountStock());
		
		goods.showInfo();
		int discountPrice = 
				goods.calcDiscountPrice( 20 );
		
		System.out.println( discountPrice );
		
		
		// default 접근자 필드는 다른 패키지에서는 접근 불가
		//Goods2 goods2 = new Goods2();
		//goods2.name = "coke";
		
		// static 변수 테스트
		Goods g = new Goods();
		System.out.println( Goods.getCountOfGoods() );
		
		g = new Goods();
		System.out.println( Goods.getCountOfGoods() );

		g = new Goods();
		System.out.println( Goods.getCountOfGoods() );
	
		final int VALUE = 10;
		// final 로 정의된 변수 이후에 값대입은 에러  => 상수
		//value = 20;
		
		System.out.println( Math.PI * 3 * 3 );
	}

}
