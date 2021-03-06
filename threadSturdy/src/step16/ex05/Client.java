package step16.ex05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    
    try (
      Socket socket = new Socket("192.168.20.34", 9000);
      Scanner scanner = new Scanner(System.in);
      BufferedReader in = new BufferedReader(new InputStreamReader(
                               socket.getInputStream()));
      PrintStream out = new PrintStream(socket.getOutputStream());
    ) {
      String message = null;
      String result = null;
      do {
        System.out.print("입력>");
        message = scanner.nextLine();
        out.println("안재성:" + message);
        result = in.readLine();
        System.out.println(result);
      } while(!message.equals("bye"));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}