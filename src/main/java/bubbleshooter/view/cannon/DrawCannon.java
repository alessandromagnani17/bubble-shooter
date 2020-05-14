package bubbleshooter.view.cannon;

import bubbleshooter.controller.Controller;
import bubbleshooter.model.bubble.BubbleType;
import bubbleshooter.utility.Settings;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

/**
 * Class used for draw the {@link Cannon} passed by {@link GameController}.
 * 
 */
public class DrawCannon {

    private static final double CANNON_FIT_WIDTH = 10;
    private static final double CANNON_FIT_HEIGTH = 6;

    private final Rotate rotation = new Rotate();
    private final Cannon cannon;
    private final Controller controller;


    /**
     * Constructor for a new DrawCannon.
     * 
     * @param pane       the panel where draw the {@link Cannon}.
     * @param cannon     the {@link Cannon} to draw.
     * @param controller the {@link Controller} used to dialogue with {@link Model} and {@link View}.
     */
    public DrawCannon(final AnchorPane pane, final Cannon cannon, final Controller controller) {
        this.cannon = cannon;
        this.controller = controller;
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
        this.cannon.getCannon().setLayoutX((this.controller.getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE))
                .findFirst().get().getPosition().getX() - this.cannon.getCannon().getImage().getWidth() / 2)
                * (Settings.getGuiWidth() / this.controller.getWorldWidth()));
        this.cannon.getCannon().setLayoutY((this.controller.getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE))
                .findFirst().get().getPosition().getY() - this.cannon.getCannon().getImage().getHeight() 
                - this.controller.getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE))
                .findFirst().get().getRadius()) * (Settings.getGuiHeight() / this.controller.getWorldHeight()));

        this.cannon.getCannon().setFitWidth(Settings.getGuiWidth() / CANNON_FIT_WIDTH);
        this.cannon.getCannon().setFitHeight(Settings.getGuiHeight() / CANNON_FIT_HEIGTH);
    }

    /**
     * Method to set the angle of {@link Cannon} rotation.
     */
    private void setRotation() {
        this.rotation.setPivotX((this.cannon.getCannon().getFitWidth() - this.controller.getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE))
                .findFirst().get().getWidth()) * (Settings.getGuiWidth() / this.controller.getWorldWidth()));
        this.rotation.setPivotY(this.cannon.getCannon().getFitHeight());

        this.cannon.getCannon().getTransforms().add(rotation);
    }

}
