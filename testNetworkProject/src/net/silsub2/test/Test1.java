package net.silsub2.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws UnknownHostException {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("ȣ��Ʈ�� (����: none) : ");
			String host = sc.nextLine();
			if (host.equals("none") != true) {
				InetAddress[] ips = InetAddress.getAllByName(host);
				System.out.println(host + "�� ���� ip��" + ips.length + "�� �Դϴ�.");
				for (InetAddress ip : ips)
					System.out.println(ip.getHostAddress());
			} else
				break;
		} while (true);
	}
}