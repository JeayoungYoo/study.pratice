package tcp.server;

import java.io.*;
import java.net.*;

public class ChattServer {
	// ��������
	public static void main(String[] args) throws IOException {
		// TCP��� ������ ���α׷�
		// 1. ��Ʈ��ȣ ���ϱ�
		int port = 7777;

		// 2. ������ ���� ��ü �����
		ServerSocket server = new ServerSocket(port);

		// 3. Ŭ���̾�Ʈ�ʿ��� ���� ��û ���� ��ٸ�.
		while (true) {
			System.out.println("Ŭ���̾�Ʈ �� ��û�� ��ٸ��� �ֽ��ϴ�...");
			// 4. ���� ��û�� Ŭ���̾�Ʈ�� ��û�� ������
			// �ش� Ŭ���̾�Ʈ�� ������ ������ ������ ����
			Socket client = server.accept();

			// 5. �ش� Ŭ���̾�Ʈ�� ��/��� ��Ʈ���� ������
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();

			// ���� ������ ���� ������Ʈ�� ����
			// �������·� �ְ� �ް��� �� ���
			// ����Ʈ��Ʈ���� ���ڽ�Ʈ������ �ٲܼ��� ����
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);

			// 6. ������ �ְ� ����
			// �켱�� Ŭ���̾�Ʈ�� ���� �޼����� �о����
			String message = br.readLine();
			System.out.println(client.getInetAddress().getHostAddress() + "�� ���� �޼��� : " + message);

			// ������ Ȯ�� �޼����� ������
			pw.print("�ޱ� ����!");
			pw.flush();

			// 7. ��Ʈ�� �ݳ�
			pw.close();
			br.close();
			input.close();
			output.close();
		}

	}

}
