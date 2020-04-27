package bubbleshooter.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

public class HandlerAdapterMouseMoved implements EventHandler<MouseEvent> {

    private Rotate rotation = new Rotate();
    private double xBubble;
    private double yBubble;

    public HandlerAdapterMouseMoved(final Rotate rotation, final double xBubble, final double yBubble) {
        this.rotation = rotation;
        this.xBubble = xBubble;
        this.yBubble = yBubble;
    }

    public final double calculateAngle(final MouseEvent event, final double xBubble, final double yBubble) {
        double hypotenuse = Math.sqrt(Math.pow(event.getX() - xBubble, 2) + Math.pow(event.getY() - yBubble, 2));
        double cathetus = (event.getX() - xBubble);

        return Math.toDegrees(Math.asin(cathetus / hypotenuse));
    }

    @Override
    public final void handle(final MouseEvent event) {
        // TODO Auto-generated method stub
        //System.out.println(calculateAngle(event, xBubble, yBubble) + ",     x : " + event.getX() + ", y : " + event.getY());
        rotation.setAngle(calculateAngle(event, xBubble, yBubble));
    }
}
