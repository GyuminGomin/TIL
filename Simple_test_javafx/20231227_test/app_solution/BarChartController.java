package app_solution;

import java.net.URL;
import java.util.ResourceBundle;

import app_solution.model.StudentVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class BarChartController implements Initializable{

    @FXML
    private BarChart<String, Integer> barChart; // xAxis = 학생이름 category, yAxis = 학생 이름별 국어 수학 영어 점수
    @FXML
    private Button btnClose;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<String, Integer> seriesKor = new XYChart.Series<>();
        seriesKor.setName("국어");
        XYChart.Series<String, Integer> seriesMath = new XYChart.Series<>();
        seriesMath.setName("수학");
        XYChart.Series<String, Integer> seriesEng = new XYChart.Series<>();
        seriesEng.setName("영어");

        ObservableList<XYChart.Data<String,Integer>> listKor = FXCollections.observableArrayList();
        ObservableList<XYChart.Data<String,Integer>> listMath = FXCollections.observableArrayList();
        ObservableList<XYChart.Data<String,Integer>> listEng = FXCollections.observableArrayList();

        for (StudentVO s : RootController.list) {
            listKor.add(new XYChart.Data<>(s.getName(), s.getKor()));
            listMath.add(new XYChart.Data<>(s.getName(), s.getMath()));
            listEng.add(new XYChart.Data<>(s.getName(), s.getEng()));
        }

        seriesKor.setData(listKor);
        seriesMath.setData(listMath);
        seriesEng.setData(listEng);

        barChart.getData().addAll(seriesKor, seriesMath, seriesEng);
        // addAll을 쓰는 경우, 어떤 제네릭이 넘어올지 모호하기 때문에 경고 메시지가 뜬다.
    }
    
}
