package com.test3;

public class StudentTest {

   public static void main(String[] args) {
      Student studentArray[] = new Student[3];
      studentArray[0] = new Student("ȫ�浿", 15, 170, 80);
      studentArray[1] = new Student("�ѻ��", 13, 180, 70);
      studentArray[2] = new Student("�Ӱ���", 16, 175, 65);

      double ageSum=0, heiSum=0, weiSum=0;
      int maxAge=0, minAge=0, maxHei=0, minHei=0, maxWei=0, minWei=0;

      System.out.println("�̸�\t����\t����\t������");
      for(int i=0; i<studentArray.length; i++) {
         System.out.println(studentArray[i].studentInfo());
         ageSum += studentArray[i].getAge();
         heiSum += studentArray[i].getHeight();
         weiSum += studentArray[i].getWeight();

         if (studentArray[i].getAge() > studentArray[maxAge].getAge()) {
            maxAge=i;
         }
         else if (studentArray[i].getAge() < studentArray[minAge].getAge()) {
            minAge = i;
         }

         if(studentArray[i].getHeight()>studentArray[maxHei].getHeight()) {
            maxHei=i;
         } else if (studentArray[i].getHeight()<studentArray[minHei].getHeight()) {
            minHei=i;
         }

         if(studentArray[i].getWeight()>studentArray[maxWei].getWeight()) {
            maxWei=i;
         } else if(studentArray[i].getWeight()<studentArray[minWei].getWeight()) {
            minWei=i;
         }
      }

      System.out.println("���� ���: " + Math.round(ageSum/studentArray.length*1000)/1000.0);
      System.out.println("���� ���: " + Math.round(heiSum/studentArray.length*1000)/1000.0);
      System.out.println("������ ���: " + Math.round(weiSum/studentArray.length*1000)/1000.0);

      System.out.println("���̰� ���� ���� �л�: " + studentArray[maxAge].getName());
      System.out.println("���̰� ���� ���� �л�: " + studentArray[minAge].getName());

      System.out.println("������ ���� ū �л�: " + studentArray[maxHei].getName());
      System.out.println("������ ���� ���� �л�: " + studentArray[minHei].getName());

      System.out.println("�����԰� ���� ���� ������ �л�: " + studentArray[maxWei].getName());
      System.out.println("�����԰� ���� ���� ������ �л�: " + studentArray[minWei].getName());
   }

}