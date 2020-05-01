package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.HandlerAdapterMouseClicked;
import bubbleshooter.controller.HandlerAdapterMouseMoved;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class DrawHelpLine {
	
	private AnchorPane pane = new AnchorPane();
	private Line helpLine = new Line(352.5, 574.0, 352.5, 0); 
	private Line borderLeft = new Line(0, 0, 0, 700);
	private Line borderRight = new Line(705, 0, 705, 700);
	private static final double X_BUBBLE = 352.5;
	private static final double Y_BUBBLE = 600.0;
	Rotate rotation = new Rotate();

	public DrawHelpLine(AnchorPane pane) {
		this.pane = pane;
		this.editHelpLine();
		this.setRotation();
		this.pane.setOnMouseMoved(new HandlerAdapterMouseMoved(this.rotation, 352.5, 574.0));
		this.borderLeft.setVisible(false);
		this.borderRight.setVisible(false);
		this.helpLine.setVisible(false);
		this.pane.getChildren().add(borderRight);
		this.pane.getChildren().add(borderLeft);
		this.pane.getChildren().add(helpLine);
	}

	private void editHelpLine() {
		this.helpLine.setStroke(Color.RED);
		this.helpLine.setStrokeWidth(4);
		this.helpLine.getStrokeDashArray().add(10.0);
	}

	private void setRotation() {
		this.rotation.setPivotX(352.5);
		this.rotation.setPivotY(574.0);
		this.helpLine.getTransforms().add(this.rotation);
	}

	public void drawLine() {
		this.helpLine.setVisible(true);
	}

	public void deleteLine() {
		this.helpLine.setVisible(false);
	}
	
	public Line getHelpLine() {
		return this.helpLine;
	}

}
