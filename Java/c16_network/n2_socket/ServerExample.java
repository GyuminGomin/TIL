package Java.c16_network.n2_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 서버 프로그램
public class ServerExample {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(5001); // 오픈할 포트번호 지정
			while(true) {
				// 연결이 수락된 client와 연결된 socket
				System.out.println("--------------------------------");
				System.out.println("Client 연결 대기중");
				Socket client = server.accept();
				// Client <= Server Output, Client => Server Input
				System.out.println("Client 연결 수락");
				
				InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress(); // 원격지 소켓정보
				System.out.println("client - " + isa.getHostString());
				System.out.println("clinet port - " + isa.getPort());
				
				byte[] bytes = null;
				String message = null;
				
				OutputStream os = client.getOutputStream(); // 연결수락이 완료된 클라이언트한테 정보를 전달하는 스트림
				message = "HELLO!";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("데이터 출력 완료");
				
				// Client 에서 발신된 message 수신
				InputStream is = client.getInputStream();
				bytes = new byte[100];
				
				System.out.println("Blocking");
				int readCount = is.read(bytes);
				message = new String(bytes, 0, readCount, "UTF-8");
				System.out.println("client에서 발신한 데이터 : " + message);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if(server != null) server.close();
			} catch (IOException e1) {}
		}
	}
}
