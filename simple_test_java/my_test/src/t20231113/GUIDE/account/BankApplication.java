package GUIDE.account;

import java.util.Scanner;

public class BankApplication {
	
	Account[] account = new Account[100];
	
	Scanner sc = new Scanner(System.in);
	
	BankApplication(){
		run();
	}
	
	void run() {
		// 1. 계좌생성
		// 2. 계좌조회 
		// 3. 예금
		// 4. 출금
		// 5. 종료
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("========================================");
			System.out.println("1.계좌생성 2.계좌조회 3.예금 4.출금 5.종료");
			System.out.println("========================================");
			
			int selectNo = sc.nextInt();

			if (account[0] == null) {
				if (selectNo == 2 || selectNo == 3 || selectNo == 4) {
					System.out.println("먼저 계좌를 생성해주세요.");
					selectNo = 1;
				}
			}
			if(selectNo == 1) {
				// 계좌생성
				createAccount();
			}else if(selectNo ==2) {
				// 계좌조회
				selectAccount();
			}else if(selectNo ==3) {
				// 예금
				deposit();
			}else if(selectNo ==4) {
				// 출금
				withdraw();
			}else if(selectNo ==5) {
				// 종료
				isRun = false;
				sc.close();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	
	//계좌생성
	void createAccount() {
		// 똑같은 계좌번호랑 비밀번호를 생성할 순 없게 구현하는 것 (2단계)
		System.out.println("-------------------");
		System.out.println("계좌생성");
		System.out.println("-------------------");
		System.out.print("계좌주: ");
		String owner = sc.next();
		System.out.print("계좌번호: ");
		String bankNum = sc.next();
		System.out.print("초기입금액: ");
		int firDeposit = sc.nextInt();
		System.out.print("비밀번호: ");
		String bankPasswd = sc.next();
		for (int i = 0; i < account.length; i++) {
			if (account[i] == null) {
				account[i] = new Account(bankNum, owner, firDeposit,bankPasswd);
				break;
			} else {
				System.out.println(account[i]);
				continue;
			}
		}
		System.out.println("계좌생성이 완료되었습니다.");
	}
	// 계좌조회
	void selectAccount() {
		System.out.println("-------------------");
		System.out.println("계좌목록");
		System.out.println("-------------------");
		System.out.print("계좌번호: ");
		String bankNum = sc.next();
		System.out.print("비밀번호: ");
		String bankPasswd = sc.next();
		System.err.println(findAccount(bankNum, bankPasswd));
	}
	
	// 예금
	void deposit() {
		System.out.println("-------------------");
		System.out.println("예금");
		System.out.println("-------------------");
		System.out.print("계좌번호: ");
		String bankNum = sc.next();
		System.out.print("비밀번호: ");
		String bankPasswd = sc.next();
		System.out.print("예금액: ");
		int deposit = sc.nextInt();

		for (int i=0; i<account.length;i++) {
			if (account[i] == null) {
				System.out.println("계좌가 존재하지 않습니다. 새로 생성해 주세요.");
				break;
			} else {
				if (account[i].ano.equals(bankNum) && account[i].password.equals(bankPasswd)) {
					account[i].balance += deposit;
					System.out.printf("%s님의 계좌 입금이 완료되었습니다.\n", account[i].owner);
					break;
				} else continue;
			}
			
		}
	}
	//출금
	void withdraw() {
		System.out.println("-------------------");
		System.out.println("예금");
		System.out.println("-------------------");
		System.out.print("계좌번호: ");
		String bankNum = sc.next();
		System.out.print("비밀번호: ");
		String bankPasswd = sc.next();
		System.out.print("출금액: ");
		int withdraw = sc.nextInt();

		for (int i=0; i<account.length;i++) {
			if (account[i] == null) {
				System.out.println("계좌가 존재하지 않습니다. 새로 생성해 주세요.");
				break;
			} else {
				if (account[i].ano.equals(bankNum) && account[i].password.equals(bankPasswd)) {
					if (account[i].balance >= withdraw) {
						account[i].balance -= withdraw;
						System.out.printf("%s님의 계좌 출금이 완료되었습니다.\n", account[i].owner);
						break;
					} else {
						System.out.println("잔고가 부족해 출금을 하지 못했습니다.");
						break;
					}
				} else continue;
			}
			
		}
	}
	
	// 계좌번호와 비밀번호가 일치하는 Account 객체를 찾아서 반환 
	Account findAccount(String ano, String password) {
		for (int i=0; i<account.length; i++) {
			if (account[i] == null) {
				System.out.println("일치하는 계좌가 없습니다.");
				break;
			} else {
				if (account[i].ano.equals(ano) && account[i].password.equals(password)) {
					return account[i];
				}
			}
		} return null;
	}
	
	public static void main(String[] args) {
		new BankApplication();
	}
}
