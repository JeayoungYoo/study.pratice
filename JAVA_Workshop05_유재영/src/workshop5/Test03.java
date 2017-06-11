package workshop5;

public class Test03 {

	public static void main(String[] args) {
		int[][] arr2 = {
				{20, 30, 10},
				{50, 40, 60},
				{80, 80, 90}
		};
		int[] arr1 = new int[arr2.length*arr2[0].length];
		int k=0;
		for (int i=0; i<arr2.length; i++){
			for (int j=0; j<arr2[i].length; j++){
				arr1[k]=arr2[i][j];
				k++;
			}
		}
		
		for (int i=arr1.length-1; i>=0; i--) {
			System.out.print(arr1[i]+" ");
		}

	}

}
