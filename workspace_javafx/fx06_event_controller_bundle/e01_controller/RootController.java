package workspace_javafx.fx06_event_controller_bundle.e01_controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable {
	
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	

	public RootController() {
		System.out.println("RootController 생성");
		System.out.println(btn1);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Initialize 호출");
		System.out.println(btn1);
		System.out.println("FXML 위치 정보 : " + location);
		System.out.println(resources);
		
		btn1.setOnAction((e) -> {
			System.out.println("버튼 1 click");
			Button btn1 = (Button)e.getTarget();
			System.out.println(btn1.getId());
			System.out.println(btn1.getStyleClass());
		});
		
		System.out.println("Initialize 종료");
	} // initialize
	
	public void closeEvent() {
		System.out.println("closeEvent");
		Platform.exit();
	}
}
