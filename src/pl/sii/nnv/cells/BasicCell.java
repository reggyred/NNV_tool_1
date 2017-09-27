package pl.sii.nnv.cells;

import java.util.List;

import pl.sii.nnv.graph.Cell;
/**
 * Elementary graph cell.
 * @author preddig
 *
 */
public class BasicCell extends Cell {

	/**
	 * Constructor for BasicCell class. Basic cell represents primitive, non expandable
	 * graph node.
	 * @param id
	 * @param cellLayer
	 * @param parentsID
	 * @param topLayer
	 */
	public BasicCell(int id, int cellLayer, List<Integer> parentsID, List<Cell> topLayer) {
		super(id, cellLayer, parentsID, topLayer);
	}

}
