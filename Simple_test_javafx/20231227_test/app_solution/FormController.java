package app_solution;

import java.net.URL;
import java.util.ResourceBundle;

import app_solution.model.StudentVO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormController implements Initializable{
    
    @FXML
    private TextField txtName, txtKor, txtMath, txtEng;
    @FXML
    private Button btnSave, btnCancel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    // tableView의 리스트 정보, 현재 control이 등록된 FormStage 정보
    public void init(ObservableList<StudentVO> list, Stage formStage) {
        btnCancel.setOnAction(e-> {
            formStage.close();
        });

        // 저장 버튼 이벤트
        btnSave.setOnAction(e-> {
            // 저장 버튼 선택 시점에 TextField에 작성된 내용으로 RootController의 tableView list 학생 정보에 추가

            String name = txtName.getText().trim();
            String strKor = txtKor.getText().trim();
            String strMath = txtMath.getText().trim();
            String strEng = txtEng.getText().trim();

            boolean isChecked = checkInteger(strKor, strMath, strEng);

            if (!isChecked) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("알림");
                alert.setHeaderText("숫자만 입력해주세요.");
                // alert.setContentText("숫자만 입력해주세요");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.show();
                txtName.clear();
                txtKor.clear();
                txtMath.clear();
                txtEng.clear();
                txtName.requestFocus();
                return;
            }

            int kor = Integer.parseInt(strKor);
            int math = Integer.parseInt(strMath);
            int eng = Integer.parseInt(strEng);
            StudentVO vo = new StudentVO(name, kor, math, eng);
            RootController.list.add(vo); // tableView list 항목에 학생 정보 추가
        });
    } // end init

    public boolean checkInteger(String... scores) {
        // input : 100 == [1][0][0] (ascii code : 숫자 48 ~ 57)
        // char[] chars = scores[0].toCharArray();
        for (String str : scores) {
            for (char c : str.toCharArray()) {
                if (c < 48 || c > 57) {
                    // 숫자로 변환될 수 없는 문자가 포함
                    return false;
                }
            }
        }
        return true;
    }
}
