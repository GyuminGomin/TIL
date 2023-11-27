package simple_test_java.my_test.src.t20231124;

public class practice5 {
    public static void main(String[] args) {
        
        String scores = "100,11,35,41";
        // 총점과 평균
        int total = 0;
        double avg = 0.0;
        //작성
        String[] score = scores.split(",");
        
        for (String s : score) {
            int sco = Integer.valueOf(s); // valueOf는 객체타입 반환, parse는 기본타입 반환
            total += sco;
        }
        avg = (double)total/score.length;

        System.out.println(scores);
        System.out.println("총점: " + total + "점");
        System.out.printf("평균: %.1f점", avg);
    }
}
