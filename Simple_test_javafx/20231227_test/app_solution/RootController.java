package app_solution;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import app_solution.model.StudentVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{
    
    @FXML
    private TableView<StudentVO> tableView;
    @FXML
    private Button btnAdd, btnBarChart;
    
    public static ObservableList<StudentVO> list;

    public static StudentVO student; // 정적 필드 선언

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableArrayList(
            new StudentVO("홍길동A", 40, 60, 80),
            new StudentVO("홍길동B", 60, 80, 40),
            new StudentVO("홍길동C", 80, 40, 70)
        );
        /*
        TableColumn<StudentVO, String> nameColumn = new TableColumn<>("이름"); // 테이블 컬럼 생성할 때 매개변수로 전달해도 되고, setText로 설정해도됨
        nameColumn.setText("이름");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); // 매개변수로 StudentVO의 필드 이름
        tableView.getColumns().add(nameColumn);
        tableView.setItems(list);
         */
        // 반복문으로 처리
        Class<StudentVO> clazz = StudentVO.class; // class의 정보 가져오기
        Field[] fields = clazz.getDeclaredFields(); // java.lang.reflect 패키지
        for (Field f : fields) {
            String name = f.getName(); // 필드의 이름
            TableColumn<StudentVO, String> tc = new TableColumn<>(name); // 테이블 컬럼 생성할 때 매개변수로 전달해도 되고, setText로 설정해도됨
            tc.setText(name);
            tc.setCellValueFactory(new PropertyValueFactory<>(name)); // 매개변수로 StudentVO의 필드 이름
            tc.setPrefWidth(100); // 테이블 간격 100
            tc.setResizable(false); // 테이블 크기 수정 불가
            tc.setStyle("-fx-alignment:center; -fx-text-fill:blue;"); // 정렬을 center로 설정
            tableView.getColumns().add(tc);
        }
        tableView.setItems(list);

        tableView.getSelectionModel().selectedItemProperty().addListener((target, o, n) -> {
            // 선택된 항목의 아이템 -> StudentVO
            System.out.println(n);
        });

        // tableView 항목 double click 시 pieChart Stage(창) 오픈
        tableView.setOnMouseClicked(e-> {
            // 단시간 내에 click된 횟수
            int clickCount = e.getClickCount();
            System.out.println("click count : " + clickCount);

            // mouse click 버튼 종류
            MouseButton btn = e.getButton(); // 좌클릭 - PRIMARY, 우클릭 - SECONDARY, 휠마우스 - MIDDLE
            System.out.println(btn);

            // 좌버튼 더블 클릭
            if (btn == MouseButton.PRIMARY && clickCount == 2) {
                // pieChart 창 오픈
                // 이벤트 발생 시점에 tableView에 선택된 item-항목 정보
                // StudentVO value = tableView.getSelectionModel().getSelectedItem();
                student = tableView.getSelectionModel().getSelectedItem();
                System.out.println(student);

                if(student == null) return; // 이벤트 메서드 종료

                Stage stage = new Stage(StageStyle.UTILITY);
                
                /*
                // 자바 코드로 UI 생성 및 이벤트 처리
                BorderPane pane = new BorderPane();
                pane.setPrefSize(300, 300); // Size는 폭과 높이를 한번에 지정하는 것
                
                PieChart chart = new PieChart();
                chart.setData(FXCollections.observableArrayList(
                    new PieChart.Data("국어", value.getKor()),
                    new PieChart.Data("수학", value.getMath()),
                    new PieChart.Data("영어", value.getEng())
                ));
                pane.setCenter(chart); // borderPane의 center에 chart를 배치

                HBox hBox = new HBox();
                hBox.setPrefHeight(50);
                hBox.setAlignment(Pos.CENTER); // Position 객체
                Button btnClose = new Button("닫기");
                btnClose.setOnAction(event-> {
                    stage.close();
                });
                hBox.getChildren().add(btnClose); // Children에 btnClose 추가
                pane.setBottom(hBox); // BorderPanel에 HBox 추가
                
                Scene scene = new Scene(pane);
                stage.setScene(scene);
                stage.setTitle(value.getName()+ " 파이 그래프");
                stage.show();
                */

                /*
                // FXML 파일을 이용한 스테이지 구성
                Parent root = null;
                
                try {
                    root = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return; // fxml 파일 못 읽으면 끝
                }

                PieChart pieChart = (PieChart)root.lookup("#pieChart");
                pieChart.setData(FXCollections.observableArrayList(
                    new PieChart.Data("국어", value.getKor()),
                    new PieChart.Data("수학", value.getMath()),
                    new PieChart.Data("영어", value.getEng())
                ));

                Button btnClose = (Button)root.lookup("#btnClose");
                btnClose.setOnAction(event -> {
                    stage.close();
                });

                stage.setScene(new Scene(root));
                stage.setTitle("파이 그래프");
                stage.show();
                */

                // FXML파일의 Controller설정해서 설정
                Parent root = null;
                FXMLLoader loader = null;
                try {
                    loader = new FXMLLoader(getClass().getResource("PieChart.fxml"));
                    root = loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return;
                }

                stage.setScene(new Scene(root));

                // PieChartController controller = loader.getController();
                // controller.setStudent(student); // 정적멤버를 사용해서 직접 컨트롤러를 받아올 필요가 없음
                
                stage.setTitle("파이 그래프");
                stage.show();
            }
        }); // tableView 더블 클릭

        // 추가 버튼 클릭 (TableView에 추가 학생 정보 추가 창)
        btnAdd.setOnAction(e-> {
            Stage stage = new Stage(StageStyle.UTILITY);
            stage.setTitle("추가");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Form.fxml"));
                // Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));
                Parent root = loader.load();
                stage.setScene(new Scene(root));
                // 새로운 Stage를 그려줄 X,Y 좌표 값을 현재 무대를 기준으로 지정
                Stage primary = (Stage)btnAdd.getScene().getWindow();
                double x = primary.getX();
                stage.setX(x + primary.getWidth());
                stage.setY(primary.getY());
                stage.initModality(Modality.APPLICATION_MODAL);
                
                FormController controller = loader.getController();
                controller.init(list, stage);

                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
                return;
            }
        }); // 추가 버튼 클릭

        // 학생별 막대그래프 버튼
        btnBarChart.setOnAction(e-> {
            Stage stage = new Stage(StageStyle.UTILITY);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle("막대 그래프");
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
                return;
            }

        }); // 학생별 막대그래프 버튼 클릭
    }
}
