package pl.sii.nnv.cells;

import java.util.List;

import pl.sii.nnv.graph.Cell;

/**
 * Elementary elliptical cell.
 * @author preddig
 *
 */
public class EllipticalCell extends Cell {

	/**
	 * Constructor for EllipticalCell class. Elliptical cell represents primitive, non expandable 
	 * cell of graph. Shape of cell is elliptical.
	 * @param cellId
	 * @param cellOrder
	 * @param parentsID
	 * @param topLayer
	 */
	public EllipticalCell(int cellId, int cellOrder, List<Integer> parentsID, List<Cell> topLayer) {
		super(cellId, cellOrder, parentsID, topLayer);
		
	}

}
