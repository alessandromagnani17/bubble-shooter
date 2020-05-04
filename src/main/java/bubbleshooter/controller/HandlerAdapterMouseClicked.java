package bubbleshooter.controller;

import bubbleshooter.view.cannon.DrawHelpLine;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

public class HandlerAdapterMouseClicked implements EventHandler<MouseEvent> {

    private Rotate cannonRotation = new Rotate();
    private Rotate lineRotation = new Rotate();
    private DrawHelpLine drawHelpLine;
    private Point2D shootingBubblePosition;
    private HandlerAdapterMouseMoved handlerAdapter;
    private Point2D eventPosition;


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

