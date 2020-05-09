package bubbleshooter.view.cannon;

import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

/**
 * Class used for draw the {@link Cannon} passed by {@link GameController}.
 * 
 */
public class DrawCannon {

    private static final Point2D CANNON_POSITION = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() / 1.36);

    private AnchorPane pane = new AnchorPane();
    private Rotate rotation = new Rotate();
    private Cannon cannon;
    private Point2D shootingBubblePosition;

    /**
     * Constructor for a new DrawCannon.
     * 
     * @param pane                   the panel where draw the {@link Cannon}.
     * @param cannon                 the {@link Cannon} to draw.
     * @param shootingBubblePosition the position of the {@link ShootingBubble}.
     */
    public DrawCannon(final AnchorPane pane, final Cannon cannon, final Point2D shootingBubblePosition) {
        this.pane = pane;
        this.cannon = cannon;
        this.shootingBubblePosition = shootingBubblePosition;
        this.editCannon();
        this.setRotation();
        this.pane.getChildren().add(this.cannon.getCannon());
    }

    /**
     * Method to set the position of {@link Cannon}.
     */
    private void editCannon() {
        this.cannon.getCannon().setLayoutX(CANNON_POSITION.getX() - this.cannon.getCannon().getImage().getWidth() / 2);
        this.cannon.getCannon().setLayoutY(CANNON_POSITION.getY());
    }

    /**
     * Method to set the angle of {@link Cannon} rotation.
     */
    private void setRotation() {
        this.rotation.setPivotX(shootingBubblePosition.getX() - CANNON_POSITION.getX() + this.cannon.getCannon().getImage().getWidth() / 2);
        this.rotation.setPivotY(shootingBubblePosition.getY() - CANNON_POSITION.getY());
        this.cannon.getCannon().getTransforms().add(rotation);
    }

    /**
     * Method to get the angle of {@link Cannon} rotation.
     * @return the angle of {@link Cannon}.
     */
    public final Rotate getRotation() {
        return this.rotation;
    }
}
