package month;

public class MonthsTest {

	public static void main(String[] args) {
		Months mon = new Months();
		int month = Integer.parseInt(args[0]);
		if (args.length > 1)
			System.out.println("�ٽ� �Է����ּ���");
		else{
			if (month > 0 && month < 13) {
				System.out.println("�Է¹�����: " + month + "��");
				System.out.println("����������: " + mon.getDays(month) + "��");
			}
			else
				System.out.println("�Էµ� ���� �߸� �Ǿ����ϴ�.");
		}

	}

}
