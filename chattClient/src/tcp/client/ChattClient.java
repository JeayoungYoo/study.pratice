package tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChattClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TCP ��� Ŭ���̾�Ʈ �� ���α׷�

		// 1. ������ ���� ��Ʈ��ȣ�� ������ IP�ּҰ� �ʿ���
		int port = 9000;
		// String serverIP = InetAddress.getLocalHost().getHostAddress();
		String serverIP = "192.168.20.34";

		// 2. Ŭ���̾�Ʈ�� �ڽ��� ���� ��ü ������ (������ �ּҿ� ��Ʈ��ȣ �ʿ���)
		// new ��(��ü ����)�� ���ÿ� ������ �ڵ� ���� ��û��
		Socket socket;
		try {
			socket = new Socket(serverIP, port);
			if (socket != null) {
				// 3. �ش� ������ Ŭ���̾�Ʈ ���� ��/��� ��Ʈ�� ������
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());

				String message = null;
				String result = null;

				do {
					System.out.print("�Է�>");
					message = sc.nextLine();
					System.out.println("���翵 >" + message);
					pw.println(message);
					pw.flush();

					result = br.readLine();
					System.out.println(result);

				} while (!message.equals("quit"));

				// 4. �޼��� �����ϰ� ��� ����

				System.out.println(br.readLine());
				// 5. ��Ʈ�� �ݳ�
				pw.close();
				br.close();
			}
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
