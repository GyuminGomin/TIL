package Java.c08_abstract_interface.interface_default;

public class LGPrinter implements Printable{

	@Override
	public void print() {
		System.out.println("LG 프린터기가 출력됩니다.");
	}

	@Override // LG는 컬러프린터기를 만들었고, HP는 못 만들었을 때
	public void colorPrint() {
		System.out.println("LG 프린터기가 Color를 출력합니다.");
	}	
}
