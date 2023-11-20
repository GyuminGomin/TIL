package Java.c08_abstract_interface.interface_base;

public class RemoteControlExam {
	public static void main(String[] args) {
		
		RemoteControl airRemote;
		airRemote = new AirRemoteController();
		
		System.out.println(RemoteControl.MAX_VALUE);
		System.out.println(RemoteControl.MIN_VALUE);
		airRemote.turnOn();
		airRemote.setValue(11);
		airRemote.turnOff();
		
		RemoteControl rc = new TVRemoteControl();
		rc.turnOn();
		rc.setValue(20);
		rc.turnOff();
		
		RemoteControl smartRemote = new SmartTVRemoteControl();
		smartRemote.turnOn();
		smartRemote.setValue(10);
		smartRemote.turnOff();
		
//		smartRemote.search("슬램덩크");
		Searchable searchRemote = (Searchable)smartRemote;
		searchRemote.search("슬램덩크");
		
		if(searchRemote instanceof SmartTVRemoteControl) {
			SmartTVRemoteControl stc = (SmartTVRemoteControl)searchRemote;
			stc.turnOn();
			stc.setChannel(800);
			stc.turnOff();
		}
	}
}
