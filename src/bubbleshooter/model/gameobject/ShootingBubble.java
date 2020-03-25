package bubbleshooter.model.gameobject;

import org.locationtech.jts.math.Vector2D;
import bubbleshooter.view.images.Color;


public class ShootingBubble extends BasicBubble implements Bubble  {

    private Vector2D direction;

    public ShootingBubble(final Vector2D position, final Color color) {
        super(position, color);
    }

    public final void setDirection(final Vector2D direction) {
        this.direction = direction;
    }

    public final Vector2D getDirection() {
        return this.direction;
    }

    public final void update(final double elapsed) {
        this.setPosition(new Vector2D(this.getPosition().add(direction)));
    }
}
