package pl.sii.nnv.graph;

import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 * Edge class instance is representing connection between cells.
 * 
 * @author preddig
 *
 */
public class Edge extends Group {
	/**
	 * Cell that connection is pointing out from.
	 */
	protected Cell source;
	/**
	 * Cell that connection is pointing to.
	 */
	protected Cell target;
	/**
	 * Enumerated type of connection.
	 */
	EdgeType connectionType;
	/**
	 * Name to be displayed in the label next to connection.
	 */
	String connectionName;
	/**
	 * Size (i.e array dimensions) of data flowing thru connection. 
	 */
	int dimension;
	/**
	 * Graphical object representing connection on the graph.
	 */
	Line line;

	/**
	 * Basic constructor for edge (connector) object.
	 * @param source
	 * @param target
	 */
	public Edge(Cell source, Cell target) {

		this.source = source;
		this.target = target;

		source.addCellChild(target);
		target.addCellParent(source);

		line = new Line();

		line.startXProperty().bind(source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
		line.startYProperty().bind(source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));

		line.endXProperty().bind(target.layoutXProperty().add(target.getBoundsInParent().getWidth() / 2.0));
		line.endYProperty().bind(target.layoutYProperty().add(target.getBoundsInParent().getHeight() / 2.0));

		getChildren().add(line);

	}
	/**
	 * Extended contructor for edge (connector) object.
	 * @param source
	 * @param target
	 * @param connectionType
	 * @param connectionName
	 * @param dimension
	 */
	public Edge(Cell source, Cell target, EdgeType connectionType, String connectionName, int dimension) {
	
	}

	/**
	 * Used to get source cell of edge instance.
	 * @return
	 */
	public Cell getSource() {
		return source;
	}

	/**
	 * Used to get target cell of edge instance.
	 * @return
	 */
	public Cell getTarget() {
		return target;
	}

}