package game.baseball;

import java.net.*;
import java.io.*;

public class ClientTest {

	public static void main(String[] args) {

		Socket socket = null;
		try {
	
			socket = new Socket("localhost", 9000); 
			System.out.println("���� ���� �Ϸ�");
		
			InputStream is = socket.getInputStream(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = socket.getOutputStream(); 
			PrintWriter pw = new PrintWriter(os);
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		
			String str = "", str1 = "";
			System.out.println("���� 4���� �Է��ϼ���");
			while (true) {
				
				System.out.print("����4���Է� : ");

				str = stdin.readLine();

				if (str.length() < 4) {

					System.out.println("�ٽ� �Է��ϼ���\n����4���Է� : ");
					str = stdin.readLine();
				}
				
				pw.println(str);
				pw.flush();

				str1 = br.readLine();

				
				System.out.println("����>>" + str1);

				if (str1.subSequence(6, 8).charAt(0) != 'F') {
					break;
				}

			}

			System.out.println("���� ����!!");

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}