package pl.sii.nnv.cells;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.sii.nnv.graph.Cell;

public class RectangleCell extends Cell {

	public RectangleCell(int id, int cellLayer, List<Integer> parentsID) {
		super(id, cellLayer, parentsID);

		Rectangle view = new Rectangle(50, 50);
		view.setArcHeight(8);
		view.setArcWidth(8);
		view.setStroke(Color.BLACK);
		view.setFill(Color.LAVENDER);

		setView(view);

	}

}