package Java.c15_multi_thread.t03_state;

public class StatePrintThread extends Thread{
	
	Thread targetThread;
	
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState(); // 스레드의 상태정보를 가져오는 것(상수로 확인 가능)
			System.out.println("target state : " + state);
			if(state == State.NEW) {
				targetThread.start();
			}
			
			if (state == State.TERMINATED) {
				break;
			}
			
			
			try {
				Thread.sleep(500); // 너무 빠르면 보기 힘드므로 0.5초 여유
			} catch (InterruptedException e) {}
		}
	}
}
