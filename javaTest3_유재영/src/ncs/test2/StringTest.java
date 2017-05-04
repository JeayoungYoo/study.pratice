package ncs.test2;

public class StringTest {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double date[] = new double[5];
		double sum = 0;
		
		String[] st = str.split(",");
		
		for(int i=0; i<st.length; i++){
			date[i] = Double.parseDouble(st[i]);
			sum += date[i];
		}
		System.out.printf("ÇÕ°è : %.3f",sum);
		System.out.printf("\nÆò±Õ : %.3f",sum/st.length);
	}

}
