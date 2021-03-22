package myapp.bindingProperty;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
	@FXML private TextArea textArea1;
	@FXML private TextArea textArea2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
		//textArea가 가지고 있는 속성.textArea1의 속성이 바뀌면 textArea2의 속성도 부꾸게ㅖㅆ다.(바인딩 하겠다.)
	}
	
}
