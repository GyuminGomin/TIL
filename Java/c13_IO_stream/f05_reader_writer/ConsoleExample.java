package Java.c13_IO_stream.f05_reader_writer;

import java.io.Console;

public class ConsoleExample {

	public static void main(String[] args) {
		Console console = System.console();
		System.out.println("아이디 : ");
		String id = console.readLine();
		System.out.println("비밀번호 : ");
		char[] password = console.readPassword(); // 이클립스에선 console이 가상이므로 작동하지 않는다. (nullpointerException 발생)
		System.out.println("-----------------------");
		String strPassword = new String(password);
		System.out.println("id : " + id);
		System.out.println("pass : " + strPassword);
	}
}