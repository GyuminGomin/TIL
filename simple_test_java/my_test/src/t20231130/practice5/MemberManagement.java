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
            System.out.println("메뉴선택 >");
            if(sc.hasNextInt()) {
                selectNo = sc.nextInt();
            } else {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }
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
        String name = getStringData("이름을 입력해주세요");

        System.out.println("회원가입 완료");

    }

    @Override
    protected void login() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    protected void select() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }

    @Override
    protected void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    protected void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    protected void deleteMember() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMember'");
    }
    
}
