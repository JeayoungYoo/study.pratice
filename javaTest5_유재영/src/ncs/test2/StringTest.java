package ncs.test2;

public class StringTest {

	public static void main(String[] args) {
		String str = "A,b,c,D,a,B,C,d,f,F";
		String[] st = str.split(",");
		char[] data = new char[st.length];
		int i=0;
		for(String s : st) {
			data[i] = s.charAt(0);
			i++;
		}
		
		i=0;
		while(i<st.length) {
			if (!(data[i]>='A' && data[i]<='Z')) {
				i++;
				continue;
			}
			System.out.println("data["+i+"] : " + data[i++]);
		}
		// char[] �迭�� ���� �����͸� �ִ´�. }
		// char[] ���� �빮�ڸ� ��� ��� �Ѵ�. continue �� ����� �� while(){ } //while loop �� ����Ѵ�.

	}

}
