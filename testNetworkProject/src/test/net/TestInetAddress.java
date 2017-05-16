package test.net;

import java.net.*;

public class TestInetAddress {

	public static void main(String[] args) {
		// InetAddress test
		try {
			InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
			System.out.println("네이버 서버 ip 갯수 : " + ips.length);
			
			for(int i= 0;i<ips.length;i++){
				System.out.println(ips[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
