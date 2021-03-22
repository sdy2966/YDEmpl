package event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception { //버튼만들기
		//컨테이너 크기
		HBox root = new HBox();
		root.setPrefHeight(80);
		root.setPrefWidth(300);
		root.setSpacing(50);
		
		//버튼
		Button btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("버튼1이 클릭되었습니다.");
			}			
		});		
		Button btn2 = new Button("버튼2");
		btn2.setOnAction(event -> System.out.println("버튼2 클릭."));
		
		
		root.getChildren().add(btn1);
		root.getChildren().add(btn2);
		
		Scene scene =new Scene(root);
		
		primaryStage.setScene(scene);//윈도우에 씬을 
		primaryStage.show();//보여줌
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}
	
}
