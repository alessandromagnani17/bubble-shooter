package bubbleshooter.controller;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

public class HandlerAdapterMouseClicked implements EventHandler<MouseEvent> {

    private Rotate rotation = new Rotate();
    private Point2D shootingBubblePosition;
    private Point2D eventPosition;


    public HandlerAdapterMouseClicked(final Rotate rotation, final Point2D shootingBubblePosition) {
        this.rotation = rotation;
        this.shootingBubblePosition = shootingBubblePosition;
    }

    @Override
    public final void handle(final MouseEvent event) {
        //HandlerAdapterMouseMoved handler = new HandlerAdapterMouseMoved(rotation, shootingBubblePosition);
        //handler.handle(event);
        //System.out.println("x = " + event.getX() + ", y = " + event.getY());
    }
}

