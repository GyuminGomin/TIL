package workspace_javafx.fx06_event_controller_bundle.e02_bundle;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		System.out.println(Locale.getDefault());
		// Locale 각 나라 지역의[언어][나라] 등의 공통 정보를 담고 있는 class
		// getAvailableLocales() : 사용 가능한 국가별 언어 코드 정보
		for(Locale locale : Locale.getAvailableLocales()) {
			// 한글 언어 이름
			System.out.printf("Display Language : %s, ", locale.getDisplayLanguage());
			// 언어 코드
			System.out.printf("Language Code : %s, ", locale.getLanguage());
			// 국가 이름
			System.out.printf("Country : %s, ", locale.getDisplayCountry());
			// 국가 코드, 국가/언어코드
			System.out.printf("Country Code : %s, code %s %n", locale.getCountry(), locale.toString());
		}
		
		System.out.println("======================================");
		Locale locale = Locale.getDefault();
		System.out.println(locale);
		Locale localeJP = new Locale("ja","JP");
		System.out.println(localeJP);
		Locale localeCN = new Locale("zh","CN");
		System.out.println(localeCN);
		Locale.setDefault(new Locale("en","US")); // en_US
		
		// prop.s (prop 패키지의 접두어가 s인 녀석) -> prop.s_ko_KR.properties 파일을 읽어옴
		ResourceBundle bundle = ResourceBundle.getBundle("workspace_javafx/fx06_event_controller_bundle/prop.s", new Locale("ko", "KR"));
		
		bundle = ResourceBundle.getBundle("workspace_javafx/fx06_event_controller_bundle/prop.s"); // Locale.setDefault 설정되어 있는 언어 국가코드 파일을 읽어옴
		Locale.setDefault(localeCN);
		bundle = ResourceBundle.getBundle("workspace_javafx/fx06_event_controller_bundle/prop.s");
		
		try {
			HBox root = (HBox)FXMLLoader.load(getClass().getResource("Bundle.fxml"),bundle);
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
