package pl.sii.nnv.cells;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.sii.nnv.graph.Cell;
/**
 * Class for rectangle shape cell.
 * @author preddig
 *
 */
public class RectangleCell extends Cell {

	/**
	 * Constructor for rectangle shape cell. Creates Rectangle JavaFX node.
	 * @param id
	 * @param cellLayer
	 * @param parentsID
	 * @param topLayer
	 */
	public RectangleCell(int id, int cellLayer, List<Integer> parentsID, List<Cell> topLayer) {
		super(id, cellLayer, parentsID, topLayer);

		Rectangle view = new Rectangle(50, 50);
		view.setArcHeight(8);
		view.setArcWidth(8);
		view.setStroke(Color.BLACK);
		view.setFill(Color.LAVENDER);

		setView(view);

	}

}