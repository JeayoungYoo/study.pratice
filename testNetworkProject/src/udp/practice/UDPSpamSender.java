package udp.practice;

import java.net.*;
import java.util.*;

public class UDPSpamSender {

	public static void main(String[] args) {
		// �������� 10���� ip �� ���� �޼��� �����ϴ� ���� Ŭ����
		String ip = null;
		

		DatagramSocket sender = null;
		DatagramPacket packet = null;


		try {
			sender = new DatagramSocket(4000);
			String spam = InetAddress.getLocalHost().getHostName() + 
					"���� �ֹ��� �ܿ���!  ��ġ��ġ��~����";
			byte[] spamMessage = spam.getBytes();
			
			for(int i = 0; i < 11; i++){
				ip = "192.168.20." + (new Random().nextInt(40) + 34);
				
				packet = new DatagramPacket(spamMessage, 0, spamMessage.length, InetAddress.getByName(ip),	4000);
				
				sender.send(packet);
				System.out.println(ip + "�� ����...");
			}
			sender.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
