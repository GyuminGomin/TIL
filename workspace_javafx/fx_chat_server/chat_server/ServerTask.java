package chat_server;

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
	Socket client;
	// display UI 정보가 있는 Controller instance 정보 저장
	ServerController sc;
	// 연결된 Clinet에 출력할 스트림
	PrintWriter printer;
	// client에서 출력된 데이터를 입력받을 스트림
	BufferedReader reader;
	// 연결된 client의 nickName 정보를 저장
	String nickName;
	// 연결된 client task 종료 flag
	boolean isRun = true;
	
	// 연결 정보가 바뀌면서 Socket 정보가 바뀌는 것을 방지하기 위해
	public ServerTask(Socket client, ServerController sc) {
		this.client = client;
		this.sc = sc;
		
		try {
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os); // 2byte
			BufferedWriter writer = new BufferedWriter(osw); // 속도 향상
			printer = new PrintWriter(writer, true); // auto flush
			
			reader = new BufferedReader( // String 기반으로 한줄씩 읽어올 수 있게 해주는 것
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
		while (isRun) {
			try {
				// client에서 발신 된 메시지 수신
				String receiveData = reader.readLine();
				if (receiveData == null) {
					break;
				}
				sc.printText(client.getRemoteSocketAddress()+" : "+receiveData);
				String[] data = receiveData.split("\\|");
				// [0][nickName], [1][Message]
				String code = data[0];
				String text = data[1];
				// code 번호로 기능 분류
				switch (code) {
					// 전달된 닉네임으로 연결된 client 정보를 hashtable에 등록
					case "0" :
						// hashtable에 등록된 닉네임이 이미 key 값으로 존재하는지 확인
						if (sc.clients.containsKey(text)) {
							sc.printText(text+"-사용할 수 없는 닉네임 요청");
							this.printer.println(text+"는 사용할 수 없는 닉네임입니다.");
							// serverTask Thread 종료
							isRun = false;
							client.close(); // 닉네임이 잘못되었으니 연결 끊기
							break; // 사용할 수 있는 닉네임이면 출력해줘야 하기 때문
						} // 닉네임 중복 체크 완료
						
						// 중복되지 않는 닉네임을 필드에 저장
						this.nickName = text;
						// 연결된 client 목록에 등록 (hashtable)
						sc.clients.put(text, printer);
						
						// client 접속자 목록 갱신
						String sendData = "";
						for (String name : sc.clients.keySet()) {
							// hashtable의 key 묶음
							sendData += name+",";
							// 0|name,name,name,... ;
							// 1|msg;
						}
						broadCast(0, sendData);
						broadCast(1, nickName+"님이 입장하셨습니다. 현재 인원 : "+sc.clients.size());
						
						break; // end case 0
					// 연결된 client에게 메시지 전달
					case "1" :
						broadCast(1,nickName+" : "+text);
						break;
				}
				
			} catch (IOException e) {
				sc.printText(client.getRemoteSocketAddress()+" client 연결 종료 : " + e.getMessage());
				isRun = false;
			}
		} // end while
		// 연결된 client와 수신 작업 종료
		if (client != null && !client.isClosed()) {
			// serverTask 종료 시 - 연결된 socket된 자원 해제
			try {
				client.close();
			} catch (IOException e) {}
		}
		
		// 종료한 client 정보 삭제 및 사용자 목록 갱신
		sc.clients.remove(this.nickName);
		
		// 사용자 목록에서 종료된 사용자 제거 후 남아있는 사용자 목록 갱신
		String list = "";
		for (String name : sc.clients.keySet()) {
			list += name+",";
		}
		
		// 남아있는 모든 클라이언트에게 접속자 목록 갱신 데이터 발신
		broadCast(0,list);
		String result = nickName+"님이 나가셨습니다. 현재 인원 : " +sc.clients.size();
		broadCast(1, result);
//		sc.printText(result); // 서버도 알 수 있도록
		
	} // end serverTask run
	
	// 연결된 모든 client에게 메시지 전달
	// code - 0 : 접속자 목록 갱신, code - 1 : 메시지 출력
	public void broadCast(int code, String message) {
		// 놀랍다 다시 봐도
		for (PrintWriter p : sc.clients.values()) {
			p.println(code+"|"+message);
		}
	}

}
