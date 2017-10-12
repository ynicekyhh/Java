package chat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "192.168.1.24";
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		String name = null;
		Socket socket = null;
		//1. 키보드 연결
		Scanner scanner = new Scanner(System.in);

		try {

			//2. 소켓 생성
			socket = new Socket();

			//3. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			//4. I/O 사용
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

			//5. join 프로토콜
			while( true ) {

				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				if (name.isEmpty() == false ) {
					pw.println("join:" + name);
					pw.flush();
					break;
				}

				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			
			// --> "JOIN 둘리\r\n"
			// <-- "JOIN OK\r\n"
			new ChatWindow(name, br, pw).show();
			
			
		} catch(IOException e) {
			consolLog("Error : " + e);
		} finally {
//			try {
//				if(socket != null && socket.isClosed() == false) {
//					socket.close();
//					scanner.close();
//				}
//			} catch (IOException e) {
//				consolLog("Error : " + e);
//			}
		}

	}
	
	public static void consolLog(String log) {
		System.out.println( "[client: " + Thread.currentThread().getId() + "] " + log);
	}
}
