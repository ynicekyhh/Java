package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickName;
	private List<PrintWriter> writerpool;
	
	public ChatServerThread(Socket socket, List<PrintWriter> writerpool) {
		this.socket = socket;
		this.writerpool = writerpool;
	}
	
	@Override
	public void run() {
		//4. 요청성공확인
		InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		ChatServer.consoleLog("connected from " + 
					remoteSocketAddress.getAddress().getHostAddress() + 
					":" + remoteSocketAddress.getPort());
		
		try {
			//5. I/O스트림 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8) );
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
			
			String request;
			while(true) {
				//6. 읽기
				request = br.readLine();
				System.out.println(request);
				if(request == null) {
					ChatServer.consoleLog("disconnected from client");
					doQuit(pw);
					break;
				}
				
				//7. 채팅 프로토콜 분석
				String[] tokens = request.split(":");
				
				switch(tokens[0]) {
				case "join":					//ex) JOIN:둘리		=> 둘리님이 참여했습니다.
					doJoin(tokens[1], pw);
					break;
				case "message":					//ex) MESSAGE:하이~	=> 둘리:하이~
					doMessage(tokens[1]);
					break;
				case "quit":
					ChatServer.consoleLog("quitting..");
					doQuit(pw);
					return;
				default :
					ChatServer.consoleLog("Error: Not Supported Request(" + tokens[1] + ")");
					doQuit(pw);
					return;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void doJoin(String nickName, PrintWriter pw) {
		this.nickName = nickName;

		broadcast(nickName + " is entered.\r\n");	//다른 참여자들에게 먼저 들어왔다고 알리고
		
		/* save in writer pool */
		addWriter(pw);							//자기도 채팅방에 참여
		
		//ack - 참여한 클라이언트에게 참여했다는 것을 알림
		pw.println( "join:ok");
		pw.flush();
		
		System.out.println("join:ok");
	}

	private void broadcast(String message) {
		synchronized (writerpool) {
			for(PrintWriter pw : writerpool) {
				pw.println(message + "\r\n");
				pw.flush();
			}
		}
	}

	private void addWriter(PrintWriter pw) {
		synchronized( writerpool ) {
			writerpool.add(pw);
		}
	}

	private void doMessage(String message) {
		broadcast(nickName + ":" + message + "\r\n");
	}

	private void doQuit(PrintWriter pw) {
		removeWriter(pw);
		broadcast(nickName + " is out.\r\n");
	}

	private void removeWriter(PrintWriter pw) {
		writerpool.remove(pw);
	}
}
