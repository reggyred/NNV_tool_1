package pl.sii.nnv.layout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import pl.sii.nnv.graph.Cell;
import pl.sii.nnv.graph.Graph;

public class BasicLayout extends Layout {

	Graph graph;

	Random rnd = new Random();

	int maxColumn;
	int maxOrder;
	int maxWidth;
	int maxHeight;
	final int OrderHeight = 100;
	final int ColumnWidth = 75;
	int[] ColumnsInOrders;

	public BasicLayout(Graph graph) {
		super(graph);
		this.graph = graph;
		maxColumn = 0;
		maxOrder = 0;

	}

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