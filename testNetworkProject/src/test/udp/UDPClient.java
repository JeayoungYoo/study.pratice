package test.udp;

import java.io.IOException;
import java.net.*;


public class UDPClient {

	public static void main(String[] args) throws IOException {
		byte[] recieveMessage = new byte[1024];
		
		DatagramSocket uclient = new DatagramSocket(9000);
		DatagramPacket packet = new DatagramPacket(recieveMessage, 1024);
		
		uclient.receive(packet);
		
		System.out.println("받은 메세지 : " + new String(recieveMessage));
		
		uclient.close();

	}

}
