package bubbleshooter.controller;

import bubbleshooter.utility.PhysicHelper;
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

    @Override
    public final void handle(final MouseEvent event) {
        // TODO Auto-generated method stub
        //System.out.println(calculateAngle(event, xBubble, yBubble) + ",     x : " + event.getX() + ", y : " + event.getY());
        rotation.setAngle(PhysicHelper.calculateAngle(event, xBubble, yBubble));
    }
}
