package com.test3;

public class StudentTest {

   public static void main(String[] args) {
      Student studentArray[] = new Student[3];
      studentArray[0] = new Student("홍길동", 15, 170, 80);
      studentArray[1] = new Student("한사람", 13, 180, 70);
      studentArray[2] = new Student("임걱정", 16, 175, 65);

      double ageSum=0, heiSum=0, weiSum=0;
      int maxAge=0, minAge=0, maxHei=0, minHei=0, maxWei=0, minWei=0;

      System.out.println("이름\t나이\t신장\t몸무게");
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

      System.out.println("나이 평균: " + Math.round(ageSum/studentArray.length*1000)/1000.0);
      System.out.println("신장 평균: " + Math.round(heiSum/studentArray.length*1000)/1000.0);
      System.out.println("몸무게 평균: " + Math.round(weiSum/studentArray.length*1000)/1000.0);

      System.out.println("나이가 가장 많은 학생: " + studentArray[maxAge].getName());
      System.out.println("나이가 가장 적은 학생: " + studentArray[minAge].getName());

      System.out.println("신장이 가장 큰 학생: " + studentArray[maxHei].getName());
      System.out.println("신장이 가장 작은 학생: " + studentArray[minHei].getName());

      System.out.println("몸무게가 가장 많이 나가는 학생: " + studentArray[maxWei].getName());
      System.out.println("몸무게가 가장 적게 나가는 학생: " + studentArray[minWei].getName());
   }

}