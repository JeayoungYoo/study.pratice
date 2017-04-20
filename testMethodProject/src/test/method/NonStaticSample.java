package test.method;

import java.util.Random;

public class NonStaticSample {
	Random r = new Random();
	public NonStaticSample(){}
	
	public void printLottoNumbers(){
		
		int [] rnum = new int[6];
		
		for (int i=0;i<rnum.length;i++){
			rnum[i]=(r.nextInt(45)+1);
			System.out.println(i+1 + "¹øÂ°" + rnum[i]);
		}
		
	}
	
	public void outputChar(int count, char ch){
		for (int i=0; i<count; i++)
			System.out.print(ch + ",\t");
	}
	
	public char alphabette(){
		int alpha = r.nextInt(57)+66;
		return (char)alpha;
	}
	
	public String mySubString(String s, int beginIndex, int endIndex){
		String dsts=s.substring(beginIndex, endIndex);
		
		return dsts;
	}
		
}
