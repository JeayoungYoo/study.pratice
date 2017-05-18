package game.baseball;

import java.net.*;
import java.io.*;

public class ServerTest {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			
			serverSocket = new ServerSocket(9000);
			while (true) {
				
				System.out.println("서버 접속 대기 중");
				socket = serverSocket.accept();
				System.out.println("클라이언트 접속함");

				
				EchoThread echoThread = new EchoThread(socket);
				echoThread.start();
			}

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


class EchoThread extends Thread {

	Socket socket;

	InputStream is = null;
	BufferedReader br = null;

	OutputStream os = null;
	PrintWriter pw = null;

	EchoThread() {
	}

	EchoThread(Socket socket) {
		this.socket = socket;
		
		try {
			
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			os = socket.getOutputStream();
			pw = new PrintWriter(os);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void run() {

		GameLogic gl;

		try {
			String str = "";
			int cnt = 0;
			boolean val = false;
			char val1;
			String cnt1 = null;
			int x, y;

			gl = new GameLogic();
			gl.randomInt();

			while (!val) {


				str = br.readLine(); 

				gl.inputUserNumber1(str); 

				x = gl.getX();
				y = gl.getY();

				cnt = gl.getCount(); 
				if (cnt < 10)
					cnt1 = "0" + String.valueOf(cnt);
				else
					cnt1 = String.valueOf(cnt);

				val = gl.getValue(); 
				if (val)
					val1 = 'T';
				else
					val1 = 'F';

				System.out.println(
						Thread.currentThread() + " : " + str + " :" + x + "S " + y + "B" + " " + val1 + " " + cnt1);
				pw.println(x + "S " + y + "B" + " " + val1 + " " + cnt1); // 출력
				pw.flush();

			}

		} catch (IOException e) {
			System.out.println("데이타 송수신에러");
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void close() {
		try {
		
			is.close();
			br.close();
			os.close();
			pw.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("close에러");
			e.printStackTrace();
		}
	}
}