package udp.practice;

import java.net.*;
import java.util.*;

public class UDPSpamSender {

	public static void main(String[] args) {
		// 무작위로 10개의 ip 에 스팸 메세지 전송하는 서버 클래스
		String ip = null;
		

		DatagramSocket sender = null;
		DatagramPacket packet = null;


		try {
			sender = new DatagramSocket(4000);
			String spam = InetAddress.getLocalHost().getHostName() + 
					"요기요 주문을 외워봐!  피치피치피~보도";
			byte[] spamMessage = spam.getBytes();
			
			for(int i = 0; i < 11; i++){
				ip = "192.168.20." + (new Random().nextInt(40) + 34);
				
				packet = new DatagramPacket(spamMessage, 0, spamMessage.length, InetAddress.getByName(ip),	4000);
				
				sender.send(packet);
				System.out.println(ip + "로 보냄...");
			}
			sender.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
