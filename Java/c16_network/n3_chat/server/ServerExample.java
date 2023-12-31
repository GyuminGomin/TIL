package Java.c16_network.n3_chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class ServerExample {

	/*
	 * 운영체제에게 포트 번호를 할당 받아 연결요청을 보낸 socket 정보를 수락, 제공해줄 field
	 */
	ServerSocket serverSocket;
	
	static List<Client> clients = new Vector<>(); // 여러 client를 다루는 List
	
	public void startServer() {
		try {
			serverSocket = new ServerSocket();
			// 운영체제에게 포트를 할당 받기 전까지 blocking
			// 내 컴퓨터 IP 주소 == localhost == 127.0.0.1 == 10.100.205.80
			serverSocket.bind(new InetSocketAddress(5002));
			System.out.println("[ Server Open ]" + serverSocket.getLocalSocketAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// client 연결
		while(true) {
			try {
				System.out.println("----------------------------------");
				System.out.println("[ Client 연결 대기중... ]");
				Socket client = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();
				String host = isa.getHostString(); // IP 주소
				System.out.println("연결 수락 : " + host);
				
				clients.add(new Client(client));
				System.out.println("연결된 client 수 : " + clients.size());
				
			} catch (IOException e) {
				System.out.println("서버 종료 : " + e.getMessage());
				stopServer();
				break;
			}
		}
	}
	
	/*
	 * 안전하게 Server가 종료될 수 있도록 외부와 연결된 자원 해제
	 */
	public void stopServer() {
		System.out.println("서버 자원 해제");
		
		for (Client client : clients) {
			// socket이 close 되지 않았다면
			if (!client.socket.isClosed()) {
				try {
					client.socket.close();
				} catch (IOException e) {}
			}
		}
		
		if (serverSocket != null && !serverSocket.isClosed()) {
			try {
				// 할당 받은 포트 반납
				serverSocket.close();
			} catch (IOException e) {}
		}
	}
	
	public static void main(String[] args) {
		ServerExample server = new ServerExample();
		server.startServer();
	}
}