package object.silsub3.controller;

import object.silsub3.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		Product pd = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
		Product pd1 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
		Product pd2 = new Product("Ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);
		
		pd.information();
		pd1.information();
		pd2.information();
		
		pd.setPrice(1200000);
		pd1.setPrice(1200000);
		pd2.setPrice(1200000);
		
		pd.setTex(0.5);
		pd1.setTex(0.5);
		pd2.setTex(0.5);
		
		pd.information();
		pd1.information();
		pd2.information();
		
		pd.setTex(0.05);
		pd1.setTex(0.05);
		pd2.setTex(0.05);
		
		System.out.println("상품명 : " + pd.getProductName());
		System.out.println("부가세 포함 가격 : " + (pd.getPrice()+(pd.getPrice()*pd.getTex())));
		
		System.out.println("상품명 : " + pd1.getProductName());
		System.out.println("부가세 포함 가격 : " + (pd1.getPrice()+(pd1.getPrice()*pd1.getTex())));
		
		System.out.println("상품명 : " + pd2.getProductName());
		System.out.println("부가세 포함 가격 : " + (pd2.getPrice()+(pd2.getPrice()*pd2.getTex())));

	}

}
