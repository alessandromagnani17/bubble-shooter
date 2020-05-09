package bubbleshooter.view.cannon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class which represents the Cannon of the game
 * Class which implements {@link ImageView}.
 */
public class Cannon extends ImageView {

    private ImageView cannon;
    private double angle;

    /**
     * Constructor for a new Cannon.
     * 
     * @param img , the image of Cannon.
     */
    public Cannon(final Image img) {
        this.cannon = new ImageView(img);
    }

    /**
     * Method to get the {@link ImageView} of the {@link Cannon}.
     * @return the {@link ImageView} of the {@link Cannon}.
     */
    public final ImageView getCannon() {
        return cannon;
    }

    /**
     * Method to get the angle of {@link Cannon} rotation.
     * @return the angle of {@link Cannon}.
     */
    public final double getAngle() {
        return angle;
    }

    /**
     * Method to set the angle of {@link Cannon} rotation.
     * @param angle , the angle of {@link Cannon}.
     */
    public final void setAngle(final double angle) {
        this.angle = angle;
    }

}
