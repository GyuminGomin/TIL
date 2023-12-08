package Java.c14_nested_class_lambda.ex02_nested_interface;

public class CallListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}
}
