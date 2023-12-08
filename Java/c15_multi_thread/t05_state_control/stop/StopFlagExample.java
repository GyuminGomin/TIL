package Java.c15_multi_thread.t05_state_control.stop;

import java.util.Scanner;

class PrintThread extends Thread {
	
	private boolean isRun = true;
	
	public void setIsRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	@Override
	public void run() {
		long sum = 0;
		int i = 0;
		while(isRun) {
			sum += i;
			i++;
			try {
				Thread.sleep(500); // long 타입에서 벗어날까봐 0.5초 sleep 시켜줌
			} catch (InterruptedException e) {}
		}
		System.out.println("자원정리 : " + sum);
		System.out.println("스레드 종료");
	}
}


public class StopFlagExample {

	public static void main(String[] args) {
		
		PrintThread t = new PrintThread();
		t.start();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("출력할 문자열을 입력해 주세요 q는 종료");
			String answer = sc.next();
			System.out.println(answer);
			if(answer.equals("q")) {
//				t.stop(); // 1번째 방법 (연산을 끝까지 마무리 짓지 않고 바로 끝냄)
				t.setIsRun(false); // 2번째 방법 (Thread의 필드 이용)
				break;
			}
		} // end while
		System.out.println("메인 종료");
		sc.close();
	} // end main
}
