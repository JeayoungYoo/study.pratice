package product.test;

import product.view.ProductView;

public class ProductMain {

	public static void main(String[] args) {
		// product 테이블에 대한 CRUD 테스트
		new ProductView().displayMenu();
		System.out.println("상품 관리 프로그램을 종료합니다.");
	}

}
