package practice05.prob6;

public class Rectangle extends Shape implements Resizable{
	double width;
	double height;
	
	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}

	@Override
	public void resize(double s) {
		width = width * s;
		height = height * s;
	}

}
