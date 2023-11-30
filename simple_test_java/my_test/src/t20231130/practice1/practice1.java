package simple_test_java.my_test.src.t20231130.practice1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class practice1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >>");
        String in = sc.nextLine();
        System.out.println("입력완료");
        List<String> al = new ArrayList<>();
        double total = 0;
        double mean = 0;
        String[] st = in.split(" ");
        for (String s : st) {
            al.add(s);
        }

        for (String s : al) {
            switch (s) {
                case "A":
                    total += 4;
                    break;
                case "B" :
                    total += 3;
                    break;
                case "C" :
                    total += 2;    
                    break;
                case "D" :
                    total += 1;
                    break;
                case "F" :
                    break;
                default:
                    break;
            }
        }
        mean = total/al.size();
        System.out.printf("평균은 : %.2f \n", mean);
        System.out.println("시스템 종료");
    }
}
