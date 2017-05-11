package test.list;

public class Person implements java.io.Serializable {
	private String name;
	private int age;
	private double point;
	public Person() {
		super();
	}
	public Person(String name, int age, double point) {
		super();
		this.name = name;
		this.age = age;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return name + ", " + age + ", " + point;
	}
	
	
}
