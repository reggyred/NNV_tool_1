package pl.sii.nnv.graph;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Class that handles mouse gestures over cells/nodes.
 * 
 * @author preddig
 *
 */
public class MouseGestures {

	/**
	 * Used in drag gesture.
	 */
	final DragContext dragContext = new DragContext();
	/**
	 * Reference to graph that is object of mouse gestures.
	 */
	Graph graph;

	/**
	 * Constructor for mouse gestures handler for given graph.
	 * 
	 * @param graph
	 */
	public MouseGestures(Graph graph) {
		this.graph = graph;
	}

	/**
	 * Enables dragging of node.
	 * 
	 * @param node
	 */
	public void makeDraggable(final Node node) {

		node.setOnMousePressed(onMousePressedEventHandler);
		node.setOnMouseDragged(onMouseDraggedEventHandler);
		node.setOnMouseReleased(onMouseReleasedEventHandler);

	}

	/**
	 * Handler for event of mouse button press on node.
	 */
	EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			Node node = (Node) event.getSource();

			double scale = graph.getScale();

			dragContext.x = node.getBoundsInParent().getMinX() * scale - event.getScreenX();
			dragContext.y = node.getBoundsInParent().getMinY() * scale - event.getScreenY();

		}
	};
	/**
	 * Handler for event of dragging with mouse button pressed on node.
	 */
	EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			Node node = (Node) event.getSource();

			double offsetX = event.getScreenX() + dragContext.x;
			double offsetY = event.getScreenY() + dragContext.y;

			// adjust the offset in case we are zoomed
			double scale = graph.getScale();

			offsetX /= scale;
			offsetY /= scale;

			node.relocate(offsetX, offsetY);

		}
	};
	/**
	 * Handler for releasing mouse button on the node.
	 */
	EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

		}
	};

	/**
	 * Subclass that stores xy coordinates for drag mouse gesture.
	 * 
	 * @author preddig
	 *
	 */
	class DragContext {

		double x;
		double y;

	}
}