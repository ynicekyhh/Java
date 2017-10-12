package time_udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TimeClient {
	private static final String SERVER_IP = "192.168.1.24";
	private static final int PORT = 6000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		
		try {
		//1. 소켓 생성
			socket = new DatagramSocket();
		
			//2. 메시지 생성
			String message = "";

			//3. 전송
			byte[] sendData = message.getBytes("UTF-8");
			socket.send(new DatagramPacket(
								sendData, 
								sendData.length, 
								new InetSocketAddress(SERVER_IP, PORT)));
			
			//4. 서버 메시지 수신
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			socket.receive(receivePacket);
			
			System.out.println("[client] from server message : " + new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8"));
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
