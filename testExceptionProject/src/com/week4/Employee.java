package com.week4;

public class Employee implements Comparable<Employee>{
   private String name;
   private int age;
   private double pay;
   private double tax;
   
   public Employee(){}
   
   public Employee(String name, int age, double pay, double tax){
      name = this.name;
      age = this.age;
      pay = this.pay;
      tax = this.tax;
   }
   
   

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public double getPay() {
      return pay;
   }

   public void setPay(double pay) {
      this.pay = pay;
   }

   public double getTax() {
      return tax;
   }

   public void setTax(double tax) {
      this.tax = tax;
   }

   @Override
   public String toString() {
      return "Employee [name=" + name + ", age=" + age + ", pay=" + pay + ", tax=" + tax + "]";
   }

   @Override
   public int compareTo(Employee o) {
      return name.compareTo(o.getName());
   }
   
}