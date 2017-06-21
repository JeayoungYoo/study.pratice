package product.controller;

import java.util.ArrayList;
import product.model.dao.ProductDAO;
import product.model.vo.Product;
import product.view.ProductView;

public class ProductController {

	public void productInsert(Product p) {
		int result = new ProductDAO().insertProduct(p);
		
		if (result > 0) {
			System.out.println(result + "행이 추가되었습니다.");
			new ProductView().displayMenu();
		}
		else {
			System.out.println("새 상품 등록 실패!!");
			new ProductView().error();
		}
		
	}

	public ArrayList<Product> selectList() {
		return new ProductDAO().selectList();
	}

	public Product selectProduct(String pid) {
		return new ProductDAO().selectOne(pid);
	}

	public void updateProduct(Product p) {
		int result = new ProductDAO().updateProduct(p.getProduct_Id(), p.getPrice());
		
		if (result > 0) {
			//성공
			System.out.println(result + "행이 수정되었습니다.");
			new ProductView().displayMenu();
		}
		else {
			//실패
			System.out.println("상품 수정 실패!!");
			new ProductView().error();
		}
		
	}

	public void deleteProduct(String pid) {
		int result = new ProductDAO().deleteProduct(pid);
		
		if (result > 0) {
			//성공
			System.out.println(result + "행이 삭제되었습니다.");
			new ProductView().displayMenu();
		}
		else {
			//실패
			System.out.println("상품 삭제 실패!!");
			new ProductView().error();
		}
		
	}

}
