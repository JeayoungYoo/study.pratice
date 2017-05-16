package net.silsub2.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws UnknownHostException {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("호스트명 (종료: none) : ");
			String host = sc.nextLine();
			if (host.equals("none") != true) {
				InetAddress[] ips = InetAddress.getAllByName(host);
				System.out.println(host + "가 가진 ip는" + ips.length + "개 입니다.");
				for (InetAddress ip : ips)
					System.out.println(ip.getHostAddress());
			} else
				break;
		} while (true);
	}
}