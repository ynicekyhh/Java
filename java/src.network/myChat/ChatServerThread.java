package myChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickName = null;
	private Socket socket = null;
	private List<Writer> writerpool = null;
	private BufferedReader br = null;
	private PrintWriter pw = null;

	public ChatServerThread(Socket socket, List<Writer> writerpool) {
		this.socket = socket;
		this.writerpool = writerpool;
	}

	@Override
	public void run() {
		//4. 요청 성공 확인하기 위해
		InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		ChatServer.consoleLog("[SERVER] client로부터 연결이 되었습니다. >>" +
				remoteSocketAddress.getAddress().getHostAddress() +
				":" +
				remoteSocketAddress.getPort());

		try {
			//5. socket I/O stream 가져오기
			br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "UTF-8" ) );
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

			while(true) {
				//6. 데이터 읽어오기
				String request = br.readLine();
				if(request == null) {
					ChatServer.consoleLog("client의 연결이 끊어졌습니다.");
					break;
				}
				
				String[] tokens = request.split(":");
				
				switch(tokens[0]) {
				case "join":
					doJoin(tokens[1], pw);
					break;
				case "message":
					doMessage();
					break;
				case "quit":
					doQuit();
					break;
				default:
					ChatServer.consoleLog("에러:알 수 없는 요청>>" + tokens[0]);
					break;
				}
				

				//7. 데이터 쓰기

			}
		} catch (IOException e) {

		} finally {
			
		}
	}

	private void doQuit() {
		
	}

	private void doMessage() {
		
	}

	private void doJoin(String nickName, Writer printWriter) {
		this.nickName = nickName;
		
		/* writepool 에 저장 */
		writerpool.add(printWriter);
	}
}
