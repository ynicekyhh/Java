package echo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			//1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			//2. 바인딩( Binding ) - 주소를 소켓에 붙이는 것
			InetAddress inetAddress = InetAddress.getLocalHost();
			String localhostAddress = inetAddress.getHostAddress();

			serverSocket.bind( new InetSocketAddress( localhostAddress, SERVER_PORT ) );
			consoleLog( "binding " + localhostAddress + ":" + SERVER_PORT );

			//서버는 절대 죽지 않음. -> 서버는 프로세스 찾아서 kill로 죽이는 것이고, 외부에서 어떤 조건으로 죽이지 않게 한다.
			while( true ) {
				//3. 연결 요청 기다림( accept ) - socket의 inputStream, outputStream을 사용하게 됨
				Socket socket = serverSocket.accept();	 //read/accept할 때 프로그램이 blocking상태임 -> 클라이언트가 connect하면 blocking이 풀림
				new EchoServerReceiveThread( socket ).start();
			}

		} catch ( SocketException e ) {
			// 상대편이 소켓을 정상적으로 닫지 않고 종료한 경우
			consoleLog( "sudden closed by client" );
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( serverSocket != null && serverSocket.isClosed() == false ) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void consoleLog( String log ) {
		System.out.println( "[server:" + Thread.currentThread().getId() + "]" + log);
	}

}
