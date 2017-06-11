package school;

public class StudentTest {

	public static void main(String[] args) {
		Student studentArray[] = new Student[3];
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);
		
		double avgAge=0, avgHeight=0, avgWeight=0;
		System.out.println("이름\t나이\t신장\t몸무게");
		for (Student ss : studentArray) {
			System.out.println(ss);
			avgAge += ss.getAge();
			avgHeight += ss.getHeight();
			avgWeight += ss.getWeight();
		}
		System.out.println();
		System.out.println("나이의 평균: " + Math.round(avgAge/studentArray.length*100)/100.0);
		System.out.println("신장의 평균: " + Math.round(avgHeight/studentArray.length*100)/100.0);
		System.out.println("몸무게의 평균: " + Math.round(avgWeight/studentArray.length*100)/100.0);


	}

}
