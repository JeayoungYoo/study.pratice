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
		// TCP 통신 클라이언트 측 프로그램

		// 1. 서버가 정한 포트번호와 서버의 IP주소가 필요함
		int port = 9000;
		// String serverIP = InetAddress.getLocalHost().getHostAddress();
		String serverIP = "192.168.20.34";

		// 2. 클라이언트용 자신의 소켓 객체 생성함 (서버의 주소와 포트번호 필요함)
		// new 함(객체 생성)과 동시에 서버와 자동 연결 요청함
		Socket socket;
		try {
			socket = new Socket(serverIP, port);
			if (socket != null) {
				// 3. 해당 서버와 클라이언트 간의 입/출력 스트림 생성함
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());

				String message = null;
				String result = null;

				do {
					System.out.print("입력>");
					message = sc.nextLine();
					System.out.println("유재영 >" + message);
					pw.println(message);
					pw.flush();

					result = br.readLine();
					System.out.println(result);

				} while (!message.equals("quit"));

				// 4. 메세지 전송하고 결과 받음

				System.out.println(br.readLine());
				// 5. 스트림 반납
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
