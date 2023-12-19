package workspace_javafx.fx05_event_handler.e02_event_fxml;

import java.io.IOException;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FXMLMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		try {
			HBox root = FXMLLoader.load(
				getClass().getResource("Root.fxml")
			);
			
			ObservableList<Node> list = root.getChildren();
			System.out.println(list.get(0));
			Node btn1 = list.get(0);
			Button btn = (Button)btn1;
			btn.setOnAction((e) -> {
				System.out.println("1번 버튼 클릭!!!");
			});
			
			Button lookUpBtn = (Button)root.lookup("#btn2"); // 이름으로 찾아보는 것
			System.out.println(lookUpBtn);
			lookUpBtn.setOnAction(e -> {
				System.out.println("버튼 2 click!!!");
			});
			
			Set<Node> btnLookUpAll = root.lookupAll("Button"); // 식별자와 일치하는 모든 요소를 반환
			System.out.println(btnLookUpAll);
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}