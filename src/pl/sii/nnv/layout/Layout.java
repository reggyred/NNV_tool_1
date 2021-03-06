package pl.sii.nnv.layout;

import pl.sii.nnv.graph.Graph;

/**
 * Abstract base class of layout algorithms.
 * @author preddig
 *
 */
public abstract class Layout {

	Graph graph;
	int maxLayers;
	int maxOrders;
	
	
    public Layout(Graph graph) {

        this.graph = graph;

    }


    public abstract void execute();

}