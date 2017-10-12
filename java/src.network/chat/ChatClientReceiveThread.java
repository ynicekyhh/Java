package chat;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientReceiveThread extends Thread {
	private BufferedReader br = null;
	private TextArea textArea = null;

	public ChatClientReceiveThread(BufferedReader br, TextArea textArea) {
		this.br = br;
		this.textArea = textArea;
	}

	/*
	 * join으로 서버에 연결하면 들어오는 "ok"신호 확인 -> 연결 실패시 종료
	 * 연결 후에 들어오는 메세지 받아서
	 * ChatWindow에 보여주기
	 */
	@Override
	public void run() {
		try {
			String request = null;
			while(true) {
				//1. 서버 메세지 읽어오기
				request = br.readLine();
				if(request == null) {
					consolLog("disconnected from server");
					break;
				}
				
				//2. 메세지 프로토콜 파싱
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					if(!"ok".equals(tokens[1])) {
						consolLog("server connection failed");
					}
				}else {	//broadcast 상황
					textArea.setText(request);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void consolLog(String log) {
		System.out.println( "[client: " + Thread.currentThread().getId() + "] " + log);
	}
}
