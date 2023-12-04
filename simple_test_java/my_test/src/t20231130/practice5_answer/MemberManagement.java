package simple_test_java.my_test.src.t20231130.practice5_answer;
 
/**
 * AppBase의 기능을 구현한 자식 class
 * AppBase의 기능을 상속받아 제시된 기능을 완성하시오.
 */
public class MemberManagement extends AppBase
{

    @Override
    protected void terminate() {
        isRun = false;
    }

    @Override
    protected void join() {
        
        while (true) {
            String mId = getStringData("아이디를 입력해 주세요 > ");

            if (!memberIdCheck(mId)) { // 중복된 아이디
                System.out.println("사용할 수 없는 아이디입니다. 다시 입력해주세요.");
                continue;
            }

            String pw = getStringData("비밀번호를 입력해 주세요 >");
            String rePw = getStringData("비밀번호를 한번 더 입력해 주세요 > ");
            
            if (!pw.equals(rePw)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }

            // 회원가입 진행
            String name = getStringData("이름을 입력해 주세요.");

            Member m = new Member(number++,name,mId,pw,System.currentTimeMillis()); // 회원목록 정보를 저장하는 리스트에 추가
            memberList.add(m);
            System.out.println("회원가입이 완료되었습니다.");
            break;
        } // end while
    } // end join

    @Override
    protected void login() {
        String mId = getStringData("아이디를 입력해주세요 >");
        String mPw = getStringData("비밀번호를 입력해주세요> ");
        Member temp = new Member(mId, mPw);
        Member member = findMember(temp);
        if (member == null) {
            System.out.println("일치하는 정보가 없습니다. (로그인 실패)");
            return;
        }

        loginMember = member;
        System.out.println("정상적으로 로그인 되었습니다.");
        if (loginMember.equals(master)) {
            System.out.println("관리자계정입니다.");
        }
    } // end login

    @Override
    protected void select() {
        
        if (loginMember == null) {
            System.out.println("로그인 이후 사용할 수 있는 메뉴입니다.");
            return;
        }

        if (loginMember.equals(master)) {
            for (Member m : memberList) {
               System.out.println(m);
            }
        } else {
            System.err.println(loginMember);
        }
        
    }

    @Override
    protected void update() {
        
        if (loginMember == null) {
            System.out.println("로그인 이후 사용가능한 메뉴입니다.");
            return;
        }

        if (loginMember.equals(master)) {
            System.out.println("== 관리자 회원 정보 수정 ==");
            select(); // 회원 목록 정보 출력
            int mNum = getNumberData("수정할 회원 번호를 입력해주세요 >");
            for (Member m : memberList) {
                if (m.getmNum() == mNum) { // 수정할 회원 정보 검색
                    String name = getStringData("수정할 회원의 이름을 입력해 주세요. > ");
                    m.setmName(name);
                    System.out.println("수정 완료");
                    return;
                }
            } // end for

            // 회원번호가 일치하는 Member를 찾지 못함
            System.out.println("수정할 회원 정보를 찾지 못했습니다.");

        } else {
            System.out.println("== 내 정보 수정 ==");
            String pw = getStringData("비밀번호를 입력해주세요 > ");

            if(!loginMember.getmPw().equals(pw)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                return;
            }

            // 비밀번호가 일치
            String name = getStringData("수정할 이름을 입력해주세요 > ");
            loginMember.setmName(name);
            System.out.println("수정이 완료되었습니다.");
            System.out.println(loginMember);
        }

    } // end update

    @Override
    protected void delete() {
        
        if (master.equals(loginMember)) {
            System.out.println("회원정보를 삭제할 수 없습니다.");
            return;
        }

        String answer = getStringData("정말로 삭제하시겠습니까? y/n");
        switch (answer) {
            case "y":
                deleteMember();
                break;
            default:
                System.out.println("회원정보 삭제(탈퇴)가 취소되었습니다.");
                break;
        }


    }

    @Override
    protected void deleteMember() {
        memberList.remove(loginMember);
        loginMember = null;
        number--;
        System.out.println("회원 탈퇴 완료");
    }
    
}
