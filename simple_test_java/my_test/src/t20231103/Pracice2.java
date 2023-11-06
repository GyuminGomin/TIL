package t20231103;

import java.util.Scanner;

public class Pracice2 {
    public static void main(String[] args) {
        // 2번 문제
        String str = "HELLO JAVA";
        System.out.println(str);

        // 3번 문제
        double radius = 0;
        double area = 0;
        System.out.println("반지름을 입력하시오:");
        Scanner sc = new Scanner(System.in);
        radius = sc.nextInt();
        area = radius * radius * 3.14;
        System.out.println(area);

        // 4번 문제
        int result = 0;
        for (int i=1;i<=10;i++) {
            result += i;
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("합: "+ result);
    
        // 5번 문제
        result = 0;
        for (int i=1;i<=100;i+=2) {
            result += i;
        }
        System.out.println("홀수의 합: " + result);
    }
}
