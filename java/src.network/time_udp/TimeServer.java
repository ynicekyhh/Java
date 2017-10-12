package time_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
	private static final int PORT = 6000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			// 1. Socket 생성
			socket = new DatagramSocket(PORT);

			while(true) {
				// 2. 수신 패킷 생성
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);

				// 3. 데이터 수신 대기
				socket.receive(receivePacket);	//block

				// 4. 데이터 수신
				String message = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

				System.out.println("[SERVER] from client : " + message);
				
				if("".equals(message)) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
					String data = format.format(new Date());
					
					//5. 데이터 송신
					byte[] sendData = data.getBytes("UTF-8");
					DatagramPacket datagramPacket =
							new DatagramPacket(
									sendData, 
									sendData.length, 
									receivePacket.getAddress(),
									receivePacket.getPort());
					socket.send(datagramPacket);
				}

			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}


	}

}
