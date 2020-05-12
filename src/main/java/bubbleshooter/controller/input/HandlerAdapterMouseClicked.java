package bubbleshooter.controller.input;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

/**
 * 
 * Class which implements the {@link EvenHandler<MouseEvent>} interface.
 * Used to rotate the {@link Cannon} and the {@link HelpLine}.
 *
 */
public class HandlerAdapterMouseClicked implements EventHandler<MouseEvent> {

    private final Rotate cannonRotation;
    private final Rotate lineRotation;
    private final Point2D shootingBubblePosition;

    /**
     * Constructor for a new HandlerAdapterMouseMoved.
     * 
     * @param cannonRotation         the rotation of the cannon.
     * @param lineRotation           the rotation of the help line.
     * @param shootingBubblePosition the shooting bubble position.
     */
    public HandlerAdapterMouseClicked(final Rotate cannonRotation, final Rotate lineRotation, 
                final Point2D shootingBubblePosition) {
        this.cannonRotation = cannonRotation;
        this.lineRotation = lineRotation;
        this.shootingBubblePosition = shootingBubblePosition;
    }

    @Override
    public final void handle(final MouseEvent event) {
    	HandlerAdapterMouseMoved handlerAdapter;
    	Point2D eventPosition;
        eventPosition = new Point2D(event.getX(), event.getY());
        handlerAdapter = new HandlerAdapterMouseMoved(this.cannonRotation, this.lineRotation, 
                this.shootingBubblePosition, null);
        handlerAdapter.handle(event);
        System.out.println(eventPosition);
    }
}

