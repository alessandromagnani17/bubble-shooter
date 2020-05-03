package bubbleshooter.controller;

import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.utility.Settings;
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
    	double angularCoefficient, intercepts, xInt, yInt, newX, newY, startY;
    	
    	angularCoefficient = PhysicHelper.calculateAngularCoefficient(this.drawHelpLine.getHelpLine().getStartX(), 
    						 this.drawHelpLine.getHelpLine().getStartY(), xMouse, yMouse);
    	intercepts = PhysicHelper.calculateIntercepts(this.drawHelpLine.getHelpLine().getStartX(), 
				 			 this.drawHelpLine.getHelpLine().getStartY(), xMouse, yMouse);
    	
    	if(this.drawHelpLine.getBoundsLine().isVisible()) {
    		this.drawHelpLine.getBoundsLine().setVisible(false);
    	}
    	
		if(this.drawHelpLine.getHelpBounds().intersects(this.drawHelpLine.getLeftBounds()) 
				&& this.drawHelpLine.isHelpSelected()) {
			xInt = 0;
			yInt = intercepts;
			newX = Settings.getGuiWidth();
			newY = -angularCoefficient*newX + intercepts;
			this.drawHelpLine.drawBoundsLine(xInt, yInt, newX, newY);
		}
		
		if(this.drawHelpLine.getHelpBounds().intersects(this.drawHelpLine.getRightBounds()) 
				&& this.drawHelpLine.isHelpSelected()) {
			xInt = Settings.getGuiWidth();
			yInt = angularCoefficient*xInt + intercepts;
			newX = this.drawHelpLine.getHelpLine().getStartX();
			startY = this.drawHelpLine.getHelpLine().getStartY();
			newY =  startY - (startY - yInt)*2;
			
			intercepts = PhysicHelper.calculateIntercepts(xInt, yInt, newX, newY);
			
			newX = 0;
			newY = -angularCoefficient*newX + intercepts;
			
			this.drawHelpLine.drawBoundsLine(xInt, yInt, newX, newY);
		}
		
	}

	public final double getRotationAngle() {
        return this.cannonRotation.getAngle();
    }

}
