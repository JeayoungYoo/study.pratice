package udp.practice;

import java.net.*;

public class UDPSpamReciever {

	public static void main(String[] args) {
		// ���ѷ����� ���� �� ��Ŷ ������ ��� �޾� ����ϴ� Ŭ���̾�Ʈ Ŭ����
		try {
			DatagramSocket reciever = new DatagramSocket(4000);
			DatagramPacket packet = null;
			
			byte[] recieveMessage = new byte[1024];
			
			while(true){
				packet = new DatagramPacket(recieveMessage, 
						recieveMessage.length);
				reciever.receive(packet);
				System.out.println(packet.getAddress().getHostAddress() + 
						" �� ���� ���� : " + new String(packet.getData()));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
