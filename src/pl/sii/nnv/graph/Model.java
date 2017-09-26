package pl.sii.nnv.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.Label;
import pl.sii.nnv.cells.LabelCell;
import pl.sii.nnv.cells.RectangleCell;
import pl.sii.nnv.cells.TitledPaneCell;

public class Model {

	Cell graphParent;

	List<Cell> allCells;
	List<Cell> addedCells;
	List<Cell> removedCells;

	List<Edge> allEdges;
	List<Edge> addedEdges;
	List<Edge> removedEdges;

	Map<Integer, Cell> cellMap; // <id,cell>

	public Model() {

		graphParent = new Cell(0);

		// clear model, create lists
		clear();
	}

	public void clear() {

		allCells = new ArrayList<>();
		addedCells = new ArrayList<>();
		removedCells = new ArrayList<>();

		allEdges = new ArrayList<>();
		addedEdges = new ArrayList<>();
		removedEdges = new ArrayList<>();

		cellMap = new HashMap<>(); // <id,cell>

	}

	public void clearAddedLists() {
		addedCells.clear();
		addedEdges.clear();
	}

	public List<Cell> getAddedCells() {
		return addedCells;
	}

	public List<Cell> getRemovedCells() {
		return removedCells;
	}

	public List<Cell> getAllCells() {
		return allCells;
	}

	public List<Edge> getAddedEdges() {
		return addedEdges;
	}

	public List<Edge> getRemovedEdges() {
		return removedEdges;
	}

	public List<Edge> getAllEdges() {
		return allEdges;
	}

	public void addCell(int id, CellType type) {

		switch (type) {

		case RECTANGLE:
			RectangleCell rectangleCell = new RectangleCell(id);
			addCell(rectangleCell);
			break;
		case LABEL:
			LabelCell labelCell = new LabelCell(id);
			addCell(labelCell);
			break;
		case TITLEDPANE:
			TitledPaneCell titledPaneCell = new TitledPaneCell(id, "Sample", new Label("Sample content"));
			addCell(titledPaneCell);
			break;

		default:
			throw new UnsupportedOperationException("Unsupported type: " + type);
		}
	}

	public void addCell(int id, CellType type, int cellLayer, List<Integer> parentsID) {

		switch (type) {

		case RECTANGLE:
			RectangleCell rectangleCell = new RectangleCell(id, cellLayer, parentsID);
			addCell(rectangleCell);
			break;

		default:
			throw new UnsupportedOperationException("Unsupported type: " + type);
		}
	}

	private void addCell(Cell cell) {

		addedCells.add(cell);

		cellMap.put(cell.getCellId(), cell);

	}

	public void addEdge(int sourceId, int targetId) {

		Cell sourceCell = cellMap.get(sourceId);
		Cell targetCell = cellMap.get(targetId);

		Edge edge = new Edge(sourceCell, targetCell);

		addedEdges.add(edge);

	}

//	public void addEdges() {
//
//		for (Cell cell : addedCells) {
//			if (cell.parentsID != null) {
//				for (Integer parID : cell.parentsID) {
//
//					Cell sourceCell = cellMap.get(parID);
//					Cell targetCell = cellMap.get(cell.cellId);
//					Edge edge = new Edge(sourceCell, targetCell);
//
//					addedEdges.add(edge);
//				}
//			}
//		}
//
//	}
	
	public void addEdges() {

		cellMap.forEach((cellID, cell) -> {
			if (cell.parentsID != null){
				for (Integer parID : cell.parentsID){
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