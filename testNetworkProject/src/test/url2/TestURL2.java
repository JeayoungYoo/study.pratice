package test.url2;

import java.io.*;
import java.net.*;

public class TestURL2 {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			try {
				System.out.print("url �ּ� �Է� : ");
				System.out.println("(����� none �Է�)");
				String input = br.readLine().trim();
				if (br.readLine().equals("none")) {
					System.out.println("���α׷� ����");
					break;
				}

				URL url = new URL("http://" + input);

				System.out.println("�������� : " + url.getProtocol());
				System.out.println("��Ʈ��ȣ : " + url.getPort());
				System.out.println("ȣ��Ʈ�� : " + url.getHost());
				System.out.println("���ϰ�� : " + url.getFile());
				System.out.println("��ü��� : " + url.toExternalForm());
				System.out.println("������Ʈ�� : " + url.getQuery());

				InetAddress[] ips = InetAddress.getAllByName(url.getHost());
				System.out.println(input + " �� ���� ip ���� : " + ips.length);

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
