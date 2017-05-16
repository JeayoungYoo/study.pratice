package test.url2;

import java.io.*;
import java.net.*;

public class TestURL2 {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			try {
				System.out.print("url 주소 입력 : ");
				System.out.println("(종료시 none 입력)");
				String input = br.readLine().trim();
				if (br.readLine().equals("none")) {
					System.out.println("프로그램 종료");
					break;
				}

				URL url = new URL("http://" + input);

				System.out.println("프로토콜 : " + url.getProtocol());
				System.out.println("포트번호 : " + url.getPort());
				System.out.println("호스트명 : " + url.getHost());
				System.out.println("파일경로 : " + url.getFile());
				System.out.println("전체경로 : " + url.toExternalForm());
				System.out.println("쿼리스트링 : " + url.getQuery());

				InetAddress[] ips = InetAddress.getAllByName(url.getHost());
				System.out.println(input + " 된 서버 ip 갯수 : " + ips.length);

				for (InetAddress ip : ips)
					System.out.println(ip.getHostAddress());
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (true);
	}
}
