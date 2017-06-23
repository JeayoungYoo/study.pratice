package product.controller;

import java.util.ArrayList;

import product.model.dao.ProductDAO2;
import product.model.vo.Product;
import product.view.ProductView;

public class ProductController {

	public void productInsert(Product p) {
		int result = new ProductDAO2().insertProduct(p);
		
		if (result > 0) {
			System.out.println(result + "행이 추가되었습니다.");
			
		}
		else {
			System.out.println("새 상품 등록 실패!!");
//			new ProductView().error();
		}
		
	}

	public ArrayList<Product> selectList() {
		return new ProductDAO2().selectList();
	}

	public Product selectProduct(String pid) {
		return new ProductDAO2().selectId(pid);
	}

	public void updateProduct(Product p) {
		int result = new ProductDAO2().updateProduct(p.getProduct_Id(), p.getPrice());
		
		if (result > 0) {
			//성공
			System.out.println(result + "행이 수정되었습니다.");
			
		}
		else {
			//실패
			System.out.println("상품 수정 실패!!");
//			new ProductView().error();
		}
		
	}

	public void deleteProduct(String pid) {
		int result = new ProductDAO2().deleteProduct(pid);
		
		if (result > 0) {
			//성공
			System.out.println(result + "행이 삭제되었습니다.");
			
		}
		else {
			//실패
			System.out.println("상품 삭제 실패!!");
//			new ProductView().error();
		}
		
	}

	public Object[][] showTRow(ArrayList<Product> list) {
		Object[][] op = null;
		if (list != null) {
			op = new Object[list.size()][4];
			
			for (int i = 0; i <op.length; i++) {
				op[i][0] = list.get(i).getProduct_Id();
				op[i][1] = list.get(i).getP_name();
				op[i][2] = list.get(i).getPrice();
				op[i][3] = list.get(i).getDescription();
			}
		}
		
		return op;
	}

	public Product selectProductName(String pname) {
		return new ProductDAO2().selectName(pname);
		
	}

}
