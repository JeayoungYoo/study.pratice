package test.access;

import access.sample.Asample;

public class TestAccessModifier {

	public static void main(String[] args) {
		Asample a; //public class 이기 때문에 import하면 사용가능
//		a = 100;
		a = new Asample();
		

	}

}
