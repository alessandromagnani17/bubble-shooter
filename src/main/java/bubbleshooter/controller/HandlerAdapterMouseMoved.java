package bubbleshooter.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

public class HandlerAdapterMouseMoved implements EventHandler<MouseEvent> {

    private static final double MAXANGLE =  65.0;
    private static final double MINANGLE = -65.0;
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

        return checkAngle(Math.toDegrees(Math.asin(cathetus / hypotenuse)));
    }

    public final double checkAngle(final double angle) {
        if (angle > MAXANGLE) {
            return MAXANGLE;
        } else if (angle < MINANGLE) {
            return MINANGLE;
        }
        return angle;
    }

    @Override
    public final void handle(final MouseEvent event) {
        // TODO Auto-generated method stub
        //System.out.println(calculateAngle(event, xBubble, yBubble) + ",     x : " + event.getX() + ", y : " + event.getY());
        rotation.setAngle(calculateAngle(event, xBubble, yBubble));
    }
}
