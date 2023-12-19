package workspace_javafx.fx03_layout_basic.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// 기존 Swing 방식
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		// Container - 다른 요소를 담는 그릇
		// vertical box - 수직으로 요소를 배치하는 container
		VBox root = new VBox();
		root.prefWidth(350); // 폭 크기 설정
		root.prefHeight(150); // 높이 크기 설정
		
		// text 출력용 control
		Label label = new Label();
		label.setText("Hello JavaFX!!!");
		// Font - 글꼴 또는 크기를 설정하는 class
		label.setFont(new Font(50));
		
		Button btn = new Button(); // Button control 생성
		btn.setText("확인"); // Button title 지정
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit(); // UI 쓰레드 종료
			}
		}); // 사용자가 action을 취함
		
		// container에 포함할 자식 요소 목록을 저장하는 리스트
		ObservableList<Node> list = root.getChildren();
		list.add(label); // 자식 요소 리스트에 label 추가
		list.add(btn); // 자식 요소 리스트에 버튼 추가
		
		// VBox를 container로 지정하여 장면(Scene) 생성
		// Node(fx에서 사용하는 모든 UI 요소) > Parent(요소를 담는 컨테이너) > 요소 
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

