package myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FxmlApp  extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = FXMLLoader.load(getClass().getResource("AnchorPane.fxml")); //Label, Button
//		VBox root = FXMLLoader.load(getClass().getResource("root.fxml")); //Label, Button
				Scene scene = new Scene(root);
				
				primaryStage.setScene(scene);
				primaryStage.show();
				
		
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);

	}

	

}
