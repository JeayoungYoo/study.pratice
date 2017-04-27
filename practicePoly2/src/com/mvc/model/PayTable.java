package com.mvc.model;

import java.util.Scanner;

import com.mvc.view.Output;

public class PayTable extends Salary implements Calculate, Output {
	
	public PayTable(){}
	
	public PayTable(String name, long pay, int family, int overtime){
		super(name, pay, family, overtime);
	}
	

	

	@Override
	public void calc() {
		if (super.getFamily() < 3)
			super.setFamilyP(super.getFamily()*20000);
		else
			super.setFamilyP(60000);
		
		super.setOvertimeP(super.getOvertime()*5000);
		super.setTax((long) (super.getPay()*0.1));
		super.setIncenP((long) (super.getIncentive()*super.getPay()));
		super.setTotalPay(super.getPay()+super.getFamilyP()+super.getIncenP()+super.getOvertimeP()-super.getTax());
		
	}

	@Override
	public void out() {
		System.out.println(super.getName()+"\t"+super.getPay()+"\t"+super.getFamily()+"\t"+super.getFamilyP()+"\t"+super.getOvertime()+"\t"+super.getOvertimeP()+"\t"+super.getTax()+"\t"+super.getIncentive()+"\t"+super.getIncenP()+"\t"+super.getTotalPay());
	}

}
