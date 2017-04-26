package inherit.sample;

public class Circle extends Shape{
	private double radius;
	
	public Circle(){
		super(); //생성자 안에서만 사용가능, 첫 줄에만 기입함
//		System.out.println("Circle() 구동됨.");
	}
	
	public Circle(double radius){
		super();
//		System.out.println("Circle(radius) 구동됨.");
		this.radius = radius;
	}
	
	public Circle(String name, double radius){
		super(name);	//부모의 매개변수 있는 생성자 호출함
		//this.name = name;	//private 이라서 접근 불가능
		//this.setName(name);	//값 변경이므로 부적합.
				
		this.radius = radius;
//		System.out.println("Circle(name, radius) 구동됨.");
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public void information(){
		super.information();
//		System.out.println("반지름 : "+ radius);
	}
	
	@Override
	public void calculator(){
		setArea(Math.PI * Math.pow(radius, 2));
		setPerimeter(2 * Math.PI * radius);
	}
	
	@Override
	public String toString(){
		return super.toString() + ", " + this.radius;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		Circle other = (Circle)obj;
		
		if (super.equals(obj) && this.radius == other.radius)
			result = true;
		return result;
	}

	@Override
	public Object clone(){
		Circle c = new Circle();
		c.setName(this.getName());
		c.setArea(this.getArea());
		c.setPerimeter(this.getPerimeter());
		c.radius = this.radius;
		return c;
	}
	
}
