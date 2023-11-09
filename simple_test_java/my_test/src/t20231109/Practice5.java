import java.util.Scanner;

public class Practice5 {
    public static void main(String[] args) {
        // p 5
        final int size = 10;
        int[] seats = new int[size];

        while (true) {
            System.out.println("----------------------------");
            for (int i = 0; i < size; i++) {
                System.out.print(i+1 + " ");
            }
            System.out.println("\n----------------------------");
            for (int i = 0; i < size; i++) {
                System.out.print(seats[i] + " ");
            }
            System.out.println("\n----------------------------");

            System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1): ");
            Scanner scan = new Scanner(System.in);
            int s = scan.nextInt(); // 좌석 입력
            if (s == -1) break;
            seats[s-1] = 1;
            System.out.println("예약되었습니다.");

            
        }
    }
}
