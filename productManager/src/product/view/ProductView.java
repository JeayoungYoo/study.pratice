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
			System.out.println("\n상품관리 프로그램\n");
			System.out.println("1. 새 상품 등록");
			System.out.println("2. 상품 전체 조회");
			System.out.println("3. 상품 아이디로 조회");
			System.out.println("4. 상품 가격 수정");
			System.out.println("5. 상품 삭제");
			System.out.println("9. 끝내기");
			System.out.print("번호 입력 : ");
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
				System.out.println("정말로 종료하시겠습니까? (y/n) : ");
				if ((sc.next().toUpperCase().charAt(0)) == 'Y')
					return;
				else
					break;
			default:
				System.out.println("번호 선택이 잘못 되었습니다.");
				System.out.println("다시 입력하십시오.\n");
			}
		} while (true);

	}

	private String delete() {
		System.out.println("\n삭제할 상품정보를 입력하시오. \n");

		System.out.print("삭제할 상품 id : ");
		return sc.next();
	}

	private Product update() {
		Product p = new Product();

		System.out.println("\n수정할 상품정보를 입력하시오. \n");

		System.out.print("수정할 상품 id : ");
		p.setProduct_Id(sc.next());
		System.out.print("가격 : ");
		p.setPrice(sc.nextInt());

		return p;
	}

	private void printOne(Product p) {
		System.out.println(p);

	}

	private String inputProductId() {
		System.out.print("조회할 상품 id : ");
		return sc.next();
	}

	private void printList(ArrayList<Product> selectList) {
		for (Product p : selectList)
			System.out.println(p);
	}

	private Product input() {
		Product p = new Product();

		System.out.println("\n새 상품을 입력하시오");
		System.out.print("상품id : ");
		p.setProduct_Id(sc.next());
		System.out.print("상품 이름 : ");
		p.setP_name(sc.nextLine() + sc.nextLine());
		System.out.print("가격 : ");
		p.setPrice(sc.nextInt());
		System.out.print("설명 : ");
		p.setDescription(sc.nextLine() + sc.nextLine());

		return p;
	}

	public void error() {
		System.out.println("상품 정보 추가/수정/삭제 에러 발생");
		displayMenu();

	}

}
