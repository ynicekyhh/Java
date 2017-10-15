package chapter03.com.bigdata2017.paint.shape;

import chapter03.com.bigdata2017.paint.main.i.Resizable;

public class Triangle extends Shape implements Resizable {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	
	@Override
	public void draw() {
		System.out.println( "삼각형을 그렸습니다." );
	}

	@Override
	public int calcArea() {
		return 0;
	}

	@Override
	public void resize(double rate) {
	}
	
	
}
