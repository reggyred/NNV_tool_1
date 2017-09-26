package pl.sii.nnv.graph;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Main class representing single cell (node) on the graph.
 * 
 * @author preddig
 *
 */
public class Cell extends Pane {

	/**
	 * Used for autoincremental numbering.
	 */
	static int nextID = 0;
	/**
	 * Unique ID of given cell instance.
	 */
	int cellId;
	/**
	 * Cell name. Used on label.
	 */
	String cellName;
	/**
	 * Group to which cell is a member.
	 */
	String cellGroup;
	/**
	 * Defines y-axis hierarchy of cell.
	 */
	int cellOrder;
	/**
	 * Defines x-axis hierarchy of cell.
	 */
	int cellColumn;
	/**
	 * Defines (x,y) position of cell in its container.
	 */
	Point2D position;
	/**
	 * List of parent cells IDs of cell.
	 */
	List<Integer> parentsID = new ArrayList<>();
	/**
	 * List of nested cells inside given cell.
	 */
	List<Cell> children = new ArrayList<>();
	/**
	 * List of cells inside which given cell is nested.
	 */
	List<Cell> topLayer = new ArrayList<>();

	/**
	 * Graphical component (node) associated with cell.
	 */
	Node view;

	/**
	 * Basic constructor for cell class object.
	 * 
	 * @param cellId
	 *            ID number of given cell.
	 * 
	 */
	public Cell(int cellId) {
		this.cellId = cellId;
	}

	/**
	 * Standard constructor for cell class object.
	 * 
	 * @param cellId
	 * @param cellOrder
	 * @param parentsID
	 */
	public Cell(int cellId, int cellOrder, List<Integer> parentsID) {
		this.cellId = cellId;
		this.cellOrder = cellOrder;
		this.cellColumn = 0;
		this.parentsID = parentsID;
		this.getChildren().addAll(new Label(Integer.toString(cellId)));
	}

	/**
	 * Used to add cell as a child (nested) cell.
	 * 
	 * @param cell
	 *            to be added
	 */
	public void addCellChild(Cell cell) {
		children.add(cell);
	}

	/**
	 * Used to get list of all child (nested) cells.
	 * 
	 * @return list of child cells
	 */
	public List<Cell> getCellChildren() {
		return children;
	}

	/**
	 * Used to add cell that given cell is nested in.
	 * 
	 * @param cell
	 */
	public void addCellTopLayer(Cell cell) {
		topLayer.add(cell);
	}

	/**
	 * Used to get list of cells in which given cell is nested in.
	 * 
	 * @return list of top level cells.
	 */
	public List<Cell> getCellTopLayer() {
		return topLayer;
	}

	/**
	 * Removes child cell from child list of given cell.
	 * 
	 * @param cell
	 *            to be removed.
	 */
	public void removeCellChild(Cell cell) {
		children.remove(cell);
	}

	/**
	 * Removes top level cell from list of top level cells.
	 * 
	 * @param cell
	 *            to be removed.
	 */
	public void removeCellTopLayer(Cell cell) {
		topLayer.remove(cell);
	}

	/**
	 * Adds graphical representation of cell to graphical user interface.
	 * 
	 * @param view
	 *            node to be added.
	 */
	public void setView(Node view) {

		this.view = view;
		getChildren().add(view);

	}

	/**
	 * Returns graphical representation of cell.
	 * 
	 * @return node graphics
	 */
	public Node getView() {
		return this.view;
	}

	/**
	 * Returns cell ID
	 * 
	 * @return cell ID
	 */
	public int getCellId() {
		return cellId;
	}

	/**
	 * Used to set column number.
	 * 
	 * @param Column
	 */
	public void setColumn(int Column) {
		cellColumn = Column;
	}

	/**
	 * Used to set order number.
	 * 
	 * @param Order
	 */
	public void setOrder(int Order) {
		cellOrder = Order;
	}

	/**
	 * Used to get column number.
	 * 
	 * @return column number
	 */
	public int getColumn() {
		return cellColumn;
	}

	/**
	 * Used to get order number
	 * 
	 * @return order number
	 */
	public int getOrder() {
		return cellOrder;
	}
}