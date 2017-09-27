package pl.sii.nnv.layout;

import pl.sii.nnv.graph.Graph;

/**
 * Abstract base class of layout algorithms.
 * @author preddig
 *
 */
public abstract class Layout {

	/**
	 * Graph object layout is applied to.
	 */
	Graph graph;
	/**
	 * Maximum number of columns (x-axis) of cells.
	 */
	int maxColumns;
	/** 
	 * Maximum number of orders (y-axis) of cells.
	 */
	int maxOrders;

	/**
	 * Constructor for layout object.
	 * @param graph to which layout is applied to.
	 */
    public Layout(Graph graph) {

        this.graph = graph;

    }
    
    /**
     * Abstract method that executes layouting algorithm.
     */
    public abstract void execute();

}