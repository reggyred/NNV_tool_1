package pl.sii.nnv.cells;

import javafx.scene.control.Label;
import pl.sii.nnv.graph.Cell;

public class LabelCell extends Cell {

    public LabelCell(int id) {
        super(id);

        Label view = new Label(Integer.toString(id));

        setView(view);

    }

}