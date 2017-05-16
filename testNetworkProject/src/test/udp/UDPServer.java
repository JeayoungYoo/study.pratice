package test.udp;

import java.io.IOException;
import java.net.*;

import java.util.*;


public class UDPServer {
	
	public static void main(String[] args) throws IOException {
		
		int port = 8000;
		
			DatagramSocket dsocket = new DatagramSocket(port);
			InetAddress iadd = InetAddress.getByName("192.168.20.34");
			
			String input = "½ºÆÔ";
			byte[] a = input.getBytes();
			
			DatagramPacket packet = new DatagramPacket(a, 0, a.length, iadd, port);
			
			dsocket.send(packet);
			dsocket.close();
		
		}

	}


