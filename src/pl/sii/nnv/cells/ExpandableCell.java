package pl.sii.nnv.cells;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import pl.sii.nnv.graph.Cell;

public class ExpandableCell extends Cell {

	/**
	 * Constructor for ExpandableCell class. Represents cell that groups other cells and can be folded/unfolded. Uses TitledPane JavaFX node.
	 * @param cellId
	 * @param cellOrder
	 * @param parentsID
	 * @param topLayer
	 * @param header
	 * @param content
	 */
	public ExpandableCell(int cellId, int cellOrder, List<Integer> parentsID, List<Cell> topLayer, String header, Node content) {
		super(cellId, cellOrder, parentsID, topLayer);
		 TitledPane view = new TitledPane(header, content);
	        view.setPrefSize(100, 100);
	        view.resize(100,100);
	        view.setExpanded(true);
	       // view.setCollapsible(true);
	        setView(view);
	}

}
