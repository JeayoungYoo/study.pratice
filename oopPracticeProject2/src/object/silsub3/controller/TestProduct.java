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
		
		

	}

}
