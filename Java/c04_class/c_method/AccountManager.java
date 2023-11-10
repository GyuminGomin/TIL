package Java.c04_class.c_method;

public class AccountManager {

	public static void main(String[] args) {
		Account choi = new Account();
		String result = choi.showInfo();
		System.out.println(result);
		choi.deposit(1000000000);
		result = choi.showInfo();
		System.out.println(result);
		choi.withdraw(150000);
		result = choi.showInfo();
		System.out.println(result);
		
		Account um = new Account();
		um.deposit(1000);
		result = um.showInfo();
		System.out.println(result);
		um.withdraw(10000);
		um.deposit(-2000);
		
		result = choi.showInfo();
		System.out.println("choi " + result);
		result = um.showInfo();
		System.out.println("um " + result);
	}

}
