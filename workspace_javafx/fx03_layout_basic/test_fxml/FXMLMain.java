package workspace_javafx.fx03_layout_basic.test_fxml;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		try {
			java.net.URL url = getClass().getResource("Test.fxml"); // 해당되는 클래스 위치에서 외부 자원을 찾는 것
			Parent root = FXMLLoader.load(url);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
