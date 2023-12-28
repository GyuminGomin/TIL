package workspace_javafx.fx_chat_server.chat_server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServerController implements Initializable{

	@FXML
	private TextArea displayText;
	@FXML
	private TextField txtPort;
	@FXML
	private Button btnStartStop;
	
	// Client Thread를 관리할 스레드 풀
	private ExecutorService serverPool;
	// 운영체제에서 요청한 포트로 프로세스를 할당받아 client socket 연결관리를 할 class
	private ServerSocket server;
	// 연결된 client의 닉네임을 key값, 서버에서 발신할 정보를 value로 저장하는 Map 객체
	private Hashtable<String, PrintWriter> clients; // <Client Id, socket 출력 스트림>
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStartStop.setOnAction(e-> {
			String text = btnStartStop.getText();
			if (text.equals("_Start")) {
				startServer();
				btnStartStop.setText("_Stop");
				try {
					Thread.sleep(500); // alt S 버튼을 반복해서 사용하지 않도록 0.5초 대기
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} else {
				stopServer();
				btnStartStop.setText("_Start");
				try {
					Thread.sleep(500); // alt S 버튼을 반복해서 사용하지 않도록 0.5초 대기
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	// 서버 실행 담당
	public void startServer() {
		serverPool = Executors.newFixedThreadPool(50);
		clients = new Hashtable<>();
		
		String port = txtPort.getText().trim(); // 포트 번호 전달
		for (char c : port.toCharArray()) {
			if (c < 48 || c > 57) {
				printText("사용할 수 없는 PORT 번호입니다.");
				txtPort.clear();
				return;
			}
		}
		int portNumber = Integer.parseInt(port); // 정수 값으로 변환
		// 해당 포트 번호를 할당 받아서 client에 연결 요청을 수락할 수 있도록 serverSocket 생성
		// 1023 < portNumber || 65535 > portNumber
		try {
			server = new ServerSocket(portNumber);
		} catch (IOException e) {
			printText("이미 사용중인 포트 번호입니다.");
			stopServer(); // 만약 현재 사용중이라면
			return;
		}
		
		// client 연결 요청 수락 후 연결 정보가 저장된 Socket 생성
		
		// Thread Pool 이 수행해야할 작업만 전달해주면 된다. (Runnable)
		// UI Thread가 while이 들어가면 위험해지므로
		// Thread Pool에서 관리된 Thread에서 필요한 작업만 전달 
		Runnable run = new Runnable() {
			@Override
			public void run() {
				// client 연결 요청 수락 후 연결 정보가 저장된 Socket 생성
				printText("[Start Server]");
				// 여러 클라이언트를 처리해야 하니까
				while (true) {
					// client 연결 대기 client가 연결 요청을 보낼때까지 blocking하다가 정상적으로 연결하면, 접점을 연결해줌
					try {
						// client 연결 대기
						printText("client 연결 대기중 ...");
						Socket client = server.accept();
						String address = client.getRemoteSocketAddress().toString();
						printText("[연결 수락 : "+address+"]");
						serverPool.submit(new ServerTask(client, ServerController.this)); // ServerTask 객체 생성해서 전달
					} catch (IOException e) {
						// accept가 안될 때,
						stopServer(); // 외부에 의해서 갑자기 종료되면, threadPool에 있는 것도 종료되어야 프로그램이 안전하게 종료되므로 필수
						break;
					}
				}
			}
		};
		serverPool.submit(run); // 작업 전달
	}
	
	// 서버 종료 자원해제 담당
	public void stopServer() {
		
		if(server != null && !server.isClosed()) {
			try {
				server.close();
			} catch (IOException e) {}
		}
		
		if (serverPool != null && serverPool.isShutdown()) {
			serverPool.shutdown();
		}
		printText("[서버 중지]");
	}
	
	// 작업 스레드 에서 textArea에 출력 하는 UI 작업을 처리
	public void printText(String text) {
		Platform.runLater(()-> {
			displayText.appendText(text+"\n");
		});
	}
}
