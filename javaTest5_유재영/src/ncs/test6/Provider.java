package ncs.test6;

import java.util.Random;

public class Provider extends Thread {
	private Data data;
	Random r = new Random();

	public Provider(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		super.run();
		int random = 0;
		for (int i=0; i<10; i++)
			try {
				random = r.nextInt(99)+1;
				data.setValue(random);
				System.out.println("값이 입력되었습니다.");
				System.out.println("put value : " + random);
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
