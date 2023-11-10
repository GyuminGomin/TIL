package Java.c04_class.c_method;

// Account 계좌 or 회계 장부
public class Account {
	
	// 최소 입금액
	int minDeposit;
	
	// 최대 입금액
	int maxWithDray = 1000000;
	
	// 잔고
	long balance;
	
	// 입금
	void deposit(int amount) {
		if(amount < minDeposit) {
			System.out.println("입금할 수 있는 금액이 아닙니다.");
			return;
		}
		balance += amount;
	}
	
	void withdraw(int amount) {
		if(balance < 0 || amount > balance) {
			System.out.println("출금할 수 있는 금액이 아닙니다.");
			return;
		}
		balance -= amount;
	}
	
	// 이용자의 잔고 정보를 문자열로 전달
	String showInfo() {
		return "잔고는 : " + balance + "원입니다.";
	}
}
