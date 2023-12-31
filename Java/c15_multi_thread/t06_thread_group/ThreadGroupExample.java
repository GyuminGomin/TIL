package Java.c15_multi_thread.t06_thread_group;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("MyGroup");
		Thread threadA = new WorkThread(group, "WorkThreadA");
		Thread threadB = new WorkThread(group, "WorkThreadB");
		group.list();
		threadA.start();
		threadB.start();
		
		System.out.println("[MyGroup List 정보]");
		group.list();
		
		System.out.println("------------------------------------------------------");
		Thread mainThread = Thread.currentThread();
		ThreadGroup mainGroup = mainThread.getThreadGroup();
		mainGroup.list();
		
		System.out.println("------------------------------------------------------");
		// group 안에 동작 중인(actice) 스레드 개수
		System.out.println(group.activeCount());
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {}
		
		// interruptedException 강제 발생 (단 ,thread 가 일시 정지 상태일 때만 발생)
		mainGroup.interrupt();
	}
}
