package simple_test_java.my_test.src.t20231124;

import java.util.Arrays;
import java.util.Scanner;

public class practice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자나 숫자를 입력하세요: ");
        String str = sc.next();
        System.out.println("입력받은 문자: " + str);
        // byte[] bytes = str.getBytes(); // 한글은 3바이트
        char[] chars = str.toCharArray(); // 문자로 바꿔서 저장
        boolean isEng = false;
        boolean isNum = false;
        // System.out.println(Arrays.toString(bytes));
        // System.out.println(Arrays.toString(chars));
        // System.out.println(bytes);
        // System.out.println(chars);
        

        if (chars[0] >= 200) { // 한국어
            isEng = false;
            isNum = false;
        } else if ((chars[0] >=65 && chars[0] <91) || (chars[0] >= 97 && chars[0] <123)) {
            isEng = true;
            isNum = false;
        } else if ((chars[0] >=48 && chars[0] <57)) {
            isEng = false;
            isNum = true;
        } else {
            System.out.println("존재하는 값이 없습니다.");
        }
        
        System.out.println("영어문자 : " + isEng);
        System.out.println("숫자 : " + isNum);
        
        sc.close();
    }
}
