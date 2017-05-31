package ncs.test8;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {

	public static void main(String[] args) {
		String hostName = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("ȣ��Ʈ�� : ");
		hostName = sc.next();
		try {
			InetAddress[] ips = InetAddress.getAllByName(hostName);
			System.out.println(hostName + "�� " + ips.length + "���� IP�ּҸ� ������ �ֽ��ϴ�.");

			for (int i = 0; i < ips.length; i++) {
				System.out.println(i + 1 + "�� IP = " + ips[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
