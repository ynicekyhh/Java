package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	
	public EchoServerReceiveThread( Socket socket ) {
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		//4. 연결 성공
		InetSocketAddress remoteSocketAddress = 
				(InetSocketAddress)socket.getRemoteSocketAddress();	//InetSocketAddress는 InetAddress의 자식이다.
		int remoteHostPort = remoteSocketAddress.getPort();	//포트 받음
		String remoteHostAddress = remoteSocketAddress.getAddress().getHostAddress();	//getAddress는 InetAddress가 리턴됨
		consoleLog( "connected from " + remoteHostAddress + ":" + remoteHostPort );

		try {
			//5. I/O Stream 받아오기
			BufferedReader br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "UTF-8" ) );
			//PrintWriter는 \n(개행)을 붙임, Auto flush를 "true"로 설정하는 것에 주의!(개행이 왔을때 자동으로 flush발생하게함)
			PrintWriter pw = new PrintWriter( new OutputStreamWriter( socket.getOutputStream(), "UTF-8" ), true );
			

			while( true ) {
				//6. 데이터 읽기 (read)
				String message = br.readLine();

				if( message == null ) {	//정상종료
					consoleLog( "disconnection by client" );
					break;	//clinet가 telnet 연결 끊을 시
				}

				consoleLog( "received:" + message );
				
				//7. 데이터 쓰기 (write)
				pw.println( message );
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
	}
	
	private void consoleLog( String log ) {
		System.out.println( "[server:" + getId() + "]" + log);
	}
}
