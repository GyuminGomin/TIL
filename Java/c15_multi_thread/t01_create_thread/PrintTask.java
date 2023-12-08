package Java.c15_multi_thread.t01_create_thread;

// 방법 2. Runnable 인터페이스 구현 객체를 이용하는 방법
public class PrintTask implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 5; i++){
			System.out.println("PrintTask 띵!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		} // end for
		System.out.println("Print Task 종료");
	} // end run

}
