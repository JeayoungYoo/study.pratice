package workshop1;

public class Test02 {
	
	public static void main(String[] args) {
		double parInput = Double.parseDouble(args[0]);
		if (parInput > 5) {
			System.out.println("다시 입력하세요");
		}
		
		double sum=0, multi=1, avg=0;
		int cnt=0;
		
		for (int i=1; i<=parInput; i++) {
			sum += i;
			multi *= i;
			cnt++;
		}
		System.out.println("합: " + sum);
		System.out.println("곱: " + multi);
		System.out.println("평균: " + sum/cnt);
	}
}
