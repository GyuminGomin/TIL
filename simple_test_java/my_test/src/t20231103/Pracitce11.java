package t20231103;

import java.util.Scanner;

public class Pracitce11 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 11번 문제
        while (true) {
            System.out.println("점수를 입력해주세요.");
            int score = sc.nextInt();

            switch (score/10) {
                case 10: case 9:
                    System.out.println("A");
                    break;
                case 8:
                    System.out.println("B");
                    break;
                case 7 :
                    System.out.println("C");
                    break;
                case 6 :
                    System.out.println("D");
                    break;
                default:
                    System.out.println("F");
                    break;
            }
            if (score > 100 || score < 0) break;
        }

        // 12번 문제
        for (int i=9; i>=2; i--) {
            for (int j=9; j>=2; j--) {
                System.out.print(i +" * "+j+" = "+i*j+"\t");
            }
            System.out.println("");
        }
    } //psvm
}
