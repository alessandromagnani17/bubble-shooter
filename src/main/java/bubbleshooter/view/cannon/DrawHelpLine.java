package bubbleshooter.view.cannon;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.ShootingBubble;
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

    private AnchorPane pane = new AnchorPane();
    private static final Point2D START_POINT_FIRST_LINE = new Point2D(Settings.getGuiWidth() / 2, 
                                 Settings.getGuiHeigth() - Bubble.WIDTH - ShootingBubble.RADIUS);
    private HelpLine helpLine;
    private HelpLine boundsLine;
    private HelpLine borderRight;
    private HelpLine borderLeft;
    private Rotate rotation = new Rotate();
    private boolean helpSelected = false;

    /**
     * Constructor for a new DrawHelpLine.
     * 
     * @param pane the pane where draw the help line.
     */
    public DrawHelpLine(final AnchorPane pane) {
        this.pane = pane;
        /*this.helpLine = new HelpLine(START_POINT_FIRST_LINE.getX(), START_POINT_FIRST_LINE.getY(), 
                                     START_POINT_FIRST_LINE.getX(), 0);*/
        this.helpLine = new HelpLine(START_POINT_FIRST_LINE, new Point2D(START_POINT_FIRST_LINE.getX(), 0));
        this.boundsLine = new HelpLine(new Point2D(0, 0), new Point2D(0, 0));
        this.borderRight = new HelpLine(new Point2D(Settings.getGuiWidth(), 0), 
        		                        new Point2D(Settings.getGuiWidth(), Settings.getGuiHeigth()));
        this.borderLeft = new HelpLine(new Point2D(0, 0), new Point2D(0, Settings.getGuiHeigth()));

        this.setRotation();

        this.pane.getChildren().add(helpLine.getLine());
        this.pane.getChildren().add(boundsLine.getLine());
        this.pane.getChildren().add(borderRight.getLine());
        this.pane.getChildren().add(borderLeft.getLine());

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
        return borderRight.getLine().getBoundsInParent();
    }

    /**
     * @return the bounds of left line.
     */
    public final Bounds getLeftBounds() {
        return borderLeft.getLine().getBoundsInParent();
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
     * Method for draw the bounds line passing start point and end point.
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
