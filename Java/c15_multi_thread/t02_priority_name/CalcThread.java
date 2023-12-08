package Java.c15_multi_thread.t02_priority_name;

public class CalcThread extends Thread{
	
	// 생성자의 매개변수로 Thread 이름 전달
	public CalcThread(String name) {
		// Thread의 생성자를 통해 Thread 이름 초기화
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 2000000000; i++);
		System.out.println(getName()+" : " + getPriority());
		System.out.println(Thread.currentThread());
	}

}
