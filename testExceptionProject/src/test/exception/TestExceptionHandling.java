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
		// 반드시 예외(Exception) 처리를 해야 하는 경우
		new TestExceptionHandling().methodA();
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream("sample.dat"));
		
		System.out.println("예외발생");
		

	}

}
