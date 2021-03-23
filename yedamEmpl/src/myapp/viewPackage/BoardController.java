package myapp.viewPackage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import common.BoardVO;
import common.InputBoardVO;
import common.InputDAO;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class BoardController implements Initializable {
	
	
	@FXML TableView<BoardVO> tableView;
	@FXML TextField boardNo, title;
	@FXML TextArea contents;
	@FXML ComboBox<String> publicity;
	@FXML DatePicker exitDate;
	@FXML Button updateBtn, deleteBtn, addBtn;
	@FXML PasswordField passwd;
	
	
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		deleteBtn.setOnAction(e -> deleteBtnAction(e));
		deleteBtn.setOnAction(e -> beforeBtnAction(e));
		deleteBtn.setOnAction(e -> nextBtnAction(e));
		
		addBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				addBtnAction(e);				
			}	
		});
		
		deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				deleteBtnAction(e);			
			}	
		});
		ObservableList<BoardVO> list = InputDAO.boardList();
		
		tableView.setPrefWidth(460);
		tableView.setLayoutX(30);
		
		
		TableColumn<BoardVO, Integer> tcBoardNo = (TableColumn<BoardVO, Integer>) tableView.getColumns().get(0);
		tcBoardNo.setCellValueFactory(new PropertyValueFactory<BoardVO, Integer>("boardNo"));
//		tableView.setLayoutY(70);
		
		TableColumn<BoardVO, String> tcDate = (TableColumn<BoardVO, String>) tableView.getColumns().get(1);
		tcDate.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("exitDate"));
		
		
		TableColumn<BoardVO, String> tcTitle = (TableColumn<BoardVO, String>) tableView.getColumns().get(2);
		tcTitle.setCellValueFactory(new Callback<CellDataFeatures<BoardVO,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<BoardVO, String> param) {
				return param.getValue().titleProperty();
			}
			
		});
		
		TableColumn<BoardVO, String> tcPub = new TableColumn<BoardVO, String>("공개여부");
		tcPub.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("publicity"));
		tableView.getColumns().add(tcPub);
		
		TableColumn<BoardVO, String> tcCon = new TableColumn<BoardVO, String>("내용");
		tcCon.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("contents"));
		tableView.getColumns().add(tcCon);
	
		tableView.setItems(list);
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BoardVO>( ) {
			@Override
			public void changed(ObservableValue<? extends BoardVO> arg0, BoardVO oldValue, BoardVO newValue) {
				if(newValue != null) {
					System.out.println(newValue.getBoardNo());
					boardNo.setText(String.valueOf(newValue.getBoardNo()));
					title.setText(newValue.getTitle());
					publicity.setValue(newValue.getPublicity());
					contents.setText(newValue.getContents());
					exitDate.setValue(LocalDate.parse(newValue.getExitDate()));
				}
				
				
			}
			
		});
	}
	
	public void updateBtnAction(ActionEvent e) {
		BoardVO vo = new BoardVO();
		vo.setTitle(title.getText());
		vo.setBoardNo(Integer.parseInt(boardNo.getText()));
		vo.setContents(contents.getText());
		vo.setExitDate(exitDate.getValue().toString());
		vo.setPublicity(publicity.getValue());
		InputDAO.updateBoard(vo);
		
		tableView.setItems(InputDAO.boardList());
	}
	public void deleteBtnAction(ActionEvent e) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo.getText()));
		InputDAO.deleteBoard(vo);
		
		tableView.setItems(InputDAO.boardList());
	}
	public void exitBtnAction(ActionEvent e) {
		Platform.exit();
	}
	public void nextBtnAction(ActionEvent e) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo.getText()));
		InputDAO.deleteBoard(vo);
		
		tableView.setItems(InputDAO.boardList());
	}
	public void beforeBtnAction(ActionEvent e) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo.getText()));
		InputDAO.deleteBoard(vo);
		
		tableView.setItems(InputDAO.boardList());
	}
	
	public void addBtnAction(ActionEvent e) {
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		
		try { //새로운창을
			AnchorPane ap = FXMLLoader.load(getClass().getResource("BoardAdd.fxml"));
			Scene scene =new Scene(ap);
			stage.setScene(scene);
			stage.show();
			
			Button btnReg = (Button) ap.lookup("#btnReg");
			btnReg.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					TextField txtTitle = (TextField) ap.lookup("#title");
					ComboBox publicity = (ComboBox) ap.lookup("#publicity");
					TextArea contents = (TextArea) ap.lookup("#contents"); 
					DatePicker exitDate = (DatePicker) ap.lookup("#exitDate");
					PasswordField passwd = (PasswordField) ap.lookup("#passwd");
					
					InputBoardVO vo = new InputBoardVO();
					vo.setTitle(txtTitle.getText());
					vo.setContents(contents.getText());
					vo.setExitDate(exitDate.getValue().toString());
					vo.setPublicity(publicity.getValue().toString());
					InputDAO.insertBoard(vo);
					tableView.setItems(InputDAO.boardList());
					stage.close();
					
					
				}
			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	}
	

