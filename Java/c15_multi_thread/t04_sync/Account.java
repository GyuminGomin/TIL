package Java.c15_multi_thread.t04_sync;

public class Account {

	// 현재 저장된 금액
	private int balance = 10000;
	
	public int getBalance() {
		return this.balance;
	}
	
	// 출금
//	synchronized public boolean withDraw(int money) {
	synchronized public boolean withDraw(int money) {
		// 출금 가능한 금액
		if(balance >= money) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			balance -= money;
			return true;
		}
		
		// 출금 불가능 금액
		return false;
	}
}
