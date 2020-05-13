package bubbleshooter.view.cannon;

import bubbleshooter.model.Model;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

/**
 * Class used for draw the {@link Cannon} passed by {@link GameController}.
 * 
 */
public class DrawCannon {

    private static final double CANNON_FIT_WIDTH = 10;
    private static final double CANNON_FIT_HEIGTH = 5;

    private final Rotate rotation = new Rotate();
    private final Cannon cannon;
    private final Point2D shootingBubblePosition;
    private final double shootingBubbleRadius;
    private final double shootingBubbleWidth;


    /**
     * Constructor for a new DrawCannon.
     * 
     * @param pane                   the panel where draw the {@link Cannon}.
     * @param cannon                 the {@link Cannon} to draw.
     * @param shootingBubblePosition the position of {@link ShootingBubble}.
     * @param shootingBubbleRadius   the radius of {@link ShootingBubble}.
     * @param shootingBubbleWidth    the width of {@link ShootingBubble}.
     */
    public DrawCannon(final AnchorPane pane, final Cannon cannon, final Point2D shootingBubblePosition,
            final double shootingBubbleRadius, final double shootingBubbleWidth) {
        this.cannon = cannon;
        this.shootingBubblePosition = shootingBubblePosition;
        this.shootingBubbleRadius = shootingBubbleRadius;
        this.shootingBubbleWidth = shootingBubbleWidth;
        this.editCannon();
        this.setRotation();
        pane.getChildren().add(this.cannon.getCannon());
    }

    /**
     * Method to get the angle of {@link Cannon} rotation.
     * @return the angle of {@link Cannon}.
     */
    public final Rotate getRotation() {
        return this.rotation;
    }

    /**
     * Method to set the position of {@link Cannon}.
     */
    private void editCannon() {
        this.cannon.getCannon().setLayoutX((this.shootingBubblePosition.getX() - this.cannon.getCannon().getImage().getWidth() / 2)
                * (Settings.getGuiWidth() / Model.WORLD_WIDTH));
        this.cannon.getCannon().setLayoutY((this.shootingBubblePosition.getY() - this.cannon.getCannon().getImage().getHeight() 
                - this.shootingBubbleRadius) * (Settings.getGuiHeight() / Model.WORLD_HEIGHT));

        this.cannon.getCannon().setFitWidth(Settings.getGuiWidth() / CANNON_FIT_WIDTH);
        this.cannon.getCannon().setFitHeight(Settings.getGuiHeight() / CANNON_FIT_HEIGTH);
    }

    /**
     * Method to set the angle of {@link Cannon} rotation.
     */
    private void setRotation() {
        this.rotation.setPivotX(this.cannon.getCannon().getFitWidth() - (this.shootingBubbleWidth * (Settings.getGuiWidth() / Model.WORLD_WIDTH)));
        this.rotation.setPivotY(this.cannon.getCannon().getFitHeight());

        this.cannon.getCannon().getTransforms().add(rotation);
    }

}
