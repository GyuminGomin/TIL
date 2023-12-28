package app;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {

    @FXML
    private TableView<Student> tableView;
    @FXML
    private Button btnReg, btnBarGraph;

    ObservableList<Student> studentList;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // 목록을 저장할 List 생성
        studentList = FXCollections.observableArrayList();
        studentList.add(new Student("홍길동A", 40, 60, 80));
        studentList.add(new Student("홍길동B", 60, 80, 40));
        studentList.add(new Student("홍길동C", 80, 40, 60));
        
        // 테이블뷰와 Student 객체 컬럼 맞추기
        ObservableList<TableColumn<Student, ?>> columnList = tableView.getColumns();
        Field[] fields = Student.class.getDeclaredFields();
        for (int i=0; i<fields.length; i++) {
            String name = fields[i].getName(); // field 변수 이름

            TableColumn<Student, ?> columName = columnList.get(i);
            columName.setCellValueFactory(new PropertyValueFactory<>(name));
        }
        tableView.setItems(studentList);

        // 테이블 클릭하면 파이차트
        tableView.getSelectionModel().selectedItemProperty().addListener((target, o, n) -> {
            Student st = n;
            // Stage 가져오기
            Stage stage = new Stage(StageStyle.UTILITY);
            stage.setTitle("파이 그래프");
            

            Parent parent = null;
            try {
                parent = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // piechart 설정
            PieChart p = (PieChart)parent.lookup("#pieChart");
            ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
            PieChart.Data data1 = new PieChart.Data(fields[1].getName(), st.getKorean()); // 1[국어],2[수학],3[영어], 점수
            PieChart.Data data2 = new PieChart.Data(fields[2].getName(), st.getMath());
            PieChart.Data data3 = new PieChart.Data(fields[3].getName(), st.getEnglish());
            list.addAll(data1, data2, data3);

            p.setData(list);

            stage.initOwner(tableView.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            
            // btn 설정
            Button b = (Button)parent.lookup("#btnExit");
            b.setOnMouseClicked(e -> {
                 stage.close();
            });

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        });

        // 추가 버튼 클릭시
        btnReg.setOnMouseClicked(event-> {
            Stage stage = new Stage(StageStyle.UTILITY);
            stage.setTitle("추가");

            Parent parent = null;
            try {
                parent = FXMLLoader.load(getClass().getResource("Regist.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            TextField name = (TextField)parent.lookup("#name");
            TextField kor = (TextField)parent.lookup("#korean");
            TextField ma = (TextField)parent.lookup("#math");
            TextField eng = (TextField)parent.lookup("#english");

            Button btnSave = (Button)parent.lookup("#btnSave");
            btnSave.setOnMouseClicked(e -> {
                String n = name.getText();
                String k = kor.getText();
                String m = ma.getText();
                String en = eng.getText();

                int int_k = Integer.parseInt(k);
                int int_m = Integer.parseInt(m);
                int int_en = Integer.parseInt(en);

                studentList.add(new Student(n, int_k, int_m, int_en));
            }); 

            Button btnCancel = (Button)parent.lookup("#btnCancel");
            btnCancel.setOnMouseClicked(e -> {
                stage.close();
            });

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        });

        // 막대 그래프 클릭시
        btnBarGraph.setOnMouseClicked(e-> {
            
        });
    }
}
