package test.method;

import org.omg.Messaging.SyncScopeHelper;

public class Testmain {

	public static void main(String[] args) {
		NonStaticSample nss = new NonStaticSample();
		
//		nss.printLottoNumbers();
//		nss.outputChar(5, 'a');
//		System.out.println(nss.alphabette());
		System.out.println(nss.mySubString("java programing", 1,2));

	}

}
