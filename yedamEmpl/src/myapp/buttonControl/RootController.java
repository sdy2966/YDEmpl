package myapp.buttonControl;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable{

	@FXML
	Button btn1, btn2, btn3;//root.fxml파일에서 지정한 저 버튼들을 불러오겠다//
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		btn1.setOnAction(new EventHandler<ActionEvent>() {//
//
//			@Override
//			public void handle(ActionEvent arg0) {//EventHandler 인터페이스의 기능 구현
//				handleButton1Action(arg0);
//			}
//		});
		
		btn2.setOnAction(event -> handleButton2Action(event));
		
		btn3.setOnAction(event -> handleButton3Action(event));
	}
	public void handleButton1Action(ActionEvent e) {//e는 변수이름 안적어줘도됌~
		System.out.println("버튼1 클릭.");
		
	}
	public void handleButton2Action(ActionEvent e) {
		System.out.println("버튼2 클릭.");
		
	}
	public void handleButton3Action(ActionEvent e) {
		Platform.exit();//Platform.exit()는 자바 플랫폼에서 종료하라는 뜻
		
	}
	//root.fxml의 onAction이 컨트롤러랑 ???이어준다고?
}
