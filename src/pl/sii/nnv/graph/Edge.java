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
	 * 
	 */
	String connectionName;
	int dimension;
	Line line;

	public Edge(Cell source, Cell target) {

		this.source = source;
		this.target = target;

		source.addCellChild(target);
		target.addCellTopLayer(source);

		line = new Line();

		line.startXProperty().bind(source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
		line.startYProperty().bind(source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));

		line.endXProperty().bind(target.layoutXProperty().add(target.getBoundsInParent().getWidth() / 2.0));
		line.endYProperty().bind(target.layoutYProperty().add(target.getBoundsInParent().getHeight() / 2.0));

		getChildren().add(line);

	}

	public Cell getSource() {
		return source;
	}

	public Cell getTarget() {
		return target;
	}

}