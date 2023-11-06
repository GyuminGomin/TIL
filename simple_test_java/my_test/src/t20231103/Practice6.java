package t20231103;

import java.util.Scanner;

public class Practice6 {
    public static void main(String[] args) {
        // 6번 문제
        double result = 0;
        result = (10.0 + 5) * 7 / 2;
        System.out.println(result);

        // 7번 문제
        Scanner sc = new Scanner(System.in);
        System.out.println("사원명을 입력하세요 >");
        String name = sc.next();
        System.out.println("시급을 입력하세요 >");
        int bill = sc.nextInt();
        System.out.println("근무시간을 입력하세요 >");
        int time = sc.nextInt();
        System.out.println("급여 명세서");
        System.out.println("사원명:"+name);
        System.out.println("급여금액: "+ (bill*time) +"원");
        System.out.println("공제금액: "+ (bill*time)/100*3+"원");
        System.out.println("실지급액: "+ (bill*time)/100*97+"원");

        // 8번 문제
        short s1 = 100;
        short s2 = 200;
        // short res = s1+s2;
        // int res = s1+s2;
        short res = (short)(s1+s2);
        System.out.println(res);

        // 9번 문제
        System.out.print("첫번째 정수: ");
        int fir = sc.nextInt();
        System.out.print("두번째 정수: ");
        int sec = sc.nextInt();
        int re = (fir >= sec) ? fir : sec; // 3항 연산자
        System.out.println("큰 수는 "+ re);

        // 10번 문제
        int sum = 0;
        for (int i=0;i<5;i++){
            System.out.print("성적을 입력하시오.:");
            sum += sc.nextInt();
        }
        System.out.println("평균 성적은"+sum/5+"입니다.");
        
    }
}
