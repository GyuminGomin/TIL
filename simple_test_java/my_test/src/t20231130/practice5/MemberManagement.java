package simple_test_java.my_test.src.t20231130.practice5;
 
public class MemberManagement extends AppBase
{

    @Override
    protected void isRun() {
        System.out.println("프로그램 시작!");
        while (isRun) {
            System.out.println("=================================");
            System.out.println("1.회원가입|2.로그인|3.회원정보|4.회원정보수정|5.회원탈퇴|6.종료");
            System.out.println("=================================");
            selectNo = getNumberData("메뉴 선택 >>");
            switch (selectNo) {
                case 1:
                    join();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    // 회원정보에 따라 다른 함수 구현 delete 또는 deletemem
                    break;
                case 6:
                    terminate();
                    break;
                default:
                    System.out.println("잘못된 입력값을 선택하셨습니다.");
                    break;
            }
        }
        
    }

    @Override
    protected void terminate() {
        System.out.println("프로그램 종료");
        isRun = false;
    }

    @Override
    protected void join() {
        System.out.println("== 회원가입 ==");
        String id = getStringData("아이디를 입력해주세요");
        String pwd = getStringData("비밀번호를 입력해주세요.");
        String pwdChk = getStringData("비밀번호를 한번 더 입력해주세요.");
        Member m = new Member(id, pwd);
        if(!pwd.equals(pwdChk) || !memberIdCheck(id)) {
            System.out.println("사용할 수 없는 아이디 이거나 비밀번호가 일치하지 않습니다.");
            return;
        };
        String name = getStringData("이름을 입력해주세요");
        memberList.add(new Member(number++, name, id, pwd, System.currentTimeMillis()));
        System.out.println("회원가입 완료");

    }

    @Override
    protected void login() {
        System.out.println("== 로그인 ==");
        String id = getStringData("아이디를 입력해주세요 >");
        String pwd = getStringData("비밀번호를 입력해주세요 >");
        loginMember = findMember(new Member(id, pwd));
        if (loginMember == null) {
            System.out.println("일치하는 회원 정보가 없습니다.");
        } if (loginMember == master) {
            System.out.println("정상적으로 로그인 되었습니다.");
            System.out.println("관리자 계정입니다.");
            System.out.println(master);
        } else {
            System.out.println("정상적으로 로그인 되었습니다.");
        }
    }

    @Override
    protected void select() {
        System.out.println("== 회원정보 ==");
        if (loginMember == master) {
            for (Member m : memberList) {
                System.out.println(m);
            }
        } else {
            System.out.println(loginMember);
        }
    }

    @Override
    protected void update() {
        System.out.println("== 회원정보수정 ==");
        if (loginMember == master) {
            System.out.println("== 관리자 회원정보 수정 ==");
            for (Member m : memberList) {
                System.out.println(m);
            }
            int num = getNumberData("수정할 회원 번호를 입력해 주세요.");
            if (!(num>0 && num<=memberList.size())) {
                System.out.println("번호를 잘못 입력했습니다.");
                return;
            }
            String name = getStringData("수정할 회원의 이름을 입력해 주세요 > ");
            memberList.get(num).setmName(name);
            System.out.println("수정완료");
        } else {
            System.out.println("== 내 정보 수정 ==");
            String pwd = getStringData("비밀번호를 한번더 입력해 주세요.");
            if (!loginMember.equals(new Member("", pwd))) {
                System.out.println("비밀번호가 맞지 않습니다.");
            } else {
                String name = getStringData("수정할 이름을 입력해주세요 > ");
                loginMember.setmName(name);
                System.out.println(loginMember);
                System.out.println("수정이 완료되었습니다.");
            }
        }
    }

    @Override
    protected void delete() {
        System.out.println("== 회원탈퇴 ==");
        if (loginMember == master) {
            System.out.println("회원정보를 삭제할 수 없습니다.");
            return;
        }
        String y = getStringData("정말로 삭제 하시겠습니까? y/n");
        if (y.equals("y") || y.equals("yes") || y.equals("Y")) {
            deleteMember();
            System.out.println("회원탈퇴 완료");
        }
    }

    @Override
    protected void deleteMember() {
        memberList.remove(loginMember);
        loginMember = null;
    }
    
}
