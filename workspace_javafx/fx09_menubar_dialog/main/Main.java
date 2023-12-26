package workspace_javafx.fx09_menubar_dialog.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
			Parent root = loader.load(); // 컨트롤러 정보도 같이 포함되어 있다. (FXML에 정의된 Container 인스턴스 반환)
			Scene scene = new Scene(root);
			RootController control = loader.getController(); // FXML 파일과 함께 load 된 Controller 인스턴스 반환
			// Controller의 FXML 정보가 출력되는 무대 정보 저장
			control.setStage(primaryStage);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
