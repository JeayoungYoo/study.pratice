package product.view;

import java.util.ArrayList;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.vo.Product;

public class ProductView {
	private Scanner sc = new Scanner(System.in);

	public ProductView() {
	}

	public void displayMenu() {
		int no;
		ProductController pcontroll = new ProductController();

		do {
			System.out.println("\n��ǰ���� ���α׷�\n");
			System.out.println("1. �� ��ǰ ���");
			System.out.println("2. ��ǰ ��ü ��ȸ");
			System.out.println("3. ��ǰ ���̵�� ��ȸ");
			System.out.println("4. ��ǰ ���� ����");
			System.out.println("5. ��ǰ ����");
			System.out.println("9. ������");
			System.out.print("��ȣ �Է� : ");
			no = sc.nextInt();

			switch (no) {
			case 1:
				pcontroll.productInsert(input());
				break;
			case 2:
				printList(pcontroll.selectList());
				break;
			case 3:
				printOne(pcontroll.selectProduct(inputProductId()));
				break;
			case 4:
				pcontroll.updateProduct(update());
				break;
			case 5:
				pcontroll.deleteProduct(delete());
				break;
			case 9:
				System.out.println("������ �����Ͻðڽ��ϱ�? (y/n) : ");
				if ((sc.next().toUpperCase().charAt(0)) == 'Y')
					return;
				else
					break;
			default:
				System.out.println("��ȣ ������ �߸� �Ǿ����ϴ�.");
				System.out.println("�ٽ� �Է��Ͻʽÿ�.\n");
			}
		} while (true);

	}

	private String delete() {
		System.out.println("\n������ ��ǰ������ �Է��Ͻÿ�. \n");

		System.out.print("������ ��ǰ id : ");
		return sc.next();
	}

	private Product update() {
		Product p = new Product();

		System.out.println("\n������ ��ǰ������ �Է��Ͻÿ�. \n");

		System.out.print("������ ��ǰ id : ");
		p.setProduct_Id(sc.next());
		System.out.print("���� : ");
		p.setPrice(sc.nextInt());

		return p;
	}

	private void printOne(Product p) {
		System.out.println(p);

	}

	private String inputProductId() {
		System.out.print("��ȸ�� ��ǰ id : ");
		return sc.next();
	}

	private void printList(ArrayList<Product> selectList) {
		for (Product p : selectList)
			System.out.println(p);
	}

	private Product input() {
		Product p = new Product();

		System.out.println("\n�� ��ǰ�� �Է��Ͻÿ�");
		System.out.print("��ǰid : ");
		p.setProduct_Id(sc.next());
		System.out.print("��ǰ �̸� : ");
		p.setP_name(sc.nextLine() + sc.nextLine());
		System.out.print("���� : ");
		p.setPrice(sc.nextInt());
		System.out.print("���� : ");
		p.setDescription(sc.nextLine() + sc.nextLine());

		return p;
	}

	public void error() {
		System.out.println("��ǰ ���� �߰�/����/���� ���� �߻�");
		displayMenu();

	}

}
