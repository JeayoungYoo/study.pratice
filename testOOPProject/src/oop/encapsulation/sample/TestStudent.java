package oop.encapsulation.sample;

public class TestStudent {

	public static void main(String[] args) {
		Student st;
		st = new Student();
		
		System.out.println("st�� ���� �ּ� : " + st.hashCode());
		System.out.println("st.toString() : " + st.toString());
		//st.sno=123;
		st.setSno(123);
		/*st.name = "ȫ�浿";
		System.out.println("st�� �����ϴ� ��ü ���� name �� : " + st.name);*/
		DefaultSample dsamp;
		FinalSample fsamp = new FinalSample();
		AbstractSample asamp;
		//asamp = new AbstractSample(); // ��ü�� ������ ���Ѵ�
		

	}

}
