package simple_test_java.my_test.src.t20231124;

import java.util.Scanner;

public class practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("문자열을 입력해 주세요>>");
            String input = sc.next();
            // indexOf (존재하지 않으면 -1)
            if (input.indexOf("java") == -1) {
                System.out.println("java가 존재하지 않습니다.");
            } else {
                System.out.println("자바가 존재 합니다.");
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
        
    }
}
