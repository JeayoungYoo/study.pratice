package game.baseball;

class GameLogic {
	public static int MAX_COUNT = 4;
	public static int MAX_INPUT = 20;
	int x = 0, y = 0;
	private boolean val = false;
	private int baseNumber[] = new int[MAX_COUNT];
	private int userNumber[] = new int[MAX_COUNT];
	private int cnt = 0;

	GameLogic() {
	}

	void randomInt() {
		do {
			baseNumber[0] = (int) (Math.random() * 10);
		} while (baseNumber[0] == 0);

		for (int i = 1; i < baseNumber.length; i++) {
			baseNumber[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				while (baseNumber[i] == baseNumber[j] || baseNumber[i] == 0) {
					baseNumber[i] = (int) (Math.random() * 10);
					j = 0;
				}
			}
		}
	}

	void inputUserNumber1(String in1) {

		String in = in1;
		for (int i = 0; i < userNumber.length; i++) {
			userNumber[i] = in.charAt(i) - 48;
		}
		countSB(baseNumber, userNumber);

	}

	synchronized void countSB(int a[], int b[]) { 

		x = 0;
		y = 0; 
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[i] == a[j])
					if (i == j)
						x += 1;
					else
						y += 1;
			}
		}
		cnt++;
		if (x == MAX_COUNT) {
			val = true;
			return;
		} 
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	int getCount() {
		return cnt;
	}

	boolean getValue() {
		return val;
	}

}