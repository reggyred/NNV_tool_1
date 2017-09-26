package pl.sii.nnv.cells;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import pl.sii.nnv.graph.Cell;

public class TriangleCell extends Cell {

    public TriangleCell( int id) {
        super( id);

        double width = 50;
        double height = 50;

        Polygon view = new Polygon( width / 2, 0, width, height, 0, height);

        view.setStroke(Color.RED);
        view.setFill(Color.RED);

        setView( view);

    }

}