package myapp.bindingControl;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {
	@FXML private Slider slider; 
	@FXML private Label label;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable
					, Number oldValue, Number newValue) {
				label.setFont(new Font(newValue.doubleValue()));				
			}			
		});		
	}	
}//사용자가 슬라이더를 움직일떄마다 addListener에서? changed메소드 발생? 실행하겠다?->label의 크기 지정.(setFont)
//Root.fxml에서 대문자는 클래스다 ctrl+space 눌러서 임포트해줘라~~
