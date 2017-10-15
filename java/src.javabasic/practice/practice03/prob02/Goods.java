package practice.practice03.prob02;

public class Goods {
	private String name;
	private int price;
	private int goodsStock;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null) {
			return;
		}
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		if(goodsStock < 0) {
			goodsStock = 0;
		}
		this.goodsStock = goodsStock;
	}
	
	/* GoodsApp에서 사용하는 메서드들 */
	public static boolean checkString(String[] str) {
		if( 
				(str.length != 3) || 
				(str[0] == null) ||
				(isNumber(str[1]) == false) || 
				(isNumber(str[2]) == false)
			) {
			System.out.println("입력을 잘 못 하셨습니다.");
			return false;
		}
		return true;
	}
	
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
}
