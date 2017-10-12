package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int SERVER_PORT = 6000;
	public static List<PrintWriter> writerpool = new ArrayList<PrintWriter>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null; 

		try {
			//1. 소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 바인드
			String localHostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(localHostAddress, SERVER_PORT));
			consoleLog("binding success! " + localHostAddress + ":" + SERVER_PORT);
			
			//3. 연결요청
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, writerpool).start();
			}
			
		} catch (IOException e) {
			consoleLog("sudden closed by client");
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				consoleLog("server closing error!! >>>> " + e);
			}
		}
	}
	
	public static void consoleLog(String log) {
		System.out.println( "[server: " + Thread.currentThread().getId() + "] " + log);
	}

}
