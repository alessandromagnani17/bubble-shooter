package bubbleshooter.controller.input;


import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.cannon.DrawHelpLine;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

public class HandlerAdapterMouseMoved implements EventHandler<MouseEvent> {

    private Rotate cannonRotation = new Rotate();
    private Rotate lineRotation = new Rotate();
    private DrawHelpLine drawHelpLine;
    private Point2D shootingBubblePosition;
    private Point2D eventPosition;


    public HandlerAdapterMouseMoved(final Rotate cannonRotation, final Rotate lineRotation, Point2D shootingBubblePosition,
    		DrawHelpLine drawHelpLine) {
    	this.cannonRotation = cannonRotation;
    	this.lineRotation = lineRotation;
        this.shootingBubblePosition = shootingBubblePosition;
        this.drawHelpLine = drawHelpLine;
    }

    @Override
    public final void handle(final MouseEvent event) {
    	this.eventPosition = new Point2D(event.getX(), event.getY());
        this.cannonRotation.setAngle(PhysicHelper.calculateAngle(eventPosition, shootingBubblePosition));
        this.lineRotation.setAngle(PhysicHelper.calculateAngle(eventPosition, shootingBubblePosition));
        this.checkBounds(eventPosition);
    }

    private void checkBounds(final Point2D eventPosition) {
    	double angularCoefficient;
    	double intercepts;
    	boolean flag = false;
    	Point2D startPointFirstLine = new Point2D(this.drawHelpLine.getHelpLine().getStartX(), 
    						 this.drawHelpLine.getHelpLine().getStartY());
    	Point2D startPointSecondLine = null;
    	Point2D endPointSecondLine = null;
      
    	angularCoefficient = PhysicHelper.calculateAngularCoefficient(startPointFirstLine, this.eventPosition);
    	intercepts = PhysicHelper.calculateIntercepts(startPointFirstLine, this.eventPosition);

    	if (!this.drawHelpLine.getHelpLine().isVisible() && this.drawHelpLine.isHelpSelected()) {
    		this.drawHelpLine.getHelpLine().setVisible(true);
    	}

		if (this.drawHelpLine.getHelpBounds().intersects(this.drawHelpLine.getLeftBounds()) 
				&& this.drawHelpLine.isHelpSelected()) {
			startPointSecondLine = new Point2D(0, intercepts);
			endPointSecondLine = new Point2D(Settings.getGuiWidth(), -angularCoefficient * Settings.getGuiWidth() + intercepts);
			flag = PhysicHelper.angleTooHigh(eventPosition, shootingBubblePosition);
			
		}else if(this.drawHelpLine.getHelpBounds().intersects(this.drawHelpLine.getRightBounds()) 
				&& this.drawHelpLine.isHelpSelected()) {

			startPointSecondLine = new Point2D(Settings.getGuiWidth(), angularCoefficient * Settings.getGuiWidth() + intercepts);
			endPointSecondLine = new Point2D(this.drawHelpLine.getHelpLine().getStartX(), 
					startPointFirstLine.getY() - (startPointFirstLine.getY() - startPointSecondLine.getY())*2);

			intercepts = PhysicHelper.calculateIntercepts(startPointSecondLine, endPointSecondLine);

			endPointSecondLine = new Point2D(0, -angularCoefficient * 0 + intercepts);

			flag = PhysicHelper.angleTooHigh(eventPosition, shootingBubblePosition);

		} else {
			this.drawHelpLine.getBoundsLine().setVisible(false);
		}

		if (flag) {
			this.drawHelpLine.drawLine();
			this.drawHelpLine.drawBoundsLine(startPointSecondLine, endPointSecondLine);
		} 
	}

	public final double getRotationAngle() {
        return this.cannonRotation.getAngle();
    }
}
