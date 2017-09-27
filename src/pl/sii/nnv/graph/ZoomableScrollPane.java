package pl.sii.nnv.graph;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Scale;

/**
 * ZoomableScrollPane is extension of JavaFX ScrollPane class. It adds zoom in/out 
 * functionality.
 * @author preddig
 *
 */
public class ZoomableScrollPane extends ScrollPane {
	/**
	 * Group of nodes that zoom action is performed on.
	 */
	Group zoomGroup;
	/**
	 * Transformation matrix of zoomed view.
	 */
	Scale scaleTransform;
	/**
	 * Content of ZoombableScrollPane.
	 */
	Node content;
	/**
	 * Current scale.
	 */
	double scaleValue = 1.0;
	/**
	 * Delta of scale change during scrolling.
	 */
	double delta = 0.05;

	/**
	 * Constructs ZoomableScrollPane with given content.
	 * @param content
	 */
	public ZoomableScrollPane(Node content) {
		this.content = content;
		Group contentGroup = new Group();
		zoomGroup = new Group();
		contentGroup.getChildren().add(zoomGroup);
		zoomGroup.getChildren().add(content);
		setContent(contentGroup);
		scaleTransform = new Scale(scaleValue, scaleValue, 0, 0);
		zoomGroup.getTransforms().add(scaleTransform);
		setPannable(true);
		zoomGroup.setOnScroll(new ZoomHandler());
	}

	/**
	 * Returns current scale value.
	 * @return scale value.
	 */
	public double getScaleValue() {
		return scaleValue;
	}

	/**
	 * Resets zoom scale to default (1.0)
	 */
	public void zoomToActual() {
		zoomTo(1.0);
	}

	/**
	 * Zooms to given scale value. Rescales view.
	 * @param scaleValue
	 */
	public void zoomTo(double scaleValue) {

		this.scaleValue = scaleValue;

		scaleTransform.setX(scaleValue);
		scaleTransform.setY(scaleValue);

	}
	/**
	 * Zooms out by delta factor.
	 */
	public void zoomOut() {
		scaleValue -= delta;

		if (Double.compare(scaleValue, 0.1) < 0) {
			scaleValue = 0.1;
		}

		zoomTo(scaleValue);
	}
	/**
	 * Zooms in by delta factor.
	 */
	public void zoomIn() {

		scaleValue += delta;

		if (Double.compare(scaleValue, 10) > 0) {
			scaleValue = 10;
		}

		zoomTo(scaleValue);

	}

	/**
	 * Fits graph to container. Recalculates scale value to required value. 
	 * @param minimizeOnly
	 *            if set to true, then graph can be only zoomed out to fit container
	 */
	public void zoomToFit(boolean minimizeOnly) {

		double scaleX = getViewportBounds().getWidth() / getContent().getBoundsInLocal().getWidth();
		double scaleY = getViewportBounds().getHeight() / getContent().getBoundsInLocal().getHeight();

		// consider current scale (in content calculation)
		scaleX *= scaleValue;
		scaleY *= scaleValue;

		// distorted zoom: we don't want it => we search the minimum scale
		// factor and apply it
		double scale = Math.min(scaleX, scaleY);

		// check precondition
		if (minimizeOnly) {

			// check if zoom factor would be an enlargement and if so, just set
			// it to 1
			if (Double.compare(scale, 1) > 0) {
				scale = 1;
			}
		}

		// apply zoom
		zoomTo(scale);

	}
/**
 * Handles mouse scroll event.
 * @author preddig
 *
 */
	private class ZoomHandler implements EventHandler<ScrollEvent> {

		@Override
		public void handle(ScrollEvent scrollEvent) {
			// if (scrollEvent.isControlDown())
			{
				System.out.println(scaleValue);
				if (scrollEvent.getDeltaY() < 0) {
					if (scaleValue > 0.1) { // protects from zooming out to scale 0
						scaleValue -= delta;
					} else {
						scaleValue = delta;
					} 
				} else {
					scaleValue += delta;
				}

				zoomTo(scaleValue);

				scrollEvent.consume();
			}
		}
	}
}