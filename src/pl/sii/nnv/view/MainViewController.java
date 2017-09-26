package pl.sii.nnv.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pl.sii.nnv.MainApp;

/**
 * Controller class for main view window, containing split panel with side and
 * main anchor panes.
 * 
 * @author preddig
 *
 */
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

	/**
	 * Default constructor for MainViewController.
	 * The constructor is called by application before initialize method.
	 */
	public MainViewController() {

	}

	/**
	 * Initialize function for MainViewController. Automatically called when
	 * MainView.fxml resource is loaded.
	 * 
	 */
	@FXML
	private void initialize() {
		// mainAnchorPane.getChildren().add(new Label("Hello world!"));
	}

	/**
	 * Used to get access to main (left) part of split pane in main window.
	 * 
	 * @return mainBorderPane object
	 */
	public BorderPane getMainBorderPane() {
		return mainBorderPane;
	}

	/**
	 * Used to get access to side (right) part of split pane in main window.
	 * 
	 * @return
	 */
	public AnchorPane getSideAnchorPane() {
		return sideAnchorPane;
	}
	
	/**
	 * Used to add Node class object to main anchor pane in main window.
	 * @param node Node object to be added
	 */
	public void addToMainAnchorPane(Node node) {
		mainAnchorPane.getChildren().add(node);
	}

	/**
	 * Is called by the main application to give a reference back to itself
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
