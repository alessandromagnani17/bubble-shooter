package bubbleshooter.view.cannon;

import bubbleshooter.model.Model;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.utility.Settings;
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
    private final Bubble shootingBubble;

    /**
     * Constructor for a new DrawCannon.
     * 
     * @param pane                   the panel where draw the {@link Cannon}.
     * @param cannon                 the {@link Cannon} to draw.
     * @param shootingBubble         the {@link ShootingBubble}.
     */
    public DrawCannon(final AnchorPane pane, final Cannon cannon, final Bubble shootingBubble) {
        this.cannon = cannon;
        this.shootingBubble = shootingBubble;
        this.editCannon();
        this.setRotation();
        pane.getChildren().add(this.cannon.getCannon());
    }

    /**
     * Method to set the position of {@link Cannon}.
     */
    private void editCannon() {
        this.cannon.getCannon().setLayoutX((shootingBubble.getPosition().getX() - this.cannon.getCannon().getImage().getWidth() / 2)
                * (Settings.getGuiWidth() / Model.WORLD_WIDTH));
        this.cannon.getCannon().setLayoutY((shootingBubble.getPosition().getY() - this.cannon.getCannon().getImage().getHeight() 
                - shootingBubble.getRadius())  * (Settings.getGuiHeight() / Model.WORLD_HEIGHT));

        this.cannon.getCannon().setFitWidth(Settings.getGuiWidth() / CANNON_FIT_WIDTH);
        this.cannon.getCannon().setFitHeight(Settings.getGuiHeight() / CANNON_FIT_HEIGTH);
    }

    /**
     * Method to set the angle of {@link Cannon} rotation.
     */
    private void setRotation() {
        this.rotation.setPivotX(this.cannon.getCannon().getFitWidth() - (shootingBubble.getWidth() * (Settings.getGuiWidth() / Model.WORLD_WIDTH)));
        this.rotation.setPivotY(this.cannon.getCannon().getFitHeight());

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
