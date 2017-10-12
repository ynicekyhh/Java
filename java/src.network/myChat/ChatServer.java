package myChat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int SERVER_PORT = 6000;
	static List<Writer> writerpool = new ArrayList<Writer>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. 소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 소켓 바인드 ( 로컬호스트주소, 포트번호 )
			String localhostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(localhostAddress, SERVER_PORT));
			
			while(true) {
				//3. 소켓 억셉트
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, writerpool).start();
			}
		} catch (IOException e) {
			consoleLog("클라이언트의 연결이 끊어졌습니다.");
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				consoleLog("서버 소켓 닫기 에러");
			}
		}
	}
	
	public static void consoleLog(String log) {
		System.out.println("[server:" + Thread.currentThread().getId() + "]" + log);
	}
}
