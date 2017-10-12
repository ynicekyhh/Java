package chat;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ChatWindow {
	BufferedReader br = null;
	PrintWriter pw = null;
	String name = null;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name, BufferedReader br, PrintWriter pw) {
		this.br = br;
		this.pw = pw;
		this.name = name;
		
		frame = new Frame("ChattingApp");
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});
		

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		new ChatClientReceiveThread().start();
	}
	
	public class ChatClientReceiveThread extends Thread {
//		private BufferedReader br = null;
//		private TextArea textArea = null;
//		
//		public ChatClientReceiveThread(BufferedReader br, TextArea textArea) {
//			this.br = br;
//			this.textArea = textArea;
//		}
		
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
						textArea.append("\r\n" + request);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	private static void consolLog(String log) {
		System.out.println( "[client: " + Thread.currentThread().getId() + "] " + log);
	}
	
	private void sendMessage() {
		String message = textField.getText();

		// name, writer, message
//		textArea.append( "둘리:" + message );
//		textArea.append("\n");
//		textArea.append( name + ":" + message );
		textArea.append("\r\n");

		textField.setText("");
		textField.requestFocus();		
		
		pw.println("message:" + message);
		pw.flush();
	}
}
