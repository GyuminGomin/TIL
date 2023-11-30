package Java.c12_collection_framework.c2_set;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {
	public static void main(String[] args) {
		String name1 = "김규민";
		String name2 = "김규민";
		String name3 = new String("김규민");
		System.out.println(name1 == name3); // 서로다른 위치에 있지만 저장하는 문자열이 같으므로 hashcode는 같다.
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		System.out.println(name3.hashCode());
		
		Member member1 = new Member(name1, 20);
		Member member2 = new Member(name2, 26);
		Member member3 = new Member(name3, 20);
		Member member4 = new Member("김규민", 23);
		
		Set<Member> setMembers = new HashSet<>();
		setMembers.add(member1);
		setMembers.add(member2);
		setMembers.add(member3);
		setMembers.add(member4);
		System.out.println(setMembers.size());
		System.out.println(setMembers); // hashcode와 equal를 따로 재정의 하지 않으면, 그냥 주소값을 비교하는 것과 같다.
		
		
	}
}

