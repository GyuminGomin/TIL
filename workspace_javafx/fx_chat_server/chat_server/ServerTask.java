package workspace_javafx.fx_chat_server.chat_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTask implements Runnable{

	// 현재 task에 연결된 client socket 정보
	private Socket client;
	// display UI 정보가 있는 Controller instance 정보 저장
	private ServerController sc;
	// 연결된 Clinet에 출력할 스트림
	private PrintWriter printer;
	// client에서 출력된 데이터를 입력받을 스트림
	private BufferedReader reader;
	// 연결된 client의 nickName 정보를 저장
	private String nickName;
	// 연결된 client task 종료 flag
	private boolean isRun = true;
	
	// 연결 정보가 바뀌면서 Socket 정보가 바뀌는 것을 방지하기 위해
	public ServerTask(Socket client, ServerController sc) {
		this.client = client;
		this.sc = sc;
		
		try {
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os); // 2byte
			BufferedWriter writer = new BufferedWriter(osw); // 속도 향상
			printer = new PrintWriter(writer, true); // auto flush
			
			reader = new BufferedReader(
					new InputStreamReader(client.getInputStream())
			);
			// 입 출력 스트림 초기화 
			
		} catch (IOException e) {
			// (만약 여기서 문제가 발생했다면)
			sc.printText("Client 연결 오류 : " +e.getMessage());
		}
	}

	// 연결 요청이 완료된 클라이언트들마다 새로운 작업 개체 생성
	// client 에서 출력된 발신 메시지를 수신 - receive
	@Override
	public void run() {
		sc.printText(client.getRemoteSocketAddress()+" receive 시작");
		// receive Data
		// code - 0 : 닉네임 전달, code - 1 : 메시지 전달 (+귓속말)
	}
	
	// 연결된 모든 client에게 메시지 전달
	// code - 0 : 접속자 목록 갱신, code - 1 : 메시지 출력
	public void broadCast(int code, String message) {
		
	}

}
