package ncs4.test4;

import java.io.*;

public class GoodsTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		Goods goods = new Goods();
		
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���� �׸��� ���� �Է��Ͻÿ�.");
		try {
			System.out.print("��ǰ�� : ");
			goods.setName(br.readLine());
			System.out.print("���� : ");
			goods.setPrice(Integer.parseInt(br.readLine()));
			System.out.print("���� : ");
			goods.setQuantity(Integer.parseInt(br.readLine()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("�Էµ� ����� ������ �����ϴ�.");
		System.out.println(goods);
		System.out.println("�� ���� ���� : " + goods.getPrice()*goods.getQuantity() + " ��");

	}

}
