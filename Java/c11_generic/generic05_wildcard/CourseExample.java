package Java.c11_generic.generic05_wildcard;

import java.util.Arrays;

public class CourseExample {
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<>("일반인과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		personCourse.add(new Worker("직장인"));
//		personCourse.add(new Object()); // Person 타입 객체만 들어올 수 있다.
		personCourse.add(new Person("일반인2"));
		
		Course<Student> studentCourse = new Course<>("학생 과정", 5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
//		studentCourse.add(new Worker("직장인"));
//		studentCourse.add(new Person("일반인"));
		
		Course<HighStudent> highStudentCourse = new Course<>("고등학생 과정", 3);
		highStudentCourse.add(new HighStudent("고등학생"));
//		highStudentCourse.add(new Student("일반학생"));
		
		Course<Worker> workerCourse = new Course<>("재직자 과정", 3);
		workerCourse.add(new Worker("직장인"));
//		workerCourse.add(new Student("학생"));
		
		System.out.println("=====================================");
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		
		System.out.println("=====================================");
		registerStudent(highStudentCourse);
		registerStudent(studentCourse);
//		registerStudent(workerCourse);
		
		System.out.println("=====================================");
		registerWorker(workerCourse);
		registerWorker(personCourse);
//		registerWorker(studentCourse);
		Course<Object> objCourse = new Course<>("전체 교육 과정", 50);
		registerWorker(objCourse);
	} // end main
	
	
	public static void registerCourse(Course<?> course) {
		System.out.println("["+course.getName()+" 수강생]");
		for (int i=0; i < course.getStudents().length; i++) {
			System.out.print(course.getStudents()[i]+" ");
		}
		System.out.println();
	}
	// Course<? extends Student> : student 또는 student 하위 객체로 제네릭 타입 제한
	public static void registerStudent(Course<? extends Student> course) {
		System.out.println("["+course.getName()+" 수강생]");
		System.out.println(Arrays.toString(course.getStudents()));
	}
	// Course<? super Worker> : Worker 이거나 Worker의 상위 class로 제네릭 타입 제한
	public static void registerWorker(Course<? super Worker> course) {
		System.out.println("["+course.getName()+" 수강생]");
		System.out.println(Arrays.toString(course.getStudents()));		
	}
}
