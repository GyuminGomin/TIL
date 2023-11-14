package GUIDE.member;

import java.util.Scanner;

public class MemberManagement{

	// 사용자 입력
	Scanner sc = new Scanner(System.in);
	
	// 회원정보 저장
	Member[] members = new Member[100];
	
	// 관리자 계정
	Member master = new Member(100,"master","root","root");
	
	// 로그인한 회원
	Member loginMember = null;
	
	// 프로그램 flag (true : 진행 , false : 종료) 
	boolean isRun = true;
	
	// 메뉴 번호 선택
	int selectNo;

	// 프로그램 실행용 생성자
	MemberManagement() {
		// 회원목록 배열 마지막 인덱스에 관리자 계정 저장
		members[members.length-1] = master;
		// 회원관리 메소드 호출
		isRun();
	}
	
	/*
	 * 기능 관리 
	 */

	// 프로그램 실행
	void isRun() {
		while (isRun) {
			System.out.println("==================================================");
			System.out.println("1.회원가입|2.로그인|3.회원목록|4.회원정보수정|5.회원탈퇴|6.프로그램종료");
			System.out.println("==================================================");

			System.out.println("번호 입력 >");
			selectNo = sc.nextInt();

			if (loginMember == null) {
				if (selectNo == 3 || selectNo == 4 || selectNo == 5) {
					System.out.println("먼저 로그인 부터 해주세요.");
					selectNo=2;
				}
			}
			switch (selectNo) {
				case 1: // 회원가입
					join();
					break;				
				case 2 : // 로그인
					login();
					break;
				case 3 : // 회원 목록 (관리자만 확인 가능)
					select();
					break;
				case 4 : // 내 정보 수정
					update();
					break;
				case 5 : // 회원 탈퇴
					delete();
					break;
				case 6 : // 종료
					terminate();
					break;
				default:
					System.out.println("잘못된 번호를 선택하셨습니다.");
					break;
			}


		}
	}
	
	// 프로그램 종료
	void terminate() {
		isRun = false;
	}

	// 회원 가입
	void join() {
		System.out.println("회원가입 >");
		System.out.println("사용정보를 입력해주세요 ----------------------");
		String id = getData("아이디를 입력해주세요 >");
		if (memberIdCheck(id) == false) {
			System.out.println("아이디가 이미 존재합니다.");
			return;
		}
		String passwd = getData("비밀번호를 입력 해주세요 >");
		String checkPasswd = getData("비밀번호를 확인해주세요 >");
		if (!passwd.equals(checkPasswd)) { 
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		String name = getData("이름을 입력해주세요 >");
		
		for (int i=0; i<members.length; i++) {
			if (members[i] == null) {
				members[i] = new Member(i+1, name, id, passwd);
				break;
			} else {
				continue;
			}
		}
	}
	
	// 로그인
	void login() {
		System.out.println("== 로그인 ==");
		String id = getData("아이디를 입력해주세요 >");
		String passwd = getData("비밀번호를 입력해주세요 >");
		loginMember = new Member(id,passwd); // 비교 대상
		if (members[99].equals(loginMember)) {
			System.out.println("정상적으로 로그인 되었습니다.");
			System.out.println(members[99]);
			System.out.println("관리자 계정입니다.");
			return;
		}
		for (int i = 0; i<members.length; i++) {
			if (members[i] == null) {
				System.out.println("일치하는 멤버가 없습니다.");
				break;
			} else {
				if (members[i].equals(loginMember)) {
					System.out.println("정상적으로 로그인 되었습니다.");
					System.out.println(members[i]);
					break;
				} else continue;
			}
		}
	}

	// 회원목록 - 로그인한 회원이 관리자 일때만 노출 
	void select() {
		if(loginMember.equals(members[99])) {
			System.out.println("== 회원목록 ==");
			for (int i = 0; i<members.length; i++) {
				if (members[0] == null) {
					System.out.println("회원목록이 없습니다.");
					break;
				} else {
					if (members[i] == null) break;
					System.out.println(members[i]);
				}
			}
		} else {
			System.out.println("회원목록 >");
			System.out.println("관리자만 확인가능한 메뉴 입니다.");
		}

	}
	
	// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	void update() {
		if (loginMember.equals(members[99])) {
			System.out.println("== 회원정보수정 ==");
			System.out.println("== 관리자 회원정보 수정");
			for (int i=0; i<members.length;i++) {
				if (members[0] == null) {
					System.out.println("회원목록이 없습니다.");
					return;
				} else {
					if (members[i] == null) break;
					System.out.println(members[i]);
				}
			}
			int editMemNum = getNum("수정할 회원의 번호를 입력해 주세요.");
			String editMemName = getData("수정할 회원의 이름을 입력해 주세요");
			members[editMemNum-1].mName = editMemName;
			System.out.println("수정완료");
		} else {
			System.out.println("회원정보수정 >");
			System.out.println("내정보 수정 -----");
			String chkPasswd = getData("비밀번호를 한번더 입력해주세요 >");
			String editMemName = getData("수정할 회원의 이름을 입력해 주세요");
			for (int i=0; i<members.length; i++) {
				if (loginMember.equals(members[i])) {
					members[i].mName = editMemName;
					System.out.println("내정보 수정완료");
					return;
				}
			}
		}
	}
	
	// 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	void delete() {
		if (loginMember.equals(members[99])) {
			System.out.println("master 계정은 삭제할 수 없습니다.");
			return;
		} else {
			System.out.println("회원탈퇴 >");
			System.out.println("정말로 탈퇴 하시겠습니까? y/n");
			char checkDelete = sc.next().charAt(0);
			if (checkDelete == 'y') {
				deleteMember();
			} else {
				System.out.println("회원 탈퇴 취소하셨습니다.");
			}
		}
	}
	
	// 사용자 아이디 중복 체크
	boolean memberIdCheck(String mId) {
		for(Member m : members) {
			if(m != null && m.mId.equals(mId)) {
				return false;
			} 
		}
		return true;
	} // false : id가 같을 때, true : id가 다를 때
	
	// // 회원 아이디와 비밀번호로 회원 찾기
	// Member findMember(Member m) {
	// 	for(Member member : members) {
	// 		if(member != null && member.equals(m)) {
	// 			return member;
	// 		}
	// 	}
	// 	return null;
	// }
	
	// 회원 정보 삭제
	void deleteMember() {
		for(int i=0; i<members.length; i++) {
			if(members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}

	Scanner scanLine = new Scanner(System.in);
	Scanner scanInt = new Scanner(System.in);
	// 문자 입력
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	// 숫자 입력
	int getNum(String message) {
		System.out.println(message);
		return scanInt.nextInt();
	}
}
