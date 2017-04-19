package oop.encapsulation.sample;

public class TestStudent {

	public static void main(String[] args) {
		Student st;
		st = new Student();
		
		System.out.println("st가 가진 주소 : " + st.hashCode());
		System.out.println("st.toString() : " + st.toString());
		//st.sno=123;
		st.setSno(123);
		/*st.name = "홍길동";
		System.out.println("st가 참조하는 객체 안의 name 값 : " + st.name);*/
		DefaultSample dsamp;
		FinalSample fsamp = new FinalSample();
		AbstractSample asamp;
		//asamp = new AbstractSample(); // 객체는 만들질 못한다
		

	}

}
