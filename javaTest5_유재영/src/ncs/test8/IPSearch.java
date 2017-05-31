package ncs.test8;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {

	public static void main(String[] args) {
		String hostName = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("호스트명 : ");
		hostName = sc.next();
		try {
			InetAddress[] ips = InetAddress.getAllByName(hostName);
			System.out.println(hostName + "는 " + ips.length + "개의 IP주소를 가지고 있습니다.");

			for (int i = 0; i < ips.length; i++) {
				System.out.println(i + 1 + "번 IP = " + ips[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
