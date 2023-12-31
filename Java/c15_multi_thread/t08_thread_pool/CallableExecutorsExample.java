package Java.c15_multi_thread.t08_thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutorsExample {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()	
		);
		System.out.println("[ 작업 처리 요청 ]");
		Callable<Integer> call = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i <= 100; i++) {
					sum += i;
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
				return sum;
			}
		}; // end callable
		
		// execute는 결과가 없는 Runnable만 요청 가능
//		exe.execute(call);
		
		Future<Integer> future = exe.submit(call);
		try {
			System.out.println("[ blocking ]");
			int sum = future.get();
			System.out.println("[작업처리결과 : "+sum+"]");
			System.out.println("작업처리 완료");
		} catch (InterruptedException e) {
			System.out.println("외부 호출에 의한 스레드 종료 : " + e.getMessage());
		} catch (ExecutionException e) {
			System.out.println("작업에서 발생한 예외 : " + e.getMessage());
		}
		
		exe.shutdownNow();
	}
}
