package test.exception;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class TestExceptionHandling {
	
	public void methodA(){
		methodB();
	}
	
	public void methodB() {
		methodC();
	}
	
	public void methodC() {
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		// �ݵ�� ����(Exception) ó���� �ؾ� �ϴ� ���
		new TestExceptionHandling().methodA();
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream("sample.dat"));
		
		System.out.println("���ܹ߻�");
		

	}

}
