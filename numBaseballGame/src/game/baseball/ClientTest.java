package game.baseball;

import java.net.*;
import java.io.*;

public class ClientTest {

	public static void main(String[] args) {

		Socket socket = null;
		try {
	
			socket = new Socket("localhost", 9000); 
			System.out.println("서버 접속 완료");
		
			InputStream is = socket.getInputStream(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = socket.getOutputStream(); 
			PrintWriter pw = new PrintWriter(os);
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		
			String str = "", str1 = "";
			System.out.println("숫자 4개를 입력하세요");
			while (true) {
				
				System.out.print("숫자4개입력 : ");

				str = stdin.readLine();

				if (str.length() < 4) {

					System.out.println("다시 입력하세요\n숫자4개입력 : ");
					str = stdin.readLine();
				}
				
				pw.println(str);
				pw.flush();

				str1 = br.readLine();

				
				System.out.println("서버>>" + str1);

				if (str1.subSequence(6, 8).charAt(0) != 'F') {
					break;
				}

			}

			System.out.println("게임 종료!!");

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