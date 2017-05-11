package practice1;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		TreeSet tset = new TreeSet();
		Random r = new Random();
			
		while(tset.size() !=6){
			tset.add(r.nextInt(45)+1);
		}
		
		Object[] objArr = tset.toArray();
		int[] arrint = new int[tset.size()];
		for (int i=0; i<tset.size(); i++){
			arrint[i]=(int) objArr[i];
			System.out.print(arrint[i] + ", ");
		}
		

	}

}
