import java.util.Scanner;

public class Practive6 {
    public static void main(String[] args) {
        char[][] lines = new char[10][10];

        // 대입
        for (int i = 0; i < lines.length; i++) {
            for (int j =0; j < lines[i].length; j++) {
                lines[i][j] = '□';
            }
        }
  
        while (true) {
            // 이미지 출력
            char A = 65;
            System.out.println("\n=====================================");
            System.out.println("\t    SCREEN\t    ");
            for (int i =0; i<10; i++) {
                System.out.print("["+(i+1)+"]");
            }
            System.out.println(" [행]");
            for (char line[] : lines) {
                for (char li : line) {
                    System.out.print("["+li+"]");
                }
                System.out.println("  ["+(char)(A) + "열]");
                A++;
            }
            // 구현
            Scanner sc = new Scanner(System.in);
            System.out.print("예약하실 좌석의 열을 입력해주세요. if(종료 : q) > ");
            char col = sc.next().charAt(0);
            if (col == 'q') {
                break;
            }
            if (col < 'A' || col >'J') {
                System.out.println("A열에서 J열 사이에서 선택해 주세요.");
                continue;
            }
            System.out.print("입력한 열 : "+ col +"\n");
            System.out.print("예약하실 좌석의 행 번호를 입력해주세요. > ");
            int row = sc.nextInt();
            System.out.println("선택하신 좌석은 : "+col+"열 "+row+"행 입니다.");
            System.out.print("예약 완료 하시겠습니까? y/n > ");
            char booked = sc.next().charAt(0);
            if (booked == 121) { // y : 121 , n : 110
                A = 65;
                if (lines[col-A][row-1] == '■') {
                    System.out.println("이미 예약이 완료된 좌석입니다.");
                    System.out.println("다시 선택해주세요.");
                    continue;
                }
                System.out.println("예약이 완료되었습니다.");

                // 대입
                lines[col-A][row-1] = '■';
                // 이미지 출력
                System.out.println("\n=====================================");
                System.out.println("\t    SCREEN\t    ");
                for (int i =0; i<10; i++) {
                    System.out.print("["+(i+1)+"]");
                }
                System.out.println(" [행]");
                for (char line[] : lines) {
                    for (char li : line) {
                        System.out.print("["+li+"]");
                    }
                    System.out.println("  ["+(char)(A) + "열]");
                    A++;
                }
            } else {
                System.out.println("예약 취소되었습니다.");
            }
        } // while 종료
    } // main 종료
}
