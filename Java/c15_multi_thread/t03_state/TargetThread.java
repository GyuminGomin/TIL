package Java.c15_multi_thread.t03_state;

// 상태를 확인할 스레드
public class TargetThread extends Thread{
	
	@Override
	public void run() {
		// RUNNABLE state
		for(long i = 0; i < 10000000000L; i++);
		// TIMED_WAITTING state
		try {
			sleep(1500); // 지정한 ms 만큼 일시 정지
		} catch (InterruptedException e) { // 작업이 방해될 수 도 있기 때문에 하는 예외처리
			e.printStackTrace();
		}
		// RUNNALBE stated
		for(long i =0; i< 10000000000L; i++);
		
		// TERMINATED state -> 더 이상 수행할 작업이 없으므로
		
	} // end run
}
