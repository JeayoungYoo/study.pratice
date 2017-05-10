package test.object.io;

import java.io.*;

public class Student extends Person implements Serializable{

	private String name;
	private transient int classNo;
	private double score;
	private Object ref; //Object 필드는 직렬화에서 제외됨.
	
	
	public Student(String name, int classNo, double score) {
		this.name = name;
		this.classNo = classNo;
		this.score = score;
	}
	
	public Student() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + ", " + classNo + ", " + score;
	}
	
	
}
