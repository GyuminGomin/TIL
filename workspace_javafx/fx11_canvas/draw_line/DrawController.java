package workspace_javafx.fx11_canvas.draw_line;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class DrawController implements Initializable {

	@FXML
	private TextArea txtArea;
	@FXML
	private Button btnClear, btnSave;
	@FXML
	private Canvas canvas;
	@FXML
	private ColorPicker pick;
	@FXML
	private Slider slider;
	
	// 그리기 도구
	private GraphicsContext gc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = canvas.getGraphicsContext2D();
		pick.setValue(Color.BLACK); // ColorPick의 기본 색상 검은색 설정
		gc.setStroke(Color.BLACK); // 선색 지정
		gc.setLineWidth(1); // 선 굵기 지정
		slider.setMin(1); // 선 최소값이 0이 될 수 없으므로
		slider.setMax(100);
		txtArea.setEditable(false); // textArea 작성 불가
		
		// Canvas 위에서 마우스가 움직일 때
		canvas.setOnMouseMoved((e) -> {
			// MouseEvent 객체 전달
			double x = e.getScreenX(); // 모니터 화면 1920 x 1680 를 기준
			double y = e.getScreenY();
			txtArea.appendText("screen X : "+x+", Y: "+y+"\n");
			x = e.getX(); // canvas 요소에서 마우스가 어디에 위치하는지 canvas 위치를 알려줌
			y = e.getY();
			txtArea.appendText("canvas X : "+x+", Y: "+y+"\n");	
		}); // end mouse moved
		
		// 마우스가 눌러졌을 때
		canvas.setOnMousePressed(e -> {
			gc.beginPath();
			gc.lineTo(e.getX(), e.getY());
		});
		
		// 마우스가 드래그 되는 동안
		canvas.setOnMouseDragged(e -> {
			gc.lineTo(e.getX(), e.getY());
			gc.stroke();
		});
		
		// 캔버스 초기화
		btnClear.setOnAction(e -> {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		});
		
		// 선 색 변경 - 색상 변경 감지
		pick.valueProperty().addListener((target, o, n) -> {
			System.out.println("old color : " + o);
			System.out.println("new color : " + n);
			gc.setStroke(n); // 새로 선택한 색상으로 변경
		});
		
		// 선 굵기 변경
		slider.valueProperty().addListener((target, o, n) -> {
			double value = n.doubleValue() / 10;
			gc.setLineWidth(value);
		});
		
		// 저장 버튼 클릭 시
		btnSave.setOnAction((e) -> {
			FileChooser fChooser = new FileChooser();
			fChooser.getExtensionFilters().add(new ExtensionFilter("IMAGE FILE", "*.png"));
			File file = fChooser.showSaveDialog(slider.getScene().getWindow());
			try {
				if (file != null) { // 취소 버튼 누를 수도 있으므로, 파일이 존재할 때만
					// 지정된 요소의 스크린샷을 제공하기 위한 부가 정보를 저장하는 class
					SnapshotParameters param = new SnapshotParameters();
					param.setDepthBuffer(true);
					param.setFill(Color.TRANSPARENT); // 배경을 투명하게 만들어줌
					
					// Node Canvas 화면의 스크린샷 정보
					WritableImage writeImg = canvas.snapshot(param, null);
					
					// 매개변수로 전달된 스크린샷 정보로 이미지 소스 생성
					RenderedImage renderImage = SwingFXUtils.fromFXImage(writeImg, null);
					OutputStream os = new FileOutputStream(file);
					
					ImageIO.write(renderImage, "png", os); // (렌더된 이미지, 확장자, 출력스트림)
					os.flush();
					os.close();
					System.out.println("완료");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
	} // end initialize

}
