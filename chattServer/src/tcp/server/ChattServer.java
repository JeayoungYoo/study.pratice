package tcp.server;

import java.io.*;
import java.net.*;

public class ChattServer {
	// 복습하자
	public static void main(String[] args) throws IOException {
		// TCP통신 서버측 프로그램
		// 1. 포트번호 정하기
		int port = 7777;

		// 2. 서버용 소켓 객체 만들기
		ServerSocket server = new ServerSocket(port);

		// 3. 클라이언트쪽에서 접속 요청 오길 기다림.
		while (true) {
			System.out.println("클라이언트 의 요청을 기다리고 있습니다...");
			// 4. 연결 요청한 클라이언트의 요청을 수락함
			// 해당 클라이언트의 정보를 저장할 소켓을 생성
			Socket client = server.accept();

			// 5. 해당 클라이언트와 입/출력 스트림을 생성함
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();

			// 성능 보완을 위해 보조스트름 연결
			// 문자형태로 주고 받고자 할 경우
			// 바이트스트림을 문자스트림으로 바꿀수도 있음
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);

			// 6. 데이터 주고 받음
			// 우선은 클라이언트가 보낸 메세지를 읽어들임
			String message = br.readLine();
			System.out.println(client.getInetAddress().getHostAddress() + "가 보낸 메세지 : " + message);

			// 서버가 확인 메세지를 전송함
			pw.print("받기 성공!");
			pw.flush();

			// 7. 스트림 반납
			pw.close();
			br.close();
			input.close();
			output.close();
		}

	}

}
