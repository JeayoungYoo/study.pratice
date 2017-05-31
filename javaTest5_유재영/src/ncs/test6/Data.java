package ncs.test6;

public class Data {
	private int value;
	private boolean isEmpty;
	public Data() {
		super();
	}
	public int getValue() throws EmptyException {
		if (isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (!(isEmpty)) {
			return value;
		}
		else
			throw new EmptyException("���� �Էµ� ���� �����ϴ�. ��ٸ��ʽÿ�...");
		return value;
	}
	
	public void setValue(int value) {
		if (isEmpty) {
			this.value = value;
			isEmpty = false;
			notifyAll();
		} else
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
