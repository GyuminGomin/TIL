package app_solution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
             Parent root = FXMLLoader.load(
                getClass().getResource("Root.fxml")
            );
            // Scene Size 삭제
            primaryStage.setScene(new Scene(root));
            // title 지정
            primaryStage.setTitle("App Main");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
