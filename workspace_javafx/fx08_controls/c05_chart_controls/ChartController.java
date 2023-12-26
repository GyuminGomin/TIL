package workspace_javafx.fx08_controls.c05_chart_controls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable {

	@FXML
	private PieChart pieChart;
	@FXML
	private BarChart<String, Integer> barChart;
	@FXML
	private BubbleChart<Integer, Integer> bubbleChart;
	@FXML
	private AreaChart<String, Integer> areaChart;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		pieChart.setTitle("Java GUI");
		
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
		list.add(new PieChart.Data("AWT", 5)); // data명, 적용될 수치(double)
		PieChart.Data data = new PieChart.Data("Swing", 25);
		list.add(data);
		list.add(new PieChart.Data("SWT", 30));
		list.add(new PieChart.Data("JavaFX", 60));
		pieChart.setData(list);
		
		// XY 축을 이용해서 수치를 표현하는 도표
		areaChart.setTitle("년도별 평균 온도");
		XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		series1.setName("서울");
		ObservableList<XYChart.Data<String, Integer>> listChart = FXCollections.observableArrayList();
		XYChart.Data<String, Integer> chartData = new XYChart.Data<>("2017", 26);
		listChart.add(chartData);
		listChart.add(new XYChart.Data<>("2018", 27));
		listChart.add(new XYChart.Data<>("2019", 28));
		listChart.add(new XYChart.Data<>("2020", 20));
		listChart.add(new XYChart.Data<>("2021", 30));
		series1.setData(listChart);
		areaChart.getData().add(series1);
		
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series2.setName("부산");
		listChart = FXCollections.observableArrayList(); // 부산 series에 대입될 새로운 녀석 생성
		listChart.add(new XYChart.Data<>("2017", 24));
		listChart.add(new XYChart.Data<>("2018", 27));
		listChart.add(new XYChart.Data<>("2019", 30));
		listChart.add(new XYChart.Data<>("2020", 21));
		listChart.add(new XYChart.Data<>("2021", 34));
		series2.setData(listChart);
		areaChart.getData().add(series2);
		
		// Barchart Series별 data를 막대 그래프로 표현
		barChart.setTitle("년도별 평균 키");
		
		// 막대 카테고리별 데이터가 어떤 정보를 저장하고 있는지를 표현 하는 Series
		XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
		series3.setName("남성");
		
		XYChart.Series<String, Integer> series4 = new XYChart.Series<>();
		series4.setName("여성");
		
		ObservableList<XYChart.Data<String, Integer>> listBar = FXCollections.observableArrayList();
		listBar.add(new XYChart.Data<>("2019", 173));
		listBar.add(new XYChart.Data<>("2020", 173));
		listBar.add(new XYChart.Data<>("2021", 174));
		listBar.add(new XYChart.Data<>("2022", 176));
		series3.setData(listBar);
		
		listBar = FXCollections.observableArrayList();
		listBar.add(new XYChart.Data<>("2019", 160));
		listBar.add(new XYChart.Data<>("2020", 159));
		listBar.add(new XYChart.Data<>("2021", 163));
		listBar.add(new XYChart.Data<>("2022", 163));
		series4.setData(listBar);
		
		barChart.getData().add(series3);
		barChart.getData().add(series4);
		
		// BubbleChart
		// 체류 시간 별 상품 구매 수와 판매 금액
		// x : 체류시간(분), y : 금액(만원), scale : 구매 수
		XYChart.Series<Integer, Integer> seriesA = new XYChart.Series<>();
		seriesA.setName("40대");
		
		seriesA.getData().add(new XYChart.Data<>(5, 0, 0)); // x, y, scale
		seriesA.getData().add(new XYChart.Data<>(10, 5, 5)); // x, y, scale
		seriesA.getData().add(new XYChart.Data<>(20, 4, 7)); // x, y, scale
		seriesA.getData().add(new XYChart.Data<>(30, 3, 2)); // x, y, scale
		bubbleChart.getData().add(seriesA);
	}
}