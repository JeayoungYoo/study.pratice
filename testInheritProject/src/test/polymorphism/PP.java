package test.polymorphism;

public class PP {
	public PP(){}
	
	public void display(){
		System.out.println("PP가 가진 메소드 구동...");
	}
	//method overloading
/*	public static void testPP(A ob){}
	
	public static void testPP(B ob){}

	public static void testPP(C ob){}*/
	public static void testPP(PP ob){
		ob.display();
		
		if(ob instanceof A)
			((A)ob).aa();
		else if(ob instanceof B)
			((B)ob).bb();
		else if(ob instanceof C)
			((C)ob).cc();
		
	}
}
