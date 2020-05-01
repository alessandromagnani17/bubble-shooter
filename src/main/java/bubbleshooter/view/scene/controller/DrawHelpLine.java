package bubbleshooter.view.scene.controller;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class DrawHelpLine {
	
	private AnchorPane pane = new AnchorPane();
	private Line helpLine = new Line(352.5, 574.0, 352.5, 0); 
	private Line borderLeft = new Line(0, 0, 0, 700);
	private Line borderRight = new Line(705, 0, 705, 700);

	public DrawHelpLine(AnchorPane pane) {
		this.pane = pane;
	}

	public void drawLine() {
		//this.borderLeft.setVisible(false);
		//this.borderRight.setVisible(false);
		this.pane.getChildren().add(helpLine);
		this.pane.getChildren().add(borderRight);
		this.pane.getChildren().add(borderLeft);
	}

	public void deleteLine() {
		this.helpLine.setVisible(false);
	}

}
