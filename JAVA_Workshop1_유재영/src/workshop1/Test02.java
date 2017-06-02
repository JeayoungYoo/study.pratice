package workshop1;

public class Test02 {
	
	public static void main(String[] args) {
		char[] input = args[0].toCharArray();
		double parInput = input[0];
		double sum=0, multi=0, avg=0;
		int cnt=0;
		
		for (int i=0; i<parInput; i++) {
			sum += i;
			multi *= i;
			cnt++;
		}
		System.out.println("Че: " + sum);
		System.out.println("Аі: " + multi);
		System.out.println("ЦђБе: " + sum/cnt);
	}
}
