package workspace_javafx.fx10_ui_thread.application;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RootController implements Initializable{
	
	@FXML
	private Label lblTime;
	@FXML
	private Button btnStart, btnStop;
	
	private boolean isRun = true; // timer 종료 flag
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnStart.setOnAction((e) -> {
			isRun = true;
			Stage stage = (Stage)lblTime.getScene().getWindow();
			stage.setTitle("Timer");
			System.out.println(Thread.currentThread());
			System.out.println(Thread.currentThread().isDaemon());
			
			Thread t = new Thread(() -> {
				System.out.println(Thread.currentThread());
				LocalTime time = LocalTime.of(0, 0, 0); // 0 시 0 분 0 초 cf. time.now() 현재시간
				while(isRun) {
					// 10 millis
					time = time.plusNanos(10000000); // 시간이 지나가면서 나노초만큼 더해줄것이다.
					
					String data = time.format(DateTimeFormatter.ofPattern("mm:ss:SS")); // 분, 초, 밀리세컨
//					System.out.println(data);
					/*
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							lblTime.setText(data);
						}
					}); // UI 스레드 충돌 방지
					*/
					Platform.runLater(()-> {
						lblTime.setText(data);
					});
					
					try {
						Thread.sleep(10); // 10 millis
					} catch (InterruptedException e1) {}
				}
			}); // end Thread Runnable run()
			t.setDaemon(true);
			t.start();
			
		}); // end btnStart
		
		btnStop.setOnAction(e-> {
			isRun = false;
		}); // end btnStop
	} // end initialize
	
	
}