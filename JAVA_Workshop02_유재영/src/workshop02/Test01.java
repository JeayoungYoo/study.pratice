package workshop02;

public class Test01 {

	public static void main(String[] args) {
		int min=Integer.parseInt(args[0]), max=Integer.parseInt(args[0]);
		for (int i=0; i<args.length; i++) {
			if (Integer.parseInt(args[i])>max) 
				max = Integer.parseInt(args[i]);
			if (Integer.parseInt(args[i])<min)
				min = Integer.parseInt(args[i]);
		}
		System.out.println("입력값: " + args[0] + args[1] + args[2]);
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);

	}

}
