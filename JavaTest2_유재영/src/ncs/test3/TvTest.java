package ncs.test3;

public class TvTest {

	public static void main(String[] args) {
		int maxindex=0, minindex=0;
		Tv[] tv = new Tv[3];
		
		tv[0] = new Tv();
		tv[0].setName("INFINIA");
		tv[0].setPrice(1500000);
		tv[0].setDescription("LED TV");
		
		tv[1] = new Tv();
		tv[1].setName("XCANVAS");
		tv[1].setPrice(1000000);
		tv[1].setDescription("LCD TV");
		
		tv[2] = new Tv();
		tv[2].setName("CINEMA");
		tv[2].setPrice(2000000);
		tv[2].setDescription("3D TV");
		
		for (int i=0; i<tv.length; i++){
			System.out.println(tv[i].toString());
			if (tv[i].getPrice()>tv[maxindex].getPrice())
				maxindex = i;
			if (tv[i].getPrice()<tv[minindex].getPrice())
				minindex = i;
				
		}
		
		System.out.println("가격이 가장 비싼 제품 : " + tv[maxindex].getName());
		System.out.println("가격이 가장 저렴한 제품 : " + tv[minindex].getName());
	}

		
}
	
	


