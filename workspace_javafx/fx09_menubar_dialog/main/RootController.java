package workspace_javafx.fx09_menubar_dialog.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{

	@FXML
	private ComboBox<String> comboBox;
	@FXML
	private TextArea textArea;
	
	private Stage primaryStage; // 현재 스테이지(Window)정보를 저장할 field
	
	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 콤보 박스 항목 선택 변경 감지 이벤트 리스너 추가
		comboBox.getSelectionModel().selectedIndexProperty().addListener((target, o, n) -> {
			// 새로 선택된 항목의 인덱스 번호
			int index = n.intValue();
			System.out.println("select comboBox : " + index);
			switch (index) {
				case 0 : // Directory Chooser
					// JavaFX에서 제공하는 폴더 선택 상자
					DirectoryChooser chooser = new DirectoryChooser();
					chooser.setTitle("디렉토리 선택 창 테스트");
//					chooser.setInitialDirectory(new File("C:\\temp")); // 디렉토리 시작 경로
					chooser.setInitialDirectory(new File("workspace_javafx/fx09_menubar_dialog/images")); // 상대경로
					File chooseDir = chooser.showDialog(primaryStage); // 이 창을 오픈한 사용자가 누구인지 지정하는 것
					System.out.println(chooseDir);
					if (chooseDir != null) {
						System.out.println(chooseDir.isDirectory());
						File[] files = chooseDir.listFiles(); // 폴더안에 있는 file 객체를 리스트 형태로 반환
						for(File f : files) {
							textArea.appendText(f.getName()+ "\n"); // 기존 TEXT를 유지한 상태로 추가
						}
					} else {
						System.out.println("선택된 디렉토리가 존재하지 않습니다.");
					}
					break;
				case 1 : // File Chooser
					// JavaFX에서 제공하는 파일 선택 상자
					FileChooser fChooser = new FileChooser();
					fChooser.setTitle("읽을 파일을 선택하세요");
					fChooser.setInitialDirectory(new File("c:\\Temp"));
					
					ObservableList<ExtensionFilter> filters = fChooser.getExtensionFilters();
					filters.add(new ExtensionFilter("Text Files", "*.txt","*.hwp","*.pdf"));
					filters.addAll(new ExtensionFilter("Image Files", "*.png","*.jpg","*.jpeg","*.gif"),
							new ExtensionFilter("All Files", "*.*")); // 확장자 설정
					
//					File selectedFile = fChooser.showOpenDialog(primaryStage);
					File selectedFile = fChooser.showSaveDialog(primaryStage); // 지정된 디렉토리에서 파일이름을 검색하면 지정된 경로에서 파일 이름을 반환
					if (selectedFile != null) {
						System.out.println(selectedFile.isFile());
						System.out.println(selectedFile.getAbsolutePath());
					}
					// 여러 파일을 선택할 수 있는 file chooser
					List<File> selectedFiles = fChooser.showOpenMultipleDialog(primaryStage);
					System.out.println(selectedFiles);
					break;
				case 2 : // PopUp
					Popup popup = new Popup();
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getResource("Popup.fxml"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					popup.setAutoHide(false); // 포커스가 이동하면 자동으로 숨기는 것(popup창 종료)
					
					ImageView imageView = (ImageView)root.lookup("#imgMessage");
					imageView.setOnMouseClicked(e-> {
						System.out.println("ImageView Mouse Clicked!!!");
						popup.hide(); // 이미지가 클릭되었을 때 popup창 닫아줌
					});
					Label lblMessage = (Label)root.lookup(".lblMessage");
					lblMessage.setText("메세지 알림!");
					popup.getContent().add(root);
					popup.show(primaryStage); // popup 창의 소유자가 누구인지
					break;
				case 3 : // Custom Window - Alert
					handleCustom();
					break;
			} // end switch
		}); // end comboBox selected Event
	} // end initialize

	// 사용자 정의형 dialog 생성
	private void handleCustom() {
		Stage stage = new Stage();
		// DECORATED - 기본값
		stage = new Stage(StageStyle.DECORATED); // 요소랑 장면을 투명하게 했어도 무대가 투명하지 않기 때문에 투명하지 않다.
		/*
		// UNDECORATED - 흰색 배경에 제목 줄 x
		stage.initStyle(StageStyle.UNDECORATED); // 객체 생성이 아닌 메소드로 스테이지 설정
		// UTILITY - 흰배경, 제목줄에 타이틀 종료 버튼만 존재
		stage.initStyle(StageStyle.UTILITY);
		// TRANSPARENT - 투명 배경, 제목줄 x
		stage.initStyle(StageStyle.TRANSPARENT); // 요소와 장면이 투명이 아니면 의미가 없다
		*/
		
		stage.setTitle("Custom Dialog");
		Parent parent = null;
		
		try {
			parent = FXMLLoader.load(getClass().getResource("Custom.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		stage.initOwner(primaryStage); // primaryStage를 새로 생성한 소유자 창으로 지정
		// Modality 지정 속성 : null, WINDOW_MODAL, APPLICATION_MODAL
		// WINDOW_MODAL : 소유자 창이 지정되어 있을 경우 소유자 창으로 소유권을 이동하지 않음
		// APPLICATION_MODAL : 전체 애플리케이션 창에서 소유권을 변경하지 않음
//		stage.initModality(Modality.WINDOW_MODAL); // Modality를 설정하기 전에 Owner가 없으면 창 이동이 자유롭다. Owner이 있어야 Modality를 설정 가능
		stage.initModality(Modality.APPLICATION_MODAL);
		
		Scene scene = new Scene(parent);
		scene.setFill(Color.TRANSPARENT); // 장면 배경을 투명하게 적용(Stage Transparent를 적용한걸 보기 위해)
		stage.setScene(scene);
		stage.show();
	}

	public void handleNew() {
		System.out.println("New");
	}
	
	public void handleOpen() {
		System.out.println("Open");
	}
	
	public void handleSave() {
		System.out.println("Save");
	}
	
	public void handleClose() {
		System.out.println("Close");
	}
}