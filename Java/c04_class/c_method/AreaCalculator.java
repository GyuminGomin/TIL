package Java.c04_class.c_method;

// 사각형의 넓이를 계산
public class AreaCalculator {
	
	// 정사각형의 넓이 계산
	int areaRectangle(int x) {
		return x * x;
	}
	// 직사각형의 넓이 계산
	int areaRectangle(int x, int y) {
		return x * y;
	}
	// 정밀도를 향상
	double areaRectangle(double x, double y) {
		return x * y;
	}
	
	// 두 수를 나눈 결과를 출력하는 메소드
	void divide(double num1, double num2) {
		if (num2 == 0) {
			System.out.println("나누는 수는 0이 될 수 없습니다.");
			return;
		}
		double result = num1 / num2;
		System.out.printf("%.1f / %.1f = %.1f", num1, num2, result);
	}
	
}

