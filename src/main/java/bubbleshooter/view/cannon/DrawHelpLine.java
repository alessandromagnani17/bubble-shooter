package bubbleshooter.view.cannon;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.utility.Settings;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

/**
 * 
 * Class used for draw the help line if the 'help' CheckBox in {@link GameController} is selected.
 *
 */
public class DrawHelpLine {

    private AnchorPane pane = new AnchorPane();
    private static final Point2D START_POINT_FIRST_LINE = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() - Bubble.WIDTH);
    public static final double DASH_SIZE = Settings.getGuiHeigth() / 70;
    public static final double DASH_WIDTH = Settings.getGuiHeigth() / 200;
    private Line helpLine = new Line(START_POINT_FIRST_LINE.getX(), START_POINT_FIRST_LINE.getY(), START_POINT_FIRST_LINE.getX(), 0);
    private Line borderRight = new Line(Settings.getGuiWidth(), 0, Settings.getGuiWidth(), Settings.getGuiHeigth());
    private Line borderLeft = new Line(0, 0, 0, Settings.getGuiHeigth());
    private Line boundsLine = new Line(0, 0, 0, 0);
    private Rotate rotation = new Rotate();
    private boolean helpSelected = false;

    /**
     * Constructor for a new DrawHelpLine.
     * 
     * @param pane the pane where draw the help line.
     */
    public DrawHelpLine(final AnchorPane pane) {
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

    /**
     * Private method for make invisible and mouse transparent all the lines.
     */
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

    /**
     * Private method for edit a line.
     */
    private void editLine(final Line line) {
        line.setStroke(Color.RED);
        line.setStrokeWidth(DASH_WIDTH);
        line.getStrokeDashArray().add(DASH_SIZE);
    }

    /**
     * Private method for set the rotation of help line.
     */
    private void setRotation() {
        this.rotation.setPivotX(START_POINT_FIRST_LINE.getX());
        this.rotation.setPivotY(START_POINT_FIRST_LINE.getY());
        this.helpLine.getTransforms().add(this.rotation);
    }

    /**
     * @return the bounds of help line.
     */
    public final Bounds getHelpBounds() {
        return helpLine.getBoundsInParent();
    }

    /**
     * @return the bounds of right line.
     */
    public final Bounds getRightBounds() {
        return borderRight.getBoundsInParent();
    }

    /**
     * @return the bounds of left line.
     */
    public final Bounds getLeftBounds() {
        return borderLeft.getBoundsInParent();
    }

    /**
     * @return the rotation of help line.
     */
    public final Rotate getRotation() {
        return this.rotation;
    }

    /**
     * @return the bounds line.
     */
    public final Line getBoundsLine() {
        return this.boundsLine;
    }

    /**
     * @return the help line.
     */
    public final Line getHelpLine() {
        return this.helpLine;
    }

    /**
     * @return the value of help CheckBox.
     */
    public final boolean isHelpSelected() {
        return this.helpSelected;
    }

    /**
     * Method for draw the help line.
     */
    public final void drawLine() {
        this.helpSelected = true;
    }

    /**
     * Method for delete the help line.
     */
    public final void deleteLine() {
        this.helpLine.setVisible(false);
        this.boundsLine.setVisible(false);
        this.helpSelected = false;
    }

    /**
     * Method for draw the bounds line passing start point and end point.
     * 
     * @param startPointSecondLine the start point.
     * @param endPointSecondLine   the end point.
     */
    public final void drawBoundsLine(final Point2D startPointSecondLine, final Point2D endPointSecondLine) {
        this.boundsLine.setStartX(startPointSecondLine.getX());
        this.boundsLine.setStartY(startPointSecondLine.getY());
        this.boundsLine.setEndX(endPointSecondLine.getX());
        this.boundsLine.setEndY(endPointSecondLine.getY());
        this.boundsLine.setVisible(true);
    }
}
