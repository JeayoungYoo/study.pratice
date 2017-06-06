package workshop03;

public class Calc {
	public int calculate (int data) {
		int cnt =0;
		for (int i=0; i<data; i++) {
			if (i%2==0)
				cnt += i;
		}
		return cnt;
	}
}
