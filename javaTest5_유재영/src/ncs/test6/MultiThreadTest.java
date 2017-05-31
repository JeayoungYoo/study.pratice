package ncs.test6;

public class MultiThreadTest {

	public static void main(String[] args) {
		Data data = new Data();
		Thread putThread;
		Thread getThread;
		
		putThread = new Provider(data);
		getThread = new Customer(data);
		
		putThread.start();
		getThread.start();

	}

}
