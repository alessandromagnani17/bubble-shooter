package bubbleshooter.model.gameobject;

import org.locationtech.jts.math.Vector2D;

import bubbleshooter.view.images.Color;
import javafx.geometry.Point2D;

public class ShootingBubble extends BasicBubble  {

    private Vector2D direction;
    
    public ShootingBubble(final Point2D position, final Color color) {
        super(position, color);
    }

    public final void setDirection(final Vector2D direction) {
        this.direction = direction;
    }
    
    public final Vector2D getDirection() {
        return this.direction;
    }
}
