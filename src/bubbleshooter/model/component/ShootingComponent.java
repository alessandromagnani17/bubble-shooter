package bubbleshooter.model.component;

import javafx.geometry.Point2D;

public class ShootingComponent extends AbstractComponent {

    private Point2D shootingDirection;

    public ShootingComponent() {
        this.setType(ComponentType.SHOOTINGCOMPONENT);
        //this.shootingDirection = this.getContainer().getPosition();
    }

    public final Point2D getDirection() {
        return this.shootingDirection;
    }

    public final void setDirection(final Point2D direction) {
    	this.shootingDirection = direction;
    }

    @Override
    public final void update(final double elapsed) {
        if (!this.shootingDirection.equals(this.getContainer().getPosition())) {
            super.getContainer().setPosition(super.getContainer().getPosition().add(this.shootingDirection.multiply(elapsed)));
          }
    }
}
