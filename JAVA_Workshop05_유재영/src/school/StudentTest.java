package school;

public class StudentTest {

	public static void main(String[] args) {
		Student studentArray[] = new Student[3];
		studentArray[0] = new Student("ȫ�浿", 15, 171, 81);
		studentArray[1] = new Student("�ѻ��", 13, 183, 72);
		studentArray[2] = new Student("�Ӱ���", 16, 175, 65);
		
		double avgAge=0, avgHeight=0, avgWeight=0;
		System.out.println("�̸�\t����\t����\t������");
		for (Student ss : studentArray) {
			System.out.println(ss);
			avgAge += ss.getAge();
			avgHeight += ss.getHeight();
			avgWeight += ss.getWeight();
		}
		System.out.println();
		System.out.println("������ ���: " + Math.round(avgAge/studentArray.length*100)/100.0);
		System.out.println("������ ���: " + Math.round(avgHeight/studentArray.length*100)/100.0);
		System.out.println("�������� ���: " + Math.round(avgWeight/studentArray.length*100)/100.0);


	}

}
