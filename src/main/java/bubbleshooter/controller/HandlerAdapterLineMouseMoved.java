package bubbleshooter.controller;

import bubbleshooter.utility.PhysicHelper;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class HandlerAdapterLineMouseMoved implements EventHandler<MouseEvent> {
	
	private Rotate rotation = new Rotate();
    private double xBubble;
    private double yBubble;
    private Line helpLine;
    private Line borderRight;
    private Line borderLeft;
    
    
    
	public HandlerAdapterLineMouseMoved(Rotate rotation, double xBubble, double yBubble, Line helpLine,
			Line borderRight, Line borderLeft) {
		this.rotation = rotation;
		this.xBubble = xBubble;
		this.yBubble = yBubble;
		this.helpLine = helpLine;
		this.borderRight = borderRight;
		this.borderLeft = borderLeft;
	}



	@Override
	public void handle(MouseEvent event) {
		rotation.setAngle(PhysicHelper.calculateAngle(event, xBubble, yBubble));
		
	}

}
