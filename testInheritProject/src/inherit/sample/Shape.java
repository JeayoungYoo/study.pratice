package inherit.sample;


//�̿ϼ� �޼ҵ带 ����� ���� Ŭ������ �ݵ�� class �տ� abstract Ű���带 ��� ��
//�߻�(�̿ϼ�) Ŭ������ ��ü ���� �� ��.
public abstract class Shape {
	private String name;	//�̸�
	private double area;	//����
	private double perimeter;	//�ѷ�
	
	public Shape(){
		super();
//		System.out.println("Shape() ������.");
	}
	
	public Shape(String name){
		super();
//		System.out.println("Shape(name) ������.");
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
	//�̿ϼ��� �ޙ� : abstract method
	//�޼ҵ��� ���(�����)�� �����ϰ�, ����(������)�� ����.
	
	public abstract void calculator();
	
	
	
	void information() throws NullPointerException, ArithmeticException{
		System.out.println("�����̸� : " + name);
		System.out.println("���� : " + area);
		System.out.println("�ѷ� : " + perimeter);
	}
	
	@Override
	public String toString(){
		return this.name + ", " + this.area + ", " + this.perimeter;
	}
	
	@Override
	public boolean equals(Object obj){
		//�𽺰� �����ϴ� ��ü���� �ʵ��� obj�� �����ϴ� ��ü���� �ʵ���� 
		//������ ��� ��ġ�ϴ��� ��
		
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
