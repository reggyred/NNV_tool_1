package pl.sii.nnv.layout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import pl.sii.nnv.graph.Cell;
import pl.sii.nnv.graph.Graph;

/**
 * Basic layouting algorithm. Places cells in hierarchical layout, with root
 * node in the bottom.
 * 
 * @author preddig
 *
 */
public class BasicLayout extends Layout {
	/**
	 * Graph object layout is applied to.
	 */
	Graph graph;
	/**
	 * Maximum number of columns (x-axis) of cells.
	 */
	int maxColumn;
	/**
	 * Maximum number of orders (y-axis) of cells.
	 */
	int maxOrder;
	/**
	 * Calculated maximum width (in pixels) of graph. 
	 */
	int maxWidth;
	/**
	 * Calculated maximum height (in pixels) of graph.
	 */
	int maxHeight;
	/**
	 * Defined height of single order (y-axis).
	 */
	final int OrderHeight = 100;
	/**
	 * Defined width of single column (x-axis).
	 */
	final int ColumnWidth = 75;
	/**
	 * Stores number of columns in each order.
	 */
	int[] ColumnsInOrders;
/**
 * Constructor of basic layout algorithm.
 * @param graph
 */
	public BasicLayout(Graph graph) {
		super(graph);
		this.graph = graph;
		maxColumn = 0;
		maxOrder = 0;

	}
/**
 * Executes basic layout algorithm. Based on list of cells acquired from graph
 * algorithm calculates required dimensions, maximal order and maximal column numbers.   
 * Finally, it layouts cells in hierarchical order.
 */
	public void execute() {

		List<Cell> cells = graph.getModel().getAllCells();

		for (Cell cell : cells) {

			if (cell.getOrder() > maxOrder) {
				maxOrder = cell.getOrder();

			}

		}
		ColumnsInOrders = new int[maxOrder + 1];
		for (Cell cell : cells) {
			cell.setColumn(ColumnsInOrders[cell.getOrder()]++);

			if (cell.getColumn() > maxColumn) {
				maxColumn = cell.getColumn();
			}
		}

		maxWidth = maxColumn * ColumnWidth + 80;
		maxHeight = maxOrder * OrderHeight + 80;

		for (Cell cell : cells) {
			int x;
			int y;
			int cellOrder = cell.getOrder();
			y = maxHeight - 25 - cellOrder * OrderHeight;
			x = maxWidth / (ColumnsInOrders[cellOrder] + 1) * (cell.getColumn() + 1);

			cell.relocate(x, y);
		}

	}

}