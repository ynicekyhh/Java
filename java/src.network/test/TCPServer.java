package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			//1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			//1-1. set option SO_REUSEADDR ( 종료 후 빨리 바인딩 하기 위함 )
			serverSocket.setReuseAddress(true);	//timeout 상태에 있으면 기다리지 않고 빨리 처리함
			

			//2. 바인딩( Binding ) - 주소를 소켓에 붙이는 것
			InetAddress inetAddress = InetAddress.getLocalHost();
			String localhostAddress = inetAddress.getHostAddress();

			serverSocket.bind( new InetSocketAddress( localhostAddress, SERVER_PORT ) );
			System.out.println( "[server] binding " + localhostAddress + ":" + SERVER_PORT );

			//3. 연결 요청 기다림( accept ) - socket의 inputStream, outputStream을 사용하게 됨
			Socket socket = serverSocket.accept();	 //read/accept할 때 프로그램이 blocking상태임 -> 클라이언트가 connect하면 blocking이 풀림

			//4. 연결 성공
			InetSocketAddress remoteSocketAddress = 
					(InetSocketAddress)socket.getRemoteSocketAddress();	//InetSocketAddress는 InetAddress의 자식이다.
			int remoteHostPort = remoteSocketAddress.getPort();	//포트 받음
			String remoteHostAddress = remoteSocketAddress.getAddress().getHostAddress();	//getAddress는 InetAddress가 리턴됨
			System.out.println( "[server] connected from " + remoteHostAddress + ":" + remoteHostPort );

			try {
				//5. I/O Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				while( true ) {
					//6. 데이터 읽기 (read)
					byte[] buffer = new byte[256];
					int readByteCount = is.read( buffer );	//block

					if( readByteCount <= -1 ) {	//정상종료
						System.out.println( "[server] disconnection by client" );
						break;	//clinet가 telnet 연결 끊을 시
					}

					String data = new String( buffer, 0, readByteCount );	//buffer의 내용을 String으로 변경
					System.out.println( "[server] received:" + data );
					
					//7. 데이터 쓰기 (write)
					os.write( data.getBytes( "utf-8" ) );	//String이 utf-8로 인코딩 되어 있으니
				}

			} catch( IOException e ) {
				e.printStackTrace();
			} finally {
				try {
					if( socket != null && socket.isClosed() == false ) {
						socket.close();
					}
				} catch( IOException e ) {
					e.printStackTrace();
				}
			}
		} catch ( SocketException e ) {
			// 상대편이 소켓을 정상적으로 닫지 않고 종료한 경우
			System.out.println( "[server] sudden closed by client" );
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

}
