package Java.c07_extends_inheritance.extends5_polymorphism.array;

public class VIPCustomer extends GoldCustomer{
	
	private int agentID; // 담당 직원
	
	public VIPCustomer(int customerId, String customerName, int agentID) {
		super(customerId, customerName);
		customerGrade = "VIP";
		this.bonusRatio = 0.05;
		super.saleRatio = 0.2;
		this.agentID = agentID;
	}
	
	public String toString() {
		return super.toString() + " 담당직원번호는 : " + this.agentID + "입니다.";
	}
}