package Java.c15_multi_thread.t01_create_thread;

import java.awt.Toolkit;

// 방법 1. Thread를 상속 받아 수행할 작업 재정의
public class BeepThread extends Thread{

	@Override
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit(); // 운영체제의 시스템 정보
		for(int i = 0; i < 5; i++) {
			System.out.println("BeepThread");
			tool.beep(); // 비프음을 의미함. 띵소리
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		} // end for
		System.out.println("Beep Thread 종료");
	} // end run
	
}
