package workshop1;

public class Test01 {

	public static void main(String[] args) {
		System.out.println((Double.parseDouble(args[0])%Double.parseDouble(args[2])) ? "�������� 1���� �۰ų� ����" : "�������� 1���� ũ��");
		
		
		double input1 = Double.parseDouble(args[0]);
		double input2 = Double.parseDouble(args[2]);
		
		if (input1%input2<=1) {
			System.out.println("�������� 1���� �۰ų� ����!");
		}
		else
			System.out.println("�������� 1���� ũ��!");
		
	}

}