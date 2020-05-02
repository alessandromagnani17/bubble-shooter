package bubbleshooter.controller;

import bubbleshooter.utility.PhysicHelper;
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

    @Override
    public final void handle(final MouseEvent event) {
        this.rotation.setAngle(PhysicHelper.calculateAngle(event, this.xBubble, this.yBubble));
        System.out.println(this.rotation.getAngle());
    }

    public final double getRotationAngle() {
        return this.rotation.getAngle();
    }
}
