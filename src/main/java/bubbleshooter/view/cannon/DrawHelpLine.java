package bubbleshooter.view.cannon;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.utility.Settings;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class DrawHelpLine {
	
	private AnchorPane pane = new AnchorPane();
	
	private static final Point2D START_POINT_FIRST_LINE = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() - Bubble.getWidth());
    public static final double DASH_SIZE = Settings.getGuiHeigth()/70;
    public static final double DASH_WIDTH = Settings.getGuiHeigth()/200;
	private Line helpLine = new Line(START_POINT_FIRST_LINE.getX(), START_POINT_FIRST_LINE.getY(), START_POINT_FIRST_LINE.getX(), 0);
	private Line borderRight = new Line(Settings.getGuiWidth(), 0, Settings.getGuiWidth(), Settings.getGuiHeigth());
    private Line borderLeft = new Line(0, 0, 0, Settings.getGuiHeigth());
    private Line boundsLine = new Line(0,0,0,0);
	private Rotate rotation = new Rotate();
	private boolean helpSelected = false;

	public DrawHelpLine(AnchorPane pane) {
		this.pane = pane;
		this.editLine(this.helpLine);
		this.editLine(this.boundsLine);
		this.setRotation();
		this.setInvisibleLine();
		this.pane.getChildren().add(helpLine);
		this.pane.getChildren().add(borderRight);
		this.pane.getChildren().add(borderLeft);
		this.pane.getChildren().add(boundsLine);
	}

	private void setInvisibleLine() {
		this.helpLine.setVisible(false);
		this.helpLine.setMouseTransparent(true);
		this.borderRight.setVisible(false);
		this.borderRight.setMouseTransparent(true);
		this.borderLeft.setVisible(false);
		this.borderLeft.setMouseTransparent(true);
		this.boundsLine.setVisible(false);
		this.boundsLine.setMouseTransparent(true);
	}

	private void editLine(Line line) {
		line.setStroke(Color.RED);
		line.setStrokeWidth(DASH_WIDTH);
		line.getStrokeDashArray().add(DASH_SIZE);
	}

	private void setRotation() {
		this.rotation.setPivotX(START_POINT_FIRST_LINE.getX());
		this.rotation.setPivotY(START_POINT_FIRST_LINE.getY());
		this.helpLine.getTransforms().add(this.rotation);
	}
	
	public Bounds getHelpBounds() {
		return helpLine.getBoundsInParent();
	}
	
	public Bounds getRightBounds() {
		return borderRight.getBoundsInParent();
	}
	
	public Bounds getLeftBounds() {
		return borderLeft.getBoundsInParent();
	}
	
	public boolean isHelpSelected() {
		return this.helpSelected;
	}
	
	public Line getHelpLine() {
		return this.helpLine;
	}

	public void drawLine() {
		this.helpLine.setVisible(true);
		this.helpSelected = true;
	}

	public void deleteLine() {
		this.helpLine.setVisible(false);
		this.boundsLine.setVisible(false);
		this.helpSelected = false;
	}

	public Rotate getRotation() {
		return this.rotation;
	}

	public Line getBoundsLine() {
		return this.boundsLine;
	}

	public void drawBoundsLine(final Point2D startPointSecondLine, final Point2D endPointSecondLine) {
		this.boundsLine.setStartX(startPointSecondLine.getX());
		this.boundsLine.setStartY(startPointSecondLine.getY());
		this.boundsLine.setEndX(endPointSecondLine.getX());
		this.boundsLine.setEndY(endPointSecondLine.getY());
		this.boundsLine.setVisible(true);
	}

}
