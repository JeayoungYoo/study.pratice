package ncs.test6;

public class Customer extends Thread {
	private Data data;

	public Customer(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		super.run();
		
		for (int i=0; i<10; i++)
			try {
				System.out.println(data.getValue());
				System.out.println("get value : " + data.getValue());
				System.out.println("값을 꺼냈습니다. value 가 비었습니다.");
				sleep(100);
				
			} catch (EmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
