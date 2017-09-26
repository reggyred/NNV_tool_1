package pl.sii.nnv.layout;

import java.util.List;
import java.util.Random;

import pl.sii.nnv.graph.Cell;
import pl.sii.nnv.graph.Graph;

public class RandomLayout extends Layout {

    Graph graph;

    Random rnd = new Random();

    public RandomLayout(Graph graph) {
    	super(graph);
        this.graph = graph;

    }

    public void execute() {

        List<Cell> cells = graph.getModel().getAllCells();

        for (Cell cell : cells) {

            double x = rnd.nextDouble() * 500;
            double y = rnd.nextDouble() * 500;

            cell.relocate(x, y);

        }

    }

}