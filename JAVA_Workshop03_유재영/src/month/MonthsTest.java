package month;

public class MonthsTest {

	public static void main(String[] args) {
		Months mon = new Months();
		int month = Integer.parseInt(args[0]);
		if (args.length > 1)
			System.out.println("다시 입력해주세요");
		else{
			if (month > 0 && month < 13) {
				System.out.println("입력받은월: " + month + "월");
				System.out.println("마지막일자: " + mon.getDays(month) + "일");
			}
			else
				System.out.println("입력된 값이 잘못 되었습니다.");
		}

	}

}
