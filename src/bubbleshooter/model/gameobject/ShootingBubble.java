package bubbleshooter.model.gameobject;

import bubbleshooter.utility.PhysicHelper;
import javafx.geometry.Point2D;


public class ShootingBubble extends BasicBubble {

    private Point2D shootingDirection;

    public ShootingBubble(final Point2D position) {
        super(position);
        super.setType(GameObjectsTypes.SHOOTINGBUBBLE);
        this.shootingDirection = this.getPosition();
    }

    public final void setDirection(final Point2D direction) {
        this.shootingDirection = direction;
    }

    public final Point2D getDirection() {
        return this.shootingDirection;
    }

    public final void update(final double elapsed) {
    	System.out.println(super.getPosition());
    	super.setPosition(super.getPosition().add(this.shootingDirection));
    }

}
