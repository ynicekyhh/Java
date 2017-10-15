package chapter03.com.bigdata2017.paint.shape;

import chapter03.com.bigdata2017.paint.main.i.Drawable;

public abstract class Shape implements Drawable {
	private String fillColor;
	private String lineColor;
	
	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	public abstract int calcArea();
}
