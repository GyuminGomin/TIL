package workspace_javafx.fx11_canvas.application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class RootController implements Initializable{
	
	@FXML
	private Canvas canvas; // 도화지
	
	private GraphicsContext gc; // 그리기 도구
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		gc = canvas.getGraphicsContext2D();
		
		// 그리기 도구 활용 방법
		gc.setFill(Color.RED); // 그리기 도구에 채우기 색상 지정
		gc.fillRect(100, 100, 100, 100); // 사각형 그리기 (가로위치, 세로위치, 너비(폭), 높이)
		
		gc.setStroke(Color.BLUE); // 외곽선 색 지정
		gc.strokeRect(150, 150, 100, 100); // 외곽선만 있는 직사각형
		
		gc.strokeLine(200, 200, 250, 250); // 선 그리기 도구 (시작x, 시작y, 끝x, 끝y)
		
		// 여러 선을 이어 그려주는 도구
		gc.beginPath(); // 그리기 시작
		gc.setStroke(Color.CADETBLUE);
		gc.lineTo(10, 10); // 10,10 에서 시작
		gc.lineTo(20, 30);
		gc.setStroke(Color.BLACK);
		gc.lineTo(50, 40);
		gc.lineTo(10, 10);
		gc.stroke(); // 그리기
		
		gc.setStroke(Color.BLUE);
		gc.strokeOval(100, 100, 50, 50); // 호 그리기 도구 (시작x, 시작y, 너비, 높이)
		
		// 이미지 그리기 도구
		Image image = new Image(getClass().getResource("img/car1.png").toString()); // 그려줄 이미지
//		gc.drawImage(image, 300, 300); // (그려줄 이미지, 시작x, 시작y)
		
		gc.drawImage(image, 300, 300, 100, 100); // (그려줄 이미지, 시작x, 시작y, 너비, 높이)
		
		Thread t = new Thread(() -> {
			for(int i = 0; i < canvas.getWidth(); i++) {
				gc.clearRect(i, i, 100, 100); // 기존에 있던 이미지 지우고
				gc.drawImage(image, i, i, 100, 100);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			} // 그림을 다 그려줄 때까지 Thread가 살아 있음 (안전하게 무대가 닫혔을 때 같이 종료될 수 있도록)
		}); // end Thread
		t.setDaemon(true);
		t.start();
	} // end initialize
	
	double x, y, width, height; // 이미지 그리기 지우기 시작 x,y 좌표 와 너비 높이
	
	// Main 에서 stage가 show 하기 전에 Scene 객체를 받아옴
	public void setScene(Scene scene) {
		Image image2 = new Image(getClass().getResource("img/car1.png").toString());
		x = 300;
		y = 0;
		width = height = 100;
		gc.drawImage(image2, x, y, width, height);
		scene.setOnKeyPressed(e -> {
			System.out.println(e.getCode());
			width = height = 100;
			if (e.getCode() == KeyCode.UP) {
				y--;
				height++;
			} else if (e.getCode() == KeyCode.DOWN) {
				y++;
			} else if (e.getCode() == KeyCode.LEFT) {
				x--;
				width++; // 현재 그림이 흰색배경에 흰색 바탕이라 티가 안남 (따라서 background를 다른 색깔로 지정)
			} else if (e.getCode() == KeyCode.RIGHT) {
				x++;
			}
			gc.clearRect(x, y, width, height);
			gc.drawImage(image2, x, y, width, height);
		});
	}
}