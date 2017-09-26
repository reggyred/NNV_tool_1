package pl.sii.nnv.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pl.sii.nnv.MainApp;

public class MainViewController {

	
	
	@FXML
	SplitPane mainSplitPane;
	
	@FXML
	AnchorPane sideAnchorPane;

	@FXML
	AnchorPane mainAnchorPane;
	
	@FXML
	BorderPane mainBorderPane;

	MainApp mainApp;

	public MainViewController() {

	}
	
	@FXML
	private void initialize(){
	//	mainAnchorPane.getChildren().add(new Label("Hello world!"));
	}
	
	public AnchorPane getMainAnchorPane(){
		return mainAnchorPane;
	}
	
	public BorderPane getMainBorderPane(){
		return mainBorderPane;
	}
	
	public void addToMainAnchorPane(Node node){
		mainAnchorPane.getChildren().add(node);
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
