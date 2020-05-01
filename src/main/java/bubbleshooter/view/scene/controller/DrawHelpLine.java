package bubbleshooter.view.scene.controller;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class DrawHelpLine {
	
	private AnchorPane pane = new AnchorPane();
	private Line helpLine = new Line(352.5, 574.0, 352.5, 0); 
	private Line borderLeft = new Line(0, 0, 0, 700);
	private Line borderRight = new Line(705, 0, 705, 700);
	Rotate rotation = new Rotate();

	public DrawHelpLine(AnchorPane pane) {
		this.pane = pane;
		this.borderLeft.setVisible(false);
		this.borderRight.setVisible(false);
		this.helpLine.setVisible(false);
		this.pane.getChildren().add(borderRight);
		this.pane.getChildren().add(borderLeft);
		this.pane.getChildren().add(helpLine);
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
