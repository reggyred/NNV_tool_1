package pl.sii.nnv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.sii.nnv.graph.CellType;
import pl.sii.nnv.graph.Graph;
import pl.sii.nnv.graph.Model;
import pl.sii.nnv.layout.base.Layout;
import pl.sii.nnv.layout.basic.BasicLayout;
import pl.sii.nnv.view.MainViewController;

public class MainApp extends Application {

	Stage primaryStage;
	BorderPane rootLayout;
	AnchorPane mainAnchorPane;
	BorderPane mainBorderPane;
	Graph graph = new Graph();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Neural Network Visualizer alpha v0.001");
		
		initRootLayout();
		
		showMainView();
		
		
	}

	public void initRootLayout() {
		try{
			//Load root layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Show scene containing root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMainView() {
		try {
			//Load mainView layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
			AnchorPane mainView = (AnchorPane) loader.load();
			MainViewController mainViewControler = loader.getController();
			
			// Set main view into center of root layout
			rootLayout.setCenter(mainView);
			mainBorderPane = mainViewControler.getMainBorderPane();
		//	mainAnchorPane.getChildren().add(new Label("My test label in Main Anchor Pane"));
	
			//ObservableList<Node> mainViewChildren = mainView.getChildren();
			//System.out.println(mainViewChildren);
			
			graph = new Graph();
			mainBorderPane.setCenter(graph.getScrollPane());
			addGraphComponents();
			Layout layout = new BasicLayout(graph);
			layout.execute();
			//mainView
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void addGraphComponents() {

		Model model = graph.getModel();

		graph.beginUpdate();
		
		List<Integer> cellParents1 = new ArrayList<>();
		List<Integer> cellParents2 = new ArrayList<>();
		List<Integer> cellParents3 = new ArrayList<>();
		List<Integer> cellParents4 = new ArrayList<>();
		cellParents1.add(0);
		
		model.addCell(0, CellType.RECTANGLE, 0, null);
		model.addCell(1, CellType.RECTANGLE, 1, cellParents1);
		model.addCell(2, CellType.RECTANGLE, 1, cellParents1);
		cellParents2.add(1);
		cellParents2.add(2);
		model.addCell(3, CellType.RECTANGLE, 2, cellParents2);
		model.addCell(4, CellType.RECTANGLE, 2, cellParents2);
		cellParents3.add(3);
		cellParents3.add(4);
		model.addCell(5, CellType.RECTANGLE, 3, cellParents3);
		cellParents4.clear();
		cellParents4.add(4);
		cellParents4.add(5);
		model.addCell(6, CellType.RECTANGLE, 3, cellParents4);
		model.addCell(7, CellType.RECTANGLE, 3, cellParents4);
//		cellParents.clear();
//		cellParents.add(5);
//		cellParents.add(6);
//		cellParents.add(7);
//		model.addCell(8, CellType.RECTANGLE, 4, cellParents);
//		model.addCell(9, CellType.RECTANGLE, 4, cellParents);
//		model.addCell(10, CellType.RECTANGLE, 5, null);
//		model.addCell(11, CellType.RECTANGLE, 5, null);
//		model.addCell(12, CellType.RECTANGLE, 6, null);
//		model.addCell(13, CellType.RECTANGLE, 6, null);
//		model.addCell(14, CellType.RECTANGLE, 6, null);
//		model.addCell(15, CellType.RECTANGLE, 7, null);
//		model.addCell(16, CellType.RECTANGLE, 8, null);
//		model.addCell(17, CellType.RECTANGLE, 8, null);
//		model.addCell(18, CellType.RECTANGLE, 8, null);
//		model.addCell(19, CellType.RECTANGLE, 8, null);
//		model.addCell(20, CellType.RECTANGLE, 8, null);
//		model.addCell(21, CellType.RECTANGLE, 9, null);
//		model.addCell(22, CellType.RECTANGLE, 9, null);
//		model.addCell(23, CellType.RECTANGLE, 9, null);

		model.addEdges();
		
//		model.addEdge(0, 1);
//		model.addEdge(0, 2);
//		model.addEdge(2, 3);
//		model.addEdge(2, 3);
//		model.addEdge(3, 4);
//		model.addEdge(4, 7);
//		model.addEdge(4, 8);
//		model.addEdge(8, 9);
//		model.addEdge(9, 10);
//		model.addEdge(10, 11);
//		model.addEdge(9, 11);

		graph.endUpdate();

	}
}

