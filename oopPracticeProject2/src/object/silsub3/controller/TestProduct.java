package object.silsub3.controller;

import object.silsub3.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		Product pd = new Product("ssgnote6", "�����ó�Ʈ6", "��⵵����", 960000, 10.0);
		Product pd1 = new Product("lgxnote5", "LG����Ʈ��5", "��⵵����", 780000, 0.7);
		Product pd2 = new Product("Ktnorm3", "KT�Ϲ���3", "����ð���", 25000, 0.3);
		
		pd.information();
		pd1.information();
		pd2.information();
		
		

	}

}
