package bubbleshooter.controller;

import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.view.cannon.DrawHelpLine;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class HandlerAdapterMouseMoved implements EventHandler<MouseEvent> {

    private Rotate cannonRotation = new Rotate();
    private Rotate lineRotation = new Rotate();
    private DrawHelpLine helpLine;
    private double xBubble;
    private double yBubble;

    public HandlerAdapterMouseMoved(final Rotate cannonRotation, final Rotate lineRotation, final double xBubble, 
    								final double yBubble, DrawHelpLine helpLine) {
    	this.cannonRotation = cannonRotation;
    	this.lineRotation = lineRotation;
        this.xBubble = xBubble;
        this.yBubble = yBubble;
        this.helpLine = helpLine;
    }

    @Override
    public final void handle(final MouseEvent event) {
        this.cannonRotation.setAngle(PhysicHelper.calculateAngle(event, this.xBubble, this.yBubble));
        this.lineRotation.setAngle(PhysicHelper.calculateAngle(event, this.xBubble, this.yBubble));
    }

    public final double getRotationAngle() {
        return this.cannonRotation.getAngle();
    }
}
