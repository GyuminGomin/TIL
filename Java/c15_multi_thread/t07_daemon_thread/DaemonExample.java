package Java.c15_multi_thread.t07_daemon_thread;

import java.util.Map;
import java.util.Set;

class AutoSaveThread extends Thread {
	
	public void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("interrupted!");
				break;
			}
			save();
		} // end while
	} // end run
}

/*
 * Daemon 프로그램 이란
 * 사용자가 직접 제어하지 않고, 백그라운드에서 돌면서 여러 작업을 하는 프로그램
 * 
 * Daemon thread - 주 스레드에서 자동으로 관리되는 스레드
 */
public class DaemonExample {

	public static void main(String[] args) {
		AutoSaveThread t = new AutoSaveThread();
		t.setName("AutoSaveThread");
		// daemon 지정은 스레드가 실행 되기 전에 지정
		t.setDaemon(true);
		t.start();
		// 해당 스레드가 데몬 스레드인지 여부를 boolean 타입으로 반환
		System.out.println("t isDaemon : "+t.isDaemon());
		
		// 현재 동작 중인 모든 스레드 정보
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for (Thread thread : threads) {
			String isDaemon = (thread.isDaemon()) ? "(DAEMON)" : "(MAIN)";
			System.out.print("Name : "+thread.getName()+isDaemon+":"+thread.getPriority());
			System.out.println("\t 소속그룹 : " + thread.getThreadGroup().getName());
		}
		
		System.out.println("Main Thread 종료");
	}
}
