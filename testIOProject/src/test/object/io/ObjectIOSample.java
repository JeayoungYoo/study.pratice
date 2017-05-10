package test.object.io;

import java.io.*;


public class ObjectIOSample {
	public ObjectIOSample(){}
	
	public void testObjectOutputStream(){
		try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
			objOut.writeObject(new Student("ȫ�浿", 25, 78.9));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testObjectInputStream(){
		try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream("student.dat"))) {
			Student stu = (Student) objin.readObject();
			System.out.println(stu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
