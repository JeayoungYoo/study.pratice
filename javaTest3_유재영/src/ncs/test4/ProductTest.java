package ncs.test4;

public class ProductTest {

	public static void main(String[] args) {
		Product pd = new Product("°¶·°½Ã s7", 563500, 3);
		
		System.out.println(pd.information());
		System.out.println("ÃÑ ±¸¸Å °¡°Ý : " + pd.getPrice()*pd.getQuantity() + " ¿ø");

	}

}
