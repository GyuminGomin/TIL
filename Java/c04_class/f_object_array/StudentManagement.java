package Java.c04_class.f_object_array;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student[] students = null;
		
        Loop1 :
		while(true) {
			System.out.println("====================================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("====================================");
			
			System.out.print("메뉴 번호를 입력해 주세요 > ");
			int selectNo = sc.nextInt();
			
			/*
			 	1. 학생수를 입력받아 Student 객체가 저장될 students 배열 생성
			 		- 입력 받은 학생 수 만큼
			 	2. 생성된 students 배열의 항목 수만큼 학생의 정보를 입력받아 저장
			 		- 학번(int), 이름(String), 점수(int)
			 	3. students 배열에 저장된 학생들의 정보(field data)를 출력
			 	4. students 배열에 저장된 학생들의 점수를 전체합계, 평균을 구해서 출력
			 		- students 배열에 저장된 학생들의 점수 중에서 최고 득점자 이름, 최저 득점자 이름 출력
			 	5. 종료
			 */
			if (students == null) {
                if (selectNo >= 2 && selectNo <=4) {
                System.out.println("학생 수 부터 입력해주세요.");
                selectNo = 1;
                }
            }
            if (students != null) {
                if (students[0] == null) {
                    if (selectNo >=3 && selectNo<=4) {
                        System.out.println("학생 정보를 입력해주세요.");
                        selectNo = 2;
                    }
                }
            }

			switch (selectNo) {
				case 1 :
					System.out.print("학생 수 입력 > ");
                    int stuNum = sc.nextInt();
                    students = new Student[stuNum];
                    break;
                case 2 :
                    System.out.println("학생 정보 입력");
                    for (int i=0; i<students.length; i++) {
                        System.out.println("====================================");
                        System.out.print("학생 "+(i+1)+"(학번) : ");
                        int stuId = sc.nextInt();
                        System.out.print("학생 "+(i+1)+"(이름) : ");
                        String stuName = sc.next();
                        System.out.print("학생 "+(i+1)+"(점수) : ");
                        int stuScore = sc.nextInt();
                        students[i] = new Student(stuId, stuName, stuScore);
                    }
                    break;
                case 3 :
                    System.out.println("학생 정보 확인");
                    System.out.println("====================================");
                    for (int i=0; i<students.length; i++) {
                        System.out.println("학생 "+(i+1)+" " + students[i].getInfo());
                    }
                    break;
                case 4 :
                    System.out.println("분석");
                    System.out.println("====================================");
                    int totalScore = 0; // 전체
                    for (int i = 0; i<students.length; i++) {
                        totalScore += students[i].score;
                    }
                    double meanScore = (double)totalScore/students.length; // 평균
                    String topStuName = null;
                    String lowStuName = null;
                    int topStuScore = 0;
                    int lowStuScore = 100;
                    for (int i = 0; i<students.length; i++) {
                        if (topStuScore <= students[i].score) {
                            topStuScore = students[i].score;
                            topStuName = students[i].name;
                        } // 최고 득점자
                        if (lowStuScore >= students[i].score) {
                            lowStuScore = students[i].score;
                            lowStuName = students[i].name;
                        } // 최소 득점자
                    }
                    System.out.println("전체 합계 : "+ totalScore);
                    System.out.println("평균 : "+ meanScore);
                    System.out.println("최고 득점자 : "+ topStuName);
                    System.out.println("최소 득점자 : "+ lowStuName);
                    break;
                case 5 :
                    break Loop1;
                default :
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
                    break;
			}
			
		}
	}
}
