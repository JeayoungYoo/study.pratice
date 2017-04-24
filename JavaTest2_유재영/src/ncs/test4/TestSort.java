package ncs.test4;

public class TestSort {

	public static void main(String[] args) {
		int[] a = new int[10];
		int b=0, temp;
		
		for (int i=0; i<a.length; i++){
			b= (int)((Math.random()*100)+1);
			if (b<51)
				a[i]=b+50;
			else
				a[i] = b;
				
			System.out.print(a[i]);
			if (i!=a.length-1)
				System.out.print(", ");
		}
		System.out.println();
		
		
		for (int i=0; i<a.length-1; i++){
			for (int j=i+1; j<a.length; j++ ){
				if (a[i]<a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		for (int i=0; i<a.length; i++){
			System.out.print(a[i]);
			if (i!=a.length-1)
				System.out.print(", ");
		}
		System.out.println();
	}

}
