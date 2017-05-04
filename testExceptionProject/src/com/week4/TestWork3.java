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
            System.out.print("사원명 입력 : ");
            emp.setName(br.readLine());
            System.out.print("나이 입력 : ");
            emp.setAge(Integer.parseInt(br.readLine()));
            System.out.print("봉급 입력 : ");
            emp.setPay(Long.parseLong(br.readLine()));
            System.out.print("세금 입력 : ");
            emp.setTax(Double.parseDouble(br.readLine()));
            
            emp.setPay(emp.getPay() - (emp.getPay() * (int) Math.round(emp.getTax() * 100) / 100.0));
            
            System.out.println("사원명 : " + emp.getName() + ", 나이 : " + emp.getAge() + ", 급여 : "
                  + emp.getPay() + ", 세율 : " + (int) Math.round(emp.getTax() * 100) / 100.0);
            listA.add(emp);
         } catch (IOException e) {
            e.printStackTrace();
         }

         

         System.out.print("추가로 입력하시겠습니까 ?");
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