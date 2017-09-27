package pl.sii.nnv.layout;

import java.util.List;
import java.util.Random;

import pl.sii.nnv.graph.Cell;
import pl.sii.nnv.graph.Graph;

/**
 * Random layout algorith. Places cells in randomly generated locations.
 * @author preddig
 *
 */
public class RandomLayout extends Layout {

	/**
	 * Graph object layout is applied to.
	 */
    Graph graph;
    /**
     * Random number generator.
     */
    Random rnd = new Random();

	/**
	 * Constructor for layout object.
	 * @param graph to which layout is applied to.
	 */
    public RandomLayout(Graph graph) {
    	super(graph);
        this.graph = graph;

    }

    /**
     * Executes random placement of cells.
     */
    public void execute() {

        List<Cell> cells = graph.getModel().getAllCells();

        for (Cell cell : cells) {

            double x = rnd.nextDouble() * 500;
            double y = rnd.nextDouble() * 500;

            cell.relocate(x, y);

        }

    }

}