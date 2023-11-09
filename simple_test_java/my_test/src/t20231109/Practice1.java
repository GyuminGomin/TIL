import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 3, 60, -3, 50};
        // p 1
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == 60) {
                System.out.println(i);
            }
        }

        // p 2
        for (int i=0; i<arr.length; i++) {
            if (i != 3){
                System.out.print(arr[i]+ " ");
            }
        }
        System.out.println();

        for (int ar : arr) {
            if (ar != arr[3]) System.out.print(ar + " ");
        }
        System.out.println(); // 이것은 주소값이 아니라 그냥 값만을 비교

        // p 3
        Scanner sc = new Scanner(System.in);

        System.out.print("입력받은 인덱스 번호 : ");
        int idxNum = sc.nextInt();
        System.out.println(arr[idxNum]);

        // p 4
        System.out.print("인덱스 : ");
        int idx1 = sc.nextInt();
        System.out.print("인덱스 : ");
        int idx2 = sc.nextInt();
        int[] arr2 = arr.clone();
        int tmp = arr2[idx1];
        arr2[idx1] = arr2[idx2];
        arr2[idx2] = tmp;
        for (int ar : arr2) {
            System.out.print(ar + " ");
        }

    }
}
