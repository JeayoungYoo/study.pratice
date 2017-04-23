package test.sort;

public class TestSelectSort {
	
	public void swap(int[] ar, int i, int j){
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public void selectSortDescending(int[] ar){
		for (int i=0; i<ar.length-1; i++){
			for(int j=i+1; j<ar.length; j++)
				if(ar[i]<ar[j])
					swap(ar, i, j);
		}
		
	}
	public void selectSortAsending(int[] ar){
		for (int i=0; i<ar.length-1; i++){
			for(int j=i+1; j<ar.length; j++)
				if(ar[i]>ar[j])
					swap(ar, i, j);
		}
		
	}
	
	public void bubleSort(int[] ar){
		for(int i = 0; i<ar.length-1; i++){
			for(int j=0; j<ar.length-2; j++){
				if (ar[j]>ar[j+1]){
					swap(ar, j, j+1);
				}
			}
		}
	}
	
	public void printArray(int[] ar){
		for(int i=0; i< ar.length; i++)
			System.out.print("["+ar[i]+"]");
		System.out.println();
	}
	

	public static void main(String[] args) {
		// select sort test
		int[] ar = {1,2,6,3,9,8};
		TestSelectSort test = new TestSelectSort();
		test.printArray(ar);
		test.bubleSort(ar);
		test.printArray(ar);
//		test.selectSortAsending(ar);
//		test.printArray(ar);
//		test.selectSortDescending(ar);
//		test.printArray(ar);
//		

	}

}
