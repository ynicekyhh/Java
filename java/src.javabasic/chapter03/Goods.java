package chapter03;

public final class Goods {
	private static int countOfGoods;
	public static final double DISCOUNT_RATE = 0.3;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		// Goods.countOfGoods++;
		// 같은 클래스 안에서는 생략 가능
		countOfGoods++;
	}
	
	public static int getCountOfGoods() {
		return countOfGoods;
	}
	
	public final String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if( price < 0 ) {
			price = 0;
		}
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}



	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		//private 접근자는 내부에서만 접근이 가능하다.
		System.out.println( 
			"Goods[name=" + name + 
			",price=" + price + 
			",countStock=" + countStock +
			",countSold=" + countSold + "]" );
	}
	
	public int calcDiscountPrice( int percentage ) {
		int discountPrice = price * percentage / 100;
		return discountPrice;
	}
}
