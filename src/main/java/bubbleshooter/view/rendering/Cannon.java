package bubbleshooter.view.rendering;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cannon extends ImageView {

    private ImageView cannon;
    private double angle;

    public Cannon(final Image img) {
        this.cannon = new ImageView(img);
    }

    public final ImageView getCannon() {
        return cannon;
    }

    public final double getAngle() {
        return angle;
    }

    public final void setAngle(final double angle) {
        this.angle = angle;
    }

}
