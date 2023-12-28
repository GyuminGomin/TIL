package app_solution;

import java.net.URL;
import java.util.ResourceBundle;

import app_solution.model.StudentVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PieChartController implements Initializable{

    @FXML
    private PieChart pieChart;
    @FXML
    private Button btnClose;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(RootController.student);
        setStudent(RootController.student);

        btnClose.setOnMouseClicked(e-> {
            Stage stage = (Stage)pieChart.getScene().getWindow();
            stage.close();
        });

    }

    public void setStudent(StudentVO student) {
        System.out.println(RootController.student);
        System.out.println(pieChart);
        System.out.println(btnClose);

        pieChart.setData(FXCollections.observableArrayList(
            new PieChart.Data("국어", RootController.student.getKor()),
            new PieChart.Data("수학", RootController.student.getMath()),
            new PieChart.Data("영어", RootController.student.getEng())
        ));
    }
    
}
