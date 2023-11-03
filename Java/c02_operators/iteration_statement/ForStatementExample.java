package Java.c02_operators.iteration_statement;

public class ForStatementExample {
    public static void main(String[] args) {
        //		for(;;) System.out.println("for 문 수행"); // 무한 반복해서 주석처리함
                
                int i = 1;
                int sum = 0;
                for(;; i++) {
                    if(i > 10) {
                        break;
                    }
                    sum += i;
                }
                System.out.println("sum : " + sum);
                
                sum =0;
                for (i=3;i<=100; i+=3) {
        //			System.out.println(i);
                    sum += i;
                }
                System.out.println(sum);
                System.out.println(i);
                
            }
}
