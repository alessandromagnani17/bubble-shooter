package bubbleshooter.model.gameobject;

import bubbleshooter.view.images.Color;
import javafx.geometry.Point2D;


public class ShootingBubble extends BasicBubble implements Bubble  {

    private Point2D direction;

    public ShootingBubble(final Point2D position, final Color color) {
        super(position, color);
        super.setType(GameObjectsTypes.MOVINGBUBBLE);
    }

    
    public final void setDirection(final Point2D direction) {
        this.direction = direction;
    }

    public final Point2D getDirection() {
        return this.direction;
    }

    public final void update(final double elapsed) {
        this.setPosition(this.getPosition().add(this.direction).multiply(elapsed));
    }
}
