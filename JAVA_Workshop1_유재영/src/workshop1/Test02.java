package workshop1;

public class Test02 {
	
	public static void main(String[] args) {
		double parInput = Double.parseDouble(args[0]);
		if (parInput > 5) {
			System.out.println("�ٽ� �Է��ϼ���");
		}
		
		double sum=0, multi=1, avg=0;
		int cnt=0;
		
		for (int i=1; i<=parInput; i++) {
			sum += i;
			multi *= i;
			cnt++;
		}
		System.out.println("��: " + sum);
		System.out.println("��: " + multi);
		System.out.println("���: " + sum/cnt);
	}
}
