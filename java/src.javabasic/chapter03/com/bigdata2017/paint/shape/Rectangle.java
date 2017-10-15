package chapter03.com.bigdata2017.paint.shape;

public class Rectangle extends Shape {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	@Override
	public void draw() {
		System.out.println( "사각형을 그렸습니다." );
	}

	@Override
	public int calcArea() {
		return (x2-x1) * (y2-y1);
	}
	
	
}
