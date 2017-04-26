package inherit.sample;

public class Rectangle extends Shape{
	private double width, height;
	
	public Rectangle(){
//		System.out.println("Rectangle() ±∏µøµ ");
	}
	
	public Rectangle(double width, double height){
//		System.out.println("Rectangle(width, height) ±∏µøµ ");
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(String name, double width, double height){
		super(name);
		this.width = width;
		this.height = height;
//		System.out.println("Rectangle(name, width, height) ±∏µøµ ");
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public void information(){
		super.information();
		System.out.println("≥ ∫Ò : " + width);
		System.out.println("≥Ù¿Ã : " + height);
	}
	
	@Override
	public void calculator(){
		this.setArea(width * height);
		this.setPerimeter(2 * (width + height));
	}
	
	@Override
	public String toString(){
		return super.toString() + ", " + this.width + ", " + this.height;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		Rectangle other = (Rectangle)obj;
		
		if (super.equals(obj) && this.width == other.width && this.height == other.height)
			result = true;
		return result;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Rectangle r = new Rectangle();
		
		r.setName(this.getName());
		r.setArea(this.getArea());
		r.setPerimeter(this.getPerimeter());
		r.width = this.width;
		r.height = this.height;
		
		return r;
	}
	
	
}
