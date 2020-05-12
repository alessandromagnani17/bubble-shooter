package bubbleshooter.controller.input;

import bubbleshooter.view.helpline.DrawHelpLine;
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

    private Rotate cannonRotation = new Rotate();
    private Rotate lineRotation = new Rotate();
    private DrawHelpLine drawHelpLine;
    private Point2D shootingBubblePosition;
    private HandlerAdapterMouseMoved handlerAdapter;
    private Point2D eventPosition;

    /**
     * Constructor for a new HandlerAdapterMouseMoved.
     * 
     * @param cannonRotation         the rotation of the cannon.
     * @param lineRotation           the rotation of the help line.
     * @param shootingBubblePosition the shooting bubble position.
     * @param drawHelpLine           the DrawHelpLine.
     */
    public HandlerAdapterMouseClicked(final Rotate cannonRotation, final Rotate lineRotation, final Point2D shootingBubblePosition,
                final DrawHelpLine drawHelpLine) {
        this.cannonRotation = cannonRotation;
        this.lineRotation = lineRotation;
        this.shootingBubblePosition = shootingBubblePosition;
        this.drawHelpLine = drawHelpLine;
    }

    @Override
    public final void handle(final MouseEvent event) {
        this.eventPosition = new Point2D(event.getX(), event.getY());
        this.handlerAdapter = new HandlerAdapterMouseMoved(this.cannonRotation, this.lineRotation, 
                this.shootingBubblePosition, this.drawHelpLine);
        handlerAdapter.handle(event);
        System.out.println(this.eventPosition);
    }
}

