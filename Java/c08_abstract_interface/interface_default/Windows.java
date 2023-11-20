package Java.c08_abstract_interface.interface_default;

public class Windows {
	
	public void print(Printable printable) {
		printable.print(); // 이 기능이 있는지만 체크
	}
	
	public static void main(String[] args) {
		Windows windows = new Windows();
		LGPrinter lg = new LGPrinter();
		windows.print(lg);
		
		HPPrinter hp = new HPPrinter();
		windows.print(hp);
	}
}