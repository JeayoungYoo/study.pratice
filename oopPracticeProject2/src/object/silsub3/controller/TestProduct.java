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
		
		System.out.println("��ǰ�� : " + pd.getProductName());
		System.out.println("�ΰ��� ���� ���� : " + (pd.getPrice()+(pd.getPrice()*pd.getTex())));
		
		System.out.println("��ǰ�� : " + pd1.getProductName());
		System.out.println("�ΰ��� ���� ���� : " + (pd1.getPrice()+(pd1.getPrice()*pd1.getTex())));
		
		System.out.println("��ǰ�� : " + pd2.getProductName());
		System.out.println("�ΰ��� ���� ���� : " + (pd2.getPrice()+(pd2.getPrice()*pd2.getTex())));

	}

}
