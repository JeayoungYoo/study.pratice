package test.string;

public class TestString {
	public static void main(String[] args){
		//String 클래스 테스트
		String s1 = new String();
		String s2 = new String(new byte[]{10, 20, 30, 40, 50});
		String s3 = new String(new char[]{'A', 'a', 'B', 'b'});
		String s4 = new String("java programming");
		String s5 = new String(new StringBuffer());
		String s6 = new String(new StringBuilder());
		
		
		String result1 = String.valueOf(false);
		System.out.println("result : " + result1 + ",\t" + result1.length());
		
		//non-static 이면서 반환값있고 매개변수 있는 메소드
		char ch = s4.charAt(9);
		System.out.println("10번째글자 : " + ch);
		System.out.println("3번째글자 : " + s4.charAt(2));
		
		//non-static 이면서 반환값 있고 매개변수 없는 메소드
		int len = s4.length();
		System.out.println("s4 글자갯수 : " + len);
		System.out.println("s4 글자갯수 : " + s4.length());
		
		//non-static 이면서 반환값 없고 매개변수 있는 메소드
		
		char[] dstStr = new char[5];
		s4.getChars(5, 10, dstStr, 0);
		for (int i = 0;i<dstStr.length;i++)
			System.out.println(i + " : " + dstStr[i]);
		System.out.println();
		
	}
}
