package pl.sii.nnv.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.Label;
import pl.sii.nnv.cells.LabelCell;
import pl.sii.nnv.cells.RectangleCell;

/**
 * Model is class, which instance stores lists of all added cells (nodes) and
 * edges (connectors). It is a part of graph class.
 * 
 * @author preddig
 *
 */
public class Model {
	/**
	 * graphParent is cell that all other cells origin from.
	 */
	Cell graphParent;
	/**
	 * Lists all cells that are currently displayed.
	 */
	List<Cell> allCells;
	/**
	 * Lists all cells that have been added during update, but but not yet
	 * processed.
	 */
	List<Cell> addedCells;
	/**
	 * Lists all cells that have been removed during update, but not yet
	 * processed.
	 */
	List<Cell> removedCells;
	/**
	 * Lists all edges that are currently displayed.
	 */
	List<Edge> allEdges;
	/**
	 * Lists all edges that have been added during update, but but not yet
	 * processed.
	 */
	List<Edge> addedEdges;
	/**
	 * Lists all edges that have been removed during update, but not yet
	 * processed.
	 */
	List<Edge> removedEdges;
	/**
	 * Stores map of cell IDs and cell instances.
	 */
	Map<Integer, Cell> cellMap; // <id,cell>

	/**
	 * Default constructor. Initializes graphParent and all lists/maps.
	 */
	public Model() {

		graphParent = new Cell(0);

		// clear model, create lists
		clear();
	}

	/**
	 * Initializes all lists/maps with new objects.
	 */
	public void clear() {

		allCells = new ArrayList<>();
		addedCells = new ArrayList<>();
		removedCells = new ArrayList<>();

		allEdges = new ArrayList<>();
		addedEdges = new ArrayList<>();
		removedEdges = new ArrayList<>();

		cellMap = new HashMap<>(); // <id,cell>

	}

	/**
	 * Clears lists of added cells and edges.
	 */
	public void clearAddedLists() {
		addedCells.clear();
		addedEdges.clear();
	}

	/**
	 * Returns list of added cells during current update.
	 * 
	 * @return list of added cells
	 */
	public List<Cell> getAddedCells() {
		return addedCells;
	}

	/**
	 * Returns list of removed cells during current update.
	 * 
	 * @return list of removed cells
	 */
	public List<Cell> getRemovedCells() {
		return removedCells;
	}

	/**
	 * Returns list of all cells.
	 * 
	 * @return list of all cells.
	 */
	public List<Cell> getAllCells() {
		return allCells;
	}

	/**
	 * Returns list of added edges during current update.
	 * 
	 * @return list of added edges.
	 */
	public List<Edge> getAddedEdges() {
		return addedEdges;
	}

	/**
	 * Returns list of removed edges during current update.
	 * 
	 * @return list of removed edges.
	 */
	public List<Edge> getRemovedEdges() {
		return removedEdges;
	}

	/**
	 * Returns list of all edges.
	 * 
	 * @return list of all edges.
	 */
	public List<Edge> getAllEdges() {
		return allEdges;
	}

	/**
	 * Adds new cell of given type to the graph model.
	 * 
	 * @param id
	 *            cell number
	 * @param type
	 *            type of the cell
	 * @param cellOrder
	 *            order of added cell
	 * @param parentsID
	 *            ID numbers of parent cells
	 * @param topLayer
	 *            cells in which added cell is nested in
	 */
	public void addCell(int id, CellType type, int cellOrder, List<Integer> parentsID, List<Cell> topLayer) {

		switch (type) {

		case RECTANGLE:
			RectangleCell rectangleCell = new RectangleCell(id, cellOrder, parentsID, topLayer);
			addCell(rectangleCell);
			break;

		default:
			throw new UnsupportedOperationException("Unsupported type: " + type);
		}
	}

	/**
	 * Adds new cell to graph and cell map.
	 * 
	 * @param cell
	 */
	private void addCell(Cell cell) {

		addedCells.add(cell);

		cellMap.put(cell.getCellId(), cell);

	}

	/**
	 * Adds new edge between specified cells.
	 * 
	 * @param sourceId
	 * @param targetId
	 */
	public void addEdge(int sourceId, int targetId) {

		Cell sourceCell = cellMap.get(sourceId);
		Cell targetCell = cellMap.get(targetId);

		Edge edge = new Edge(sourceCell, targetCell);

		addedEdges.add(edge);

	}
	/**
	 * Adds all edges to the graph, based on information about cells.
	 */
	public void addEdges() {

		cellMap.forEach((cellID, cell) -> {
			if (cell.parentsID != null) {
				for (Integer parID : cell.parentsID) {
					Cell sourceCell = cellMap.get(parID);
					Cell targetCell = cellMap.get(cell.cellId);
					Edge edge = new Edge(sourceCell, targetCell);

					addedEdges.add(edge);
				}
			}
		});
	}

	/**
	 * Attach all cells which don't have a parent to graphParent
	 * 
	 * @param cellList
	 */
	public void attachOrphansToGraphParent(List<Cell> cellList) {

		for (Cell cell : cellList) {
			if (cell.getCellParents().size() == 0) {
				graphParent.addCellChild(cell);
			}
		}

	}

	/**
	 * Remove the graphParent reference if it is set
	 * 
	 * @param cellList
	 */
	public void disconnectFromGraphParent(List<Cell> cellList) {

		for (Cell cell : cellList) {
			graphParent.removeCellChild(cell);
		}
	}
	/**
	 * Refreshes lists of all, added and removed cells.
	 */
	public void merge() {

		// cells
		allCells.addAll(addedCells);
		allCells.removeAll(removedCells);

		addedCells.clear();
		removedCells.clear();

		// edges
		allEdges.addAll(addedEdges);
		allEdges.removeAll(removedEdges);

		addedEdges.clear();
		removedEdges.clear();

	}
}