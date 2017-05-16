package udp.practice;

import java.net.*;

public class UDPSpamReciever {

	public static void main(String[] args) {
		// 무한루프로 전송 온 패킷 정보를 계속 받아 출력하는 클라이언트 클래스
		try {
			DatagramSocket reciever = new DatagramSocket(4000);
			DatagramPacket packet = null;
			
			byte[] recieveMessage = new byte[1024];
			
			while(true){
				packet = new DatagramPacket(recieveMessage, 
						recieveMessage.length);
				reciever.receive(packet);
				System.out.println(packet.getAddress().getHostAddress() + 
						" 가 보낸 스팸 : " + new String(packet.getData()));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
