package t20231103_answer;

import java.util.Scanner;

public class Practice01StringPrint {
    public static void main(String[] args) {
        // System.out == 운영체제의 터미널과 연결된 객체
		/*
		 print();   - 넘겨받은 값을 출력하고 줄바꿈을 하지않음.
		 println(); - 출력하고 줄바꿈을 자동으로 처리함.
		 printf();  - 지정된 형식에 따라 출력
		*/
        
        /*
			escape 문자
			\'
			\"
			\r   캐리지 리턴
			\n   new line or line feed
			\t   "\t안녕" -> tab키를 눌린거 만큼 간격을 표현
			\\	 역슬러쉬 라는 특수문자 표현
		*/
        
        /*
			데이터 타입 형식 지정
			%d - int 10진법의 정수
			%o - 8진법 정수
			%x - 16진법 정수
			%b - boolean 타입
			%f - float - 실수형태로 출력(소수점 자리)
			%c - Character  하나의 문자
			%s - String 문자열
			%n - new line 줄바꿈 표현
			
			Optional
			%[-][0][n][.m][,n] 
			%[-] : 전체 자리수가 지정된 경우 왼쪽으로 정렬하고 빈칸에 공백 출력
			%-5d, 1000 == 1000[ ]
			%[{number}] : 출력할 전체 자리수를 지정(오른쪽 정렬)
			%5d , 1000 == [ ]1000
			%[0] : 전체 자리수가 지정되어 있을 때 빈자리를 0으로 표현
			%05d , 1000 == 01000
			%[.{number}] : 소수점 자래 자리수를 지정. 잘리는 소수점 자리는 반올림하여 표현
			%.2f , 82.687 == 82.69
			%[,] : 정수의 자리수 표현
			%,08d , 1000000 == 01,000,000
		*/

        String title = "Java";
		int price = 10000000; // 0,7개
		System.out.printf("%s의 교재는 %,020d입니다. %n",title,price);
		System.out.printf("%s의 교재는 %-,20d입니다. %n",title,price);
        // -와 0은 같이 쓸 수 없음. (왼쪽정렬과 공백을 0으로 채우면 숫자가 달라지기 때문)
		
		System.out.printf("%f %n",1234.123);
		System.out.printf("%,.2f %n",1234.123);
        // %f는 소수점 7자리에서 반올림한다는 의미

        // 문자열(String)의 동등 비교
		String name1 = "김규민";
		String name2 = "김규민";
		
		System.out.printf("name1 : %s %n", name1);
		System.out.printf("name2 : %s %n", name2);
        System.out.printf("name1 == name2 : %b %n", (name1 == name2));

        String name3 = new String("김규민");
        System.out.printf("name3 : %s %n", name3);
        System.out.printf("name1 == name3 : %b %n", (name1 == name3));

        String name4 = "홍길동";
        System.out.printf("name4 : %s %n", name4);
        System.out.printf("name1 == name4 : %b %n", (name1 == name4));
		/*
			메소드 영역                 	       
			Constant Pool( 김규민 ) -------------------------
			_______________________________________________	|
			Heap 영역                	 |Stack 영역		|
			김규민 (0x001)				 |					|
										|					|
										|name3 0x001		|
										|name2 <--------------
										|name1 <--------------
			다른 데이터 영역에서 가져오기 때문에 값이 다르다
		 */
		// 문자열 데이터가 일치하는지 비교할 때는 equals() 함수를 이용
		boolean isEquals = name1.equals(name3);
		System.out.println(isEquals);

		Scanner sc = new Scanner(System.in);
		// 사용자에게 id와 password를 입력받아 임의로 지정한 값과 일치하는지 비교하는 조건문
		String uid = "id001";
		String upw = "pw001";

		System.out.println("ID를 입력해 주세요 > ");
		String id = sc.next();
		System.out.println("비밀번호를 입력해 주세요 >");
		String pw = sc.next();

		System.out.println("입력하신 ID : " + id);
		System.out.println("입력하신 PW : " + pw);

		// 비교
		// if(uid == id && upw == pw) {
		if(uid.equals(id) && upw.equals(pw)) {
			System.out.println("정상적으로 로그인 되었습니다.");
		} else {
			System.out.println("아이디와 패스워드가 일치하지 않습니다.");
		}
    }
}
