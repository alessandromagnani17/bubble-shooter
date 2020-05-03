package bubbleshooter.controller;

import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.utility.Settings;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class HandlerAdapterLineMouseMoved implements EventHandler<MouseEvent> {
	
	private AnchorPane pane;
	private Rotate rotation = new Rotate();
    private double xBubble;
    private double yBubble;
    private Line helpLine;
    private Line borderRight = new Line(Settings.getGuiWidth(), 0, Settings.getGuiWidth(), Settings.getGuiHeigth());
    private Line borderLeft = new Line(0, 0, 0, Settings.getGuiHeigth());
    private Line boundsLine = new Line(0,0,0,0);
    
    
	public HandlerAdapterLineMouseMoved(Rotate rotation, double xBubble, double yBubble, Line helpLine, AnchorPane pane) {
		this.rotation = rotation;
		this.xBubble = xBubble;
		this.yBubble = yBubble;
		this.helpLine = helpLine;
		this.pane = pane;
		this.boundsLine.setStroke(Color.RED);
		this.boundsLine.setStrokeWidth(4);
		this.boundsLine.getStrokeDashArray().add(10.0);
		this.boundsLine.setVisible(false);
		this.borderLeft.setVisible(false);
		this.borderRight.setVisible(false);
		this.pane.getChildren().add(this.borderRight);
		this.pane.getChildren().add(this.borderLeft);
		this.pane.getChildren().add(this.boundsLine);
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		System.out.println("xMouse --> " + event.getX());
		System.out.println("yMouse --> " + event.getY());
		
		this.rotation.setAngle(PhysicHelper.calculateAngle(event, xBubble, yBubble));
		/*
		Bounds s1 = helpLine.getBoundsInParent();
        Bounds s2 = borderRight.getBoundsInParent();
        Bounds s3 = borderLeft.getBoundsInParent();
        
        double angularCoeff, intercepts, xInt, yInt, newY, X1, Y1;
        double x1 = helpLine.getStartX();
    	double y1 = helpLine.getStartY();
    	double x2 = event.getX();
    	double y2 = event.getY();
    	
    	//coeffAng = (y2-y1)/(x2-x1);
    	angularCoeff = PhysicHelper.calculateAngularCoefficient(x1,y1,x2,y2);
    	//interc = (x2*y1 - x1*y2)/(x2-x1);
    	intercepts = PhysicHelper.calculateIntercepts(x1,y1,x2,y2);
        if(boundsLine.isVisible()) {
        	boundsLine.setVisible(false);
        }
        
        if(s1.intersects(s3)) {
        	
        	xInt = 705;
        	yInt = angularCoeff*705 + intercepts;
        	
        	X1 = xBubble;
        	Y1 = (yBubble - yInt) * 2;
        	
        	intercepts = (X1*yInt - xInt*Y1)/(X1-xInt);
        	
        	newY = -angularCoeff*0 - intercepts;
        	
        	writeLine(boundsLine, xInt, yInt, 0, newY);
        }
        
		if (s1.intersects(s2)) {
        	
        	xInt = 0;
        	yInt = intercepts;
        	
        	newY = -angularCoeff*705 + intercepts;
        	
        	writeLine(boundsLine, xInt, yInt, 705, newY);
        	
        }
		
		if(!this.helpLine.isVisible()) {
			this.boundsLine.setVisible(false);
		}
		*/
	}

	private void writeLine(Line line, double xInt, double yInt, int endX, double endY) {
		line.setStartX(xInt);
		line.setStartY(yInt);
		line.setEndX(endX);
		line.setEndY(endY);
		line.setVisible(true);
	}

}
