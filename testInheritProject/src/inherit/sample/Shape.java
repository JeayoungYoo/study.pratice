package inherit.sample;


//미완성 메소드를 멤버로 가진 클래스는 반드시 class 앞에 abstract 키워드를 써야 함
//추상(미완성) 클래스를 객체 생성 못 함.
public abstract class Shape {
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
	
	//public void calculator(){
	//미완성된 메솓 : abstract method
	//메소드의 헤드(선언부)만 존재하고, 몸통(구현부)가 없음.
	
	public abstract void calculator();
	
	
	
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

/*	@Override
	protected Object clone() throws CloneNotSupportedException {
		Shape s = new Shape();
		s.name = this.name;
		s.area = this.area;
		s.perimeter = this.perimeter;
		return s;
	}*/
}
