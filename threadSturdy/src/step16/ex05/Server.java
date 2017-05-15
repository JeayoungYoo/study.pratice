package step16.ex05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/* Runnable �������̽��� �����Ͽ� Ŭ���̾�Ʈ ��û ó��
 * �ǽ�:
 * 1) main �޼����� �۾��� Server Ŭ������ �޼���� �����
 * 2) MyThread�� �ϴ� ���� Runnable �������̽� �������� ��ü�ϱ�
 */
public class Server  {
  static class EchoAgent implements Runnable {
    Socket socket;
    
    public EchoAgent(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      BufferedReader in = null;
      PrintStream out = null;
      
      try {
        System.out.println("Ŭ���̾�Ʈ�� �����.");
        
        in = new BufferedReader(
                new InputStreamReader(
                  socket.getInputStream()));
        
        out = new PrintStream(socket.getOutputStream()); 
        
        String message = null;
        
        while (true) {
          message = in.readLine();
          System.out.println(message);
          if (message.endsWith(":bye")) {
            out.println("�ȳ��� ������!");
            break;
          } 
          out.println(message);
        }
        
      } catch (Exception e) {
        e.printStackTrace();
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  public void service() {
    try (ServerSocket ss = new ServerSocket(8888);) 
    {
        System.out.println("Ŭ���̾�Ʈ�� ���� ��ٸ�...");
        Socket socket = null;
        
        while (true) {
          socket = ss.accept();
          new Thread(new EchoAgent(socket)).start();
          
          /*
          EchoAgent agent = new EchoAgent(socket);
          Thread t = new Thread(agent);
          t.start();
          */
        }
        
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    Server server = new Server();
    server.service();
  }
}
