package workspace_javafx.fx_chat_client.chat_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
			
			try {
				// 객체 생성 시에 서버에 연결 요청 (서버 연결 요청 수락 시 연결된 socket 정보를 반환)
				server = new Socket(this.ip, this.port); // 필드에 저장된 ip와 포트로 서버 연결 요청
				displayText("[연결 완료 : " + server.getRemoteSocketAddress()+"]"); // 소켓 주소 반환
			} catch (IOException e1) {
				displayText("[서버 연결 안됨. IP와 PORT를 확인해 주세요.]");
				return;
			}
			
		}); // end btnConn
		
		
	} // end initialize
	
	// 자원 해제 후 client 종료
	public void stopClient() {}
	
	// server에 메시지 출력
	// code - 0 : 닉네임 출력
	// code - 1 : 메시지 출력
	public void send(int code, String message) {}
	
	// server에서 출력된 메시지 입력
	// code - 0 : 리스트 목록 갱신, code - 1 : 일반메시지 (서버한테 받은 코드에 따라)
	public void receive() {}
	
	// txtDisplay textArea에 UI thread를 이용하여 text 작성
	public void displayText(String text) {
		Platform.runLater(()-> {
			txtDisplay.appendText(text+"\n");
		});
	}
}
