package shape;

public class Rectangle extends Shape implements Resize{
	public Rectangle(){}
	
	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
	}
	
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public void setResize(int size) {
		setWidth(getWidth()+size);
	}
	
	public String toString() {
		return "Rectangle\t" + getArea() + "\t" + getColors();
	}
}
