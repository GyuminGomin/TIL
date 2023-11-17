package Java.c07_extends_inheritance.extends5_polymorphism.array;

public class GoldCustomer extends Customer {

	double saleRatio; // 할인율
	
//	public GoldCustomer() {super();} // Customer의 기본생성자를 가져오는데, 존재하지 않아 발생하는 오류
	public GoldCustomer(int customerId, String customerName) {
		super(customerId, customerName);
		super.customerGrade = "GOLD";
		super.bonusRatio = 0.02;
		this.saleRatio = 0.1;
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += (price * bonusRatio);
		return price - (int)(price * saleRatio);
	}
}
