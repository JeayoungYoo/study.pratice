package ncs.test4;

public class ProductTest {

	public static void main(String[] args) {
		Product pd = new Product("������ s7", 563500, 3);
		
		System.out.println(pd.information());
		System.out.println("�� ���� ���� : " + pd.getPrice()*pd.getQuantity() + " ��");

	}

}
