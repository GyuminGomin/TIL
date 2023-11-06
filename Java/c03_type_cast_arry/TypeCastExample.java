package Java.c03_type_cast_arry;

public class TypeCastExample {
    public static void main(String[] args) {
        byte b = 100;
		int i = b;
		// 자동 타입 변환
		
		byte result = (byte)i;
		// 강제 타입 변환(명시적)
		
		int eng = 99;
		int math = 90;
		int kor = 85;
		int subjectCount = 3;
		
		int sum = eng + math + kor;
		double avg = sum / (double)subjectCount;
		System.out.println(avg);
		
		char c1 = 97;
		System.out.print(c1);
		for(int i1 = 1; i1<=25;i1++) {
			System.out.print((char)(c1+i1));
		}
		// int형으로 리터럴되니까, char형으로 타입으로 형변환하면 문자열로 출력 가능
    }
}
