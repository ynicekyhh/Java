package chapter03.com.bigdata2017.paint.shape;

public class Circle extends Shape {
	private int x1;
	private int y1;
	private int radius;

	public Circle( int x1, int y1, int radius ) {
		this.x1 = x1;
		this.y1 = y1;
		this.radius = radius;
	}
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println( "원을 그렸습니다." );
	}

	@Override
	public int calcArea() {
		return (int)(Math.PI * Math.pow(radius, 2) );
	}

}
