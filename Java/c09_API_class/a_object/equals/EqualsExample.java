package Java.c09_API_class.a_object.equals;

import Java.c09_API_class.a_object.toString.ToStringExample;

public class EqualsExample {
	public static void main(String[] args) {
		/*
		 	Eclispe > Window > Perferences > Java > Code Style > Code Template > Code > Method Body
		 	// TODO code 어쩌고 저쩌고 edit 눌러 제거 후 Apply and Exit
		*/
		Member member = new Member("id001");
		Member member1 = new Member("id002");
		Member member2 = new Member("id001");
		
		// 주소값 비교
		System.out.println(member == member1);
		System.out.println(member == member2);
		
		// 두 객체간 의미있는 데이터를 비교
		System.out.println(member.equals(member1));
		System.out.println(member.equals(member2));
		System.out.println(member.equals(null));
		System.out.println(member.equals(new ToStringExample()));
	}
}