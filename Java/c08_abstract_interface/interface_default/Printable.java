package Java.c08_abstract_interface.interface_default;

public interface Printable {
	void print();
	default void colorPrint() {}; // 필요한 사람만 쓸 수 있게 (필요한 메서드만 재정의 하여 쓸 수 있게끔)
}
