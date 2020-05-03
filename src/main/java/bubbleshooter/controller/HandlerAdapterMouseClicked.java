package bubbleshooter.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

public class HandlerAdapterMouseClicked implements EventHandler<MouseEvent> {

    private Rotate rotation = new Rotate();
    private double xBubble;
    private double yBubble;

    public HandlerAdapterMouseClicked(final Rotate rotation, final double xBubble, final double yBubble) {
        this.rotation = rotation;
        this.xBubble = xBubble;
        this.yBubble = yBubble;
    }

    @Override
    public final void handle(final MouseEvent event) {
        //HandlerAdapterMouseMoved handler = new HandlerAdapterMouseMoved(rotation, xBubble, yBubble);
        //handler.handle(event);
        //System.out.println("x = " + event.getX() + ", y = " + event.getY());
    }
}

