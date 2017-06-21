package product.controller;

import java.util.ArrayList;
import product.model.dao.ProductDAO;
import product.model.vo.Product;
import product.view.ProductView;

public class ProductController {

	public void productInsert(Product p) {
		int result = new ProductDAO().insertProduct(p);
		
		if (result > 0) {
			System.out.println(result + "���� �߰��Ǿ����ϴ�.");
			new ProductView().displayMenu();
		}
		else {
			System.out.println("�� ��ǰ ��� ����!!");
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
			//����
			System.out.println(result + "���� �����Ǿ����ϴ�.");
			new ProductView().displayMenu();
		}
		else {
			//����
			System.out.println("��ǰ ���� ����!!");
			new ProductView().error();
		}
		
	}

	public void deleteProduct(String pid) {
		int result = new ProductDAO().deleteProduct(pid);
		
		if (result > 0) {
			//����
			System.out.println(result + "���� �����Ǿ����ϴ�.");
			new ProductView().displayMenu();
		}
		else {
			//����
			System.out.println("��ǰ ���� ����!!");
			new ProductView().error();
		}
		
	}

}
