package chat_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;

public class ClientController implements Initializable{

	@FXML
	private TextArea txtDisplay;
	@FXML
	private TextField txtIp, txtPort, txtNick, txtInput;
	@FXML
	private ListView<String> listView;
	@FXML
	private Button btnConn, btnSend;
	
	// 연결된 Server의 소켓 정보를 저장할 Socket 멤버
	private Socket server;
	// 연결 요청을 보낼 server ip 주소
	private InetAddress ip;
	// 연결 요청을 보낼 server port 번호
	private int port;
	// 서버로 출력할 스트림
	private PrintWriter printer;
	// 서버에서 데이터를 입력받을 스트림
	private BufferedReader br;
	// client가 사용 중인 닉네임(ID)
	private String nickName;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// font 정보 확인
		loadFont();
		
		Platform.runLater(() -> { // UI 쓰레드 그릴거 다 그리고 그려라고 쓸 수 있음
			txtIp.requestFocus();
		});
		
		// txtIp에서 Enter 키가 눌려지면 Port 입력창으로 focus
		txtIp.setOnKeyPressed(e-> {
			if (e.getCode() == KeyCode.ENTER) {
				txtPort.requestFocus();
			}
		});
		
		txtPort.setOnKeyPressed(e-> {
			if (e.getCode() == KeyCode.ENTER) {
				txtNick.requestFocus();
			}
		});
		
		txtNick.setOnKeyPressed(e-> {
			if (e.getCode() == KeyCode.ENTER) {
				btnConn.fire(); // 버튼 이벤트를 강제로 발생 시키는 것
				txtInput.requestFocus();
			}
		});
		
		txtInput.setOnKeyPressed(e-> {
			if (e.getCode() == KeyCode.ENTER) {
				btnSend.fire();
			}
		});
		
		btnConn.setOnAction(e-> {
			
			// ip 번호 확인
			String ip = txtIp.getText().trim();
			if (ip.equals("")) {
				displayText("아이피 주소를 작성해주세요.");
				txtIp.requestFocus();
				return;
			}
			
			try {
				// getByName에 전달된 문자열형태가 ipv4 주소값이나 domain 형태가 아니면 UnKnownHostException 발생
				this.ip = InetAddress.getByName(ip);
			} catch (UnknownHostException e1) {
				displayText("사용할 수 없는 주소입니다.");
				txtIp.clear();
				txtIp.requestFocus();
				return;
			}
			// ip 확인 완료
			
			// port 번호 확인
			String textPort = txtPort.getText().trim();
			// txtPort TextField에 작성된 값이 없을 경우
			if (textPort.equals("")) {
				displayText("포트번호를 작성해주세요.");
				txtPort.requestFocus();
				return;
			}
			
			for (char c : textPort.toCharArray()) {
				if (c < 48 || c > 57) {
					displayText("잘못된 포트 번호입니다.");
					txtPort.clear();
					txtPort.requestFocus();
					return;
				}
			}

			
			this.port = Integer.parseInt(textPort);
			if (port <= 1023 || port > 65535) {
				displayText("잘못된 포트 번호입니다.");
				txtPort.clear();
				txtPort.requestFocus();
				return;
			}
			// port 번호 확인 완료
			
			// 닉네임 작성 필드의 이름 정보 txt
			String nick = txtNick.getText().trim();
			if(nick.equals("")) {
				displayText("닉네임을 작성해 주세요.");
				txtNick.requestFocus();
				return;
			}
			this.nickName = nick;
			// 닉네임 확인 완료
			
			
			try {
				// 객체 생성 시에 서버에 연결 요청 (서버 연결 요청 수락 시 연결된 socket 정보를 반환)
				server = new Socket(this.ip, this.port); // 필드에 저장된 ip와 포트로 서버 연결 요청
				displayText("[연결 완료 : " + server.getRemoteSocketAddress()+"]"); // 소켓 주소 반환
				
				// server와 통신할 입출력 스트림 초기화
				// 출력 스트림
				printer = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(server.getOutputStream())), true
				);
				// 입력 스트림
				br = new BufferedReader(new InputStreamReader(server.getInputStream()));
				
				send(0, nickName); // 현재 nickName이 String이라 null값으로 저장되어있지 않은가?
				
				
			} catch (IOException e1) {
				displayText("[서버 연결 안됨. IP와 PORT를 확인해 주세요.]");
				stopClient();
				return;
			}
			
			// 서버에서 발신된 데이터 수신
			receive(); // 지속적으로 수신 대기
		}); // end btnConn
		
		// send button click 시 msg 발송
		btnSend.setOnAction(e -> {
			String text = txtInput.getText().trim();
			if (text.equals("")) {
				displayText("메세지를 먼저 작성해 주세요.");
				txtInput.requestFocus();
				return;
			}
			// 서버로 메세지 전달
			send(1, text);
		});
		
		
	} // end initialize
	

	// 자원 해제 후 client 종료
	public void stopClient() {
		displayText("[서버와 연결 종료]");
		if (server != null && !server.isClosed()) {
			try {
				server.close(); // server와 연결된 소켓 정보 닫기
			} catch (IOException e) {}
		}
	}
	
	// server에 메시지 출력
	// code - 0 : 닉네임 출력
	// code - 1 : 메시지 출력
	public void send(int code, String msg) {
		printer.println(code+"|"+msg); // 메시지 보내기 (서버와 클라이언트끼리 약속)
		if (code == 1) {
			txtInput.clear(); // 다시 텍스트 입력할 수 있도록
			txtInput.requestFocus();
		}
		
	}
	
	// server에서 출력된 메시지 입력
	// code - 0 : 리스트 목록 갱신, code - 1 : 일반메시지 (서버한테 받은 코드에 따라)
	public void receive() {
		Thread t = new Thread(()-> {
			while (true) {
				try {
					// server에서 발신된 데이터를 한 라인씩 읽기
					String receiveData = br.readLine();
					if (receiveData == null) {
						break;
					}
					
					// 0|nick,nick,...
					// 1|msg
					String[] datas = receiveData.split("\\|");
					String code = datas[0];
					String text = datas[1];
					if (code.equals("0")) {
						// 접속자 목록 갱신
						String[] names = text.split(",");
						ObservableList<String> nameList = FXCollections.observableArrayList(names);
//						nameList.addAll(names);
						Platform.runLater(()-> {
							listView.setItems(nameList);
						});
						
					} else if (code.equals("1")) {
						// 일반 메시지 출력
						displayText(text);
					}
					
				} catch (IOException e) {
					// thread run while 종료 (더이상 수신할 수 없으면 while 문 벗어남)
					break;
				}
			} // end while
			// Thread 종료 전 socket 자원 해제
			stopClient();
			
		});
		t.setDaemon(true);
		t.start();
	}
	
	// txtDisplay textArea에 UI thread를 이용하여 text 작성
	public void displayText(String text) {
		Platform.runLater(()-> {
			txtDisplay.appendText(text+"\n");
		});
	}
	
	/*
	 * Font 사용 방법
	 */
	private void loadFont() {
//		System.out.println(Font.getFamilies()); // 글꼴 지정 (기본적으로 컴퓨터에 포함되어 있는 폰트)
//		System.out.println(Font.getFontNames());
		
		// Maplestory font 등록
		Font font = Font.loadFont(getClass().getResource("/fonts/MaplestoryLight.ttf").toString(), 12); // (읽어올 폰트 경로(String), 폰트 크기)
		
		System.out.println(font.getFamily());
		System.out.println(Font.getFamilies());
		System.out.println(Font.getFontNames());
		
		// Maplestory font 지정
		txtInput.setFont(font);
	}
}