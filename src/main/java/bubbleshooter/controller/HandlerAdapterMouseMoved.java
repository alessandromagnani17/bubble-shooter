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
    private DrawHelpLine drawHelpLine;
    private double xBubble;
    private double yBubble;

    public HandlerAdapterMouseMoved(final Rotate cannonRotation, final Rotate lineRotation, final double xBubble, 
    								final double yBubble, DrawHelpLine drawHelpLine) {
    	this.cannonRotation = cannonRotation;
    	this.lineRotation = lineRotation;
        this.xBubble = xBubble;
        this.yBubble = yBubble;
        this.drawHelpLine = drawHelpLine;
    }

    @Override
    public final void handle(final MouseEvent event) {
        this.cannonRotation.setAngle(PhysicHelper.calculateAngle(event, this.xBubble, this.yBubble));
        this.lineRotation.setAngle(PhysicHelper.calculateAngle(event, this.xBubble, this.yBubble));
        this.checkBounds(event.getX(), event.getY());
    }

    private void checkBounds(double xMouse, double yMouse) {
    	double angularCoefficient, intercepts, xInt, yInt;
    	
    	angularCoefficient = PhysicHelper.calculateAngularCoefficient(this.drawHelpLine.getHelpLine().getStartX(), 
    						 this.drawHelpLine.getHelpLine().getStartY(), xMouse, yMouse);
    	intercepts = PhysicHelper.calculateIntercepts(this.drawHelpLine.getHelpLine().getStartX(), 
				 			 this.drawHelpLine.getHelpLine().getStartY(), xMouse, yMouse);
    	
    	if(this.drawHelpLine.getBoundsLine().isVisible()) {
    		this.drawHelpLine.getBoundsLine().setVisible(false);
    	}
    	
		if(this.drawHelpLine.getHelpBounds().intersects(this.drawHelpLine.getLeftBounds())) {
			xInt = 0;
			yInt = intercepts;
			
		}
	}

	public final double getRotationAngle() {
        return this.cannonRotation.getAngle();
    }
}
