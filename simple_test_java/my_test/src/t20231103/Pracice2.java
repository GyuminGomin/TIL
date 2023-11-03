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
    }
}
