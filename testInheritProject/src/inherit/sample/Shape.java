package inherit.sample;

public class Shape {
	private String name;	//이름
	private double area;	//면적
	private double perimeter;	//둘레
	
	public Shape(){
		super();
//		System.out.println("Shape() 구동됨.");
	}
	
	public Shape(String name){
		super();
//		System.out.println("Shape(name) 구동됨.");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	
	public void calculator(){
		
	}
	
	void information() throws NullPointerException, ArithmeticException{
		System.out.println("도형이름 : " + name);
		System.out.println("면적 : " + area);
		System.out.println("둘레 : " + perimeter);
	}
	
	@Override
	public String toString(){
		return this.name + ", " + this.area + ", " + this.perimeter;
	}
	
	@Override
	public boolean equals(Object obj){
		//디스가 참조하는 객체안의 필드들과 obj가 참조하는 객체안의 필드들의 
		//값들이 모두 일치하는지 비교
		
		boolean result = false;
		Shape other = (Shape)obj;
		if(this.name.equals(other.name) && this.area == other.area && this.perimeter == other.perimeter)
			result = true;
		
		return result;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Shape s = new Shape();
		s.name = this.name;
		s.area = this.area;
		s.perimeter = this.perimeter;
		return s;
	}
	
	/*public Shape copyShape() throws CloneNotSupportedException{
		return (Shape)this.clone();
	}*/
	

	
}
