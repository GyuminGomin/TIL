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
			switch (selectNo) {
				case 1: // 회원가입
					System.out.println("회원가입 >");
					System.out.println("사용정보를 입력해주세요 ----------------------");
					String id = getData("아이디를 입력해주세요 >");
					String passwd = getData("비밀번호를 입력 해주세요 >");
					String checkPasswd = getData("비밀번호를 확인해주세요 >");
					if (memberIdCheck(id) == false && passwd.equals(checkPasswd)) {
						System.out.println("이미 사용중이거나 비밀번호가 일치하지 않습니다.");
						break; // switch break
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
					
				case 2 : // 로그인
					
				default:
					break;
			}


		}
	}
	
	// 프로그램 종료
	void terminate() {
		
	}

	// 회원 가입
	void join() {
		
	}
	
	// 로그인
	void login() {
		
	}

	// 회원목록 - 로그인한 회원이 관리자 일때만 노출 
	void select() {
		
	}
	
	// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	void update() {
		
	}
	
	// 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	void delete() {
		
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
	
	// 회원 아이디와 비밀번호로 회원 찾기
	Member findMember(Member m) {
		for(Member member : members) {
			if(member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}
	
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
