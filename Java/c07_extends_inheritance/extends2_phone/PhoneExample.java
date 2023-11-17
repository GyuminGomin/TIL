package Java.c07_extends_inheritance.extends2_phone;

public class PhoneExample {
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.powerOn();
		phone.bell();
		phone.sendVoice("여보세요!");
		phone.receiveVoice("로또 `당첨번호 알려드립니다~`");
		phone.hangUp();
		phone.powerOff();
		
		DMBPhone dmbPhone = new DMBPhone("가로본능", "SILVER", 11);
		System.out.println(dmbPhone.model);
		System.out.println(dmbPhone.color);
		dmbPhone.powerOn();
		dmbPhone.turnOnDMB();
		dmbPhone.changeChannel(8);
		dmbPhone.turnOffDMB();
		dmbPhone.powerOff();
	}
}

