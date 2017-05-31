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
		// char[] 배열에 문자 데이터를 넣는다. }
		// char[] 에서 대문자만 골라서 출력 한다. continue 문 사용할 것 while(){ } //while loop 문 사용한다.

	}

}
