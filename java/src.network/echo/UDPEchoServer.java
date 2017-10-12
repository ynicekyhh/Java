package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static final int PORT = 6000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			//1. Socket 생성
			socket = new DatagramSocket( PORT );

			while(true) {

				//2. 수신 패킷 생성
				DatagramPacket receivePacket = new DatagramPacket( new byte[ BUFFER_SIZE], BUFFER_SIZE );
				
				/*
				 * 3. 데이터 수신 대기 
				 * UDP는 기본적으로 1:1 통신이 아니기 때문에 멀티 스레드 처리가 필요없으나, 
				 * 리시브 하는 쪽에서 어떤 처리 과정이 빠르게 필요하다면 스레드 모델이 필요할 수도 있다.
				 */
				socket.receive(receivePacket); //block

				//4. 데이터 수신
				String message = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

				System.out.println("[UDP Echo Server] received:" + message);

				//5. 데이터 송신
				byte[] sendData = message.getBytes( "UTF-8" );
				DatagramPacket sendPacket = 
						new DatagramPacket( 
								sendData, 
								sendData.length,
								receivePacket.getAddress(),
								receivePacket.getPort());	//오버로드가 되어 있어서, InetSocktAddress를 써도 괜찮음
				socket.send( sendPacket );
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if( socket != null && socket.isClosed() == false ) {
				socket.close();
			}
		}
	}

}
