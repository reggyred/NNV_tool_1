package pl.sii.nnv.graph;


import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
/**
 * Graph is class of main object that connects instances and functionality of other objects
 * responsible for drawing cells, edges and navigation over graph. 
 * @author preddig
 *
 */
public class Graph {
/**
 * Stores and perform operations on lists of cells and edges. 
 */
	private Model model;
/**
 * GUI element from JavaFX library that stores other graphical objects.
 */
	private Group canvas;
/**
 * GUI element that allows view of the graph to be zoomed and moved around.
 */
	private ZoomableScrollPane scrollPane;
/**
 * Interface element that handles mouse events for scrolling and zooming.
 */
	MouseGestures mouseGestures;
/**
 * CellLayer is used to proper alignment of graph in zoomable scroll panel.
 */
	CellLayer cellLayer;
/**
 * Constructor for Graph class instance. Initializes field with default values.
 */
	public Graph() {

		this.model = new Model();

		canvas = new Group();
		cellLayer = new CellLayer();

		canvas.getChildren().add(cellLayer);

		mouseGestures = new MouseGestures(this);

		scrollPane = new ZoomableScrollPane(canvas);

		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);

	}
/**
 * Returns scrollPane object.
 * @return scrollPane object.
 */
	public ScrollPane getScrollPane() {
		return this.scrollPane;
	}
/**
 * Returns cellLayer object.
 * @return cellLayer object.
 */
	public Pane getCellLayer() {
		return this.cellLayer;
	}
/**
 * Returns model object.
 * @return model object.
 */
	public Model getModel() {
		return model;
	}

/**
 * Set of activities performed before updating graph.
 */
	public void beginUpdate() {
	}

/**
 * Set of activites performed after updating graph.
 */
	public void endUpdate() {

		// add components to graph pane
		getCellLayer().getChildren().addAll(model.getAddedEdges());
		getCellLayer().getChildren().addAll(model.getAddedCells());

		// remove components from graph pane
		getCellLayer().getChildren().removeAll(model.getRemovedCells());
		getCellLayer().getChildren().removeAll(model.getRemovedEdges());

		// enable dragging of cells
		for (Cell cell : model.getAddedCells()) {
			mouseGestures.makeDraggable(cell);
					}
		// every cell must have a parent, if it doesn't, then the graphParent is
		// the parent
		getModel().attachOrphansToGraphParent(model.getAddedCells());

		// remove reference to graphParent
		getModel().disconnectFromGraphParent(model.getRemovedCells());

		// merge added & removed cells with all cells
		getModel().merge();

	}

/**
 * Returns current scale of scrollPane.
 * @return current scale.
 */
	public double getScale() {
		return this.scrollPane.getScaleValue();
	}
}