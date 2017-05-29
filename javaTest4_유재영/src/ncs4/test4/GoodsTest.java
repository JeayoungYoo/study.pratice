package ncs4.test4;

import java.io.*;

public class GoodsTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		Goods goods = new Goods();
		
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("다음 항목의 값을 입력하시오.");
		try {
			System.out.print("상품명 : ");
			goods.setName(br.readLine());
			System.out.print("가격 : ");
			goods.setPrice(Integer.parseInt(br.readLine()));
			System.out.print("수량 : ");
			goods.setQuantity(Integer.parseInt(br.readLine()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("입력된 결과는 다음과 같습니다.");
		System.out.println(goods);
		System.out.println("총 구매 가격 : " + goods.getPrice()*goods.getQuantity() + " 원");

	}

}
