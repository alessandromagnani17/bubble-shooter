package bubbleshooter.view.helpline;

import bubbleshooter.utility.Settings;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

/**
 * 
 * Class used for draw the help line if the 'help' CheckBox in {@link GameController} is selected.
 *
 */
public class DrawHelpLine {

    private final AnchorPane pane;
    private static final Point2D START_POINT_FIRST_LINE = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeight() / 1.08);
    private final HelpLine helpLine;
    private final HelpLine boundsLine;
    private final Line borderRight;
    private final Line borderLeft;
    private final Rotate rotation = new Rotate();
    private boolean helpSelected;

    /**
     * Constructor for a new DrawHelpLine.
     * 
     * @param pane the pane where draw the help line.
     */
    public DrawHelpLine(final AnchorPane pane) {
        this.pane = pane;
        this.helpLine = new HelpLine(START_POINT_FIRST_LINE, new Point2D(START_POINT_FIRST_LINE.getX(), 0));
        this.boundsLine = new HelpLine(new Point2D(0, 0), new Point2D(0, 0));
        this.borderRight = new Line(Settings.getGuiWidth(), 0, Settings.getGuiWidth(), Settings.getGuiHeight());
        this.borderRight.setVisible(false);
        this.borderLeft = new Line(0, 0, 0, Settings.getGuiHeight());
        this.borderLeft.setVisible(false);

        this.setRotation();

        this.pane.getChildren().add(helpLine.getLine());
        this.pane.getChildren().add(boundsLine.getLine());
        this.pane.getChildren().add(borderRight);
        this.pane.getChildren().add(borderLeft);
    }

    /**
     * Private method for set the rotation of help line.
     */
    private void setRotation() {
        this.rotation.setPivotX(START_POINT_FIRST_LINE.getX());
        this.rotation.setPivotY(START_POINT_FIRST_LINE.getY());
        this.helpLine.getLine().getTransforms().add(this.rotation);
    }

    /**
     * @return the bounds of help line.
     */
    public final Bounds getHelpBounds() {
        return helpLine.getLine().getBoundsInParent();
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
        return this.boundsLine.getLine();
    }

    /**
     * @return the help line.
     */
    public final Line getHelpLine() {
        return this.helpLine.getLine();
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
        this.helpLine.getLine().setVisible(false);
        this.boundsLine.getLine().setVisible(false);
        this.helpSelected = false;
    }

    /**
     * Method called by {@link HandlerAdapterMouseMoved} for draw the bounds line 
     * passing start point and end point.
     * 
     * @param startPointSecondLine the start point.
     * @param endPointSecondLine   the end point.
     */
    public final void drawBoundsLine(final Point2D startPointSecondLine, final Point2D endPointSecondLine) {
        this.boundsLine.getLine().setStartX(startPointSecondLine.getX());
        this.boundsLine.getLine().setStartY(startPointSecondLine.getY());
        this.boundsLine.getLine().setEndX(endPointSecondLine.getX());
        this.boundsLine.getLine().setEndY(endPointSecondLine.getY());
        this.boundsLine.getLine().setVisible(true);
    }
}
