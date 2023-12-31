package Java.c15_multi_thread.t01_create_thread;

public class MultiThreadExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// 1. Thread 상속
		Thread t = new BeepThread();	// 스레드 객체 생성
		// t.run();// 스레드 생성 X 인스턴스의 메소드 호출
		t.start(); // 새로운 작업 스레드 생성 및 run() 호출 실행
		
		// 2. Runnable 인터페이스 구현 - 스레드가 처리할 작업을 정의하는 interface
		Runnable run = new PrintTask();
		Thread t1 = new Thread(run);
		t1.start();
		
		// 방법 3. Runnable 익명 구현객체 사용
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("work Task");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
				System.out.println("Work Task 종료");
			}
		});
		t2.start();
		
		// 방법 4. lambda 표현식을 활용 하여 Runnable 인터페이스 구현
		Thread t3 = new Thread(()->{
			System.out.println("lambda Task");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			System.out.println("lambda Task 종료");
		});
		t3.start();
		
		System.out.println("Main 종료");
	}

}
