package com.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestWork3 {

   public static void input() {
      List<Employee> listA = new ArrayList<Employee>();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Employee emp;
      int inp = 1;
      //Employee temp = new Employee();
      while (true) {

         try {
            emp = new Employee();
            System.out.print("����� �Է� : ");
            emp.setName(br.readLine());
            System.out.print("���� �Է� : ");
            emp.setAge(Integer.parseInt(br.readLine()));
            System.out.print("���� �Է� : ");
            emp.setPay(Long.parseLong(br.readLine()));
            System.out.print("���� �Է� : ");
            emp.setTax(Double.parseDouble(br.readLine()));
            
            emp.setPay(emp.getPay() - (emp.getPay() * (int) Math.round(emp.getTax() * 100) / 100.0));
            
            System.out.println("����� : " + emp.getName() + ", ���� : " + emp.getAge() + ", �޿� : "
                  + emp.getPay() + ", ���� : " + (int) Math.round(emp.getTax() * 100) / 100.0);
            listA.add(emp);
         } catch (IOException e) {
            e.printStackTrace();
         }

         

         System.out.print("�߰��� �Է��Ͻðڽ��ϱ� ?");
         try {
            if (br.readLine().toUpperCase().charAt(0) == 'N' || inp == 5) {
               break;
            } else
               inp++;
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      Collections.sort(listA);
      for (Employee e : listA) {
         System.out.println(e.toString());
      }
   }
   
   public static void main(String args[]) {
      input();

   }
}