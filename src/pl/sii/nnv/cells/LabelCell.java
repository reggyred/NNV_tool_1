package pl.sii.nnv.cells;

import javafx.scene.control.Label;
import pl.sii.nnv.graph.Cell;

/**
 * Label class implements text label, that can be displayed on the graph.
 * @author preddig
 *
 */
public class LabelCell extends Cell {

	/**
	 * Constructor for LabelCell class. Creates Label JavaFX node with given text.
	 * @param id
	 * @param text
	 */
    public LabelCell(int id, String text) {
        super(id);

        Label view = new Label(text);

        setView(view);

    }

}