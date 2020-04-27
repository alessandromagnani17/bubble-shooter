package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cannon extends ImageView {

    private ImageView cannon;
    private double angle;
    private Point2D pivot; 
    

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

	public Point2D getPivot() {
		return pivot;
	}
    
    
}