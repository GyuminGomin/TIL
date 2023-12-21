package workspace_javafx.fx08_controls.c01_button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ButtonController implements Initializable{

	@FXML
	private BorderPane root;
	@FXML
	private CheckBox chk1, chk2;
	@FXML
	private ToggleGroup group;
	@FXML
	private ImageView chkImg, radioImg;
	@FXML
	private Button btnExit;
	@FXML
	private Hyperlink hyperLink;
	
	@Override
	public void initialize(URL arg0, ResourceBundle bundle) {
		chk1.setOnAction((e) -> {
			handlerChkAction(e);
		});
		
		chk2.setOnAction((e) -> {
			handlerChkAction(e);
		});
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> target, Toggle oldValue, Toggle newValue) {
				RadioButton value = (RadioButton)newValue;
				String text = value.getText();
				System.out.println(text);
				text = "/workspace_javafx/fx08_controls/images/"+text+".png";
				System.out.println(text);
				String path = getClass().getResource(text).toString();
				Image image = new Image(path);
				radioImg.setImage(image);
			}
		}); // end toggle
		
		btnExit.setOnAction((e) -> {
			// 시스템 group에 있는 thread 종료
			System.exit(0); // 강제종료이므로 어떤 상황에서도 즉시 자바 프로그램 종료
			// UI thread 종료
			// Platform.exit();
		});
		
		hyperLink.setOnAction(e-> {
			System.out.println("hyperLink");
			// hyperLink.setUserData(new String("https://www.naver.com"));
			String link = (String)hyperLink.getUserData();
			System.out.println(link);
			
			// 도메인 정보를 가지고 웹 화면을 애플리케이션에 출력하는 View
			WebView webView = new WebView();
			WebEngine we = webView.getEngine();
			we.load(link);
			
			// root.setTop(webView); // 현재 화면 제일 위에 (즉, Border Container top)
			
			// WebView를 보여주기 위한 무대 생성
			Stage stage = new Stage();
			BorderPane pane = new BorderPane();
			pane.setCenter(webView);
			stage.setScene(new Scene(pane));
			stage.setWidth(1074);
			stage.setHeight(700);
			stage.show();
		});
	} // end initialize
	
	// checkbox check 시 이미지 변경
	public void handlerChkAction(ActionEvent event) {
		boolean isCheck1 = chk1.isSelected();
		boolean isCheck2 = chk2.isSelected();
		System.out.println("1 : " + isCheck1);
		System.out.println("2 : " + isCheck2);
		
		// geek-glasses.gif 안경
		// geek-glasses-hair.gif 안경 모자
		// geek-hair.gif 모자
		// geek.gif 둘다 없음
		String resource = "";
		if(isCheck1 && isCheck2) {
			resource = "/workspace_javafx/fx08_controls/images/geek-glasses-hair.gif";
		} else if (isCheck1) {
			resource = "/workspace_javafx/fx08_controls/images/geek-glasses.gif";
		} else if (isCheck2) {
			resource = "/workspace_javafx/fx08_controls/images/geek-hair.gif";
		} else {
			resource = "/workspace_javafx/fx08_controls/images/geek.gif";
		}
		// 지정된 이미지 경로로 ImageView의 이미지 변경
		URL url = getClass().getResource(resource);
		chkImg.setImage(new Image(url.toString()));
	} // end handlerChkAction
	
}
