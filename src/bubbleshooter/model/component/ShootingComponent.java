package bubbleshooter.model.component;

import javafx.geometry.Point2D;

public class ShootingComponent extends AbstractComponent {

    private Point2D shootingDirection;

    public ShootingComponent(final ComponentType type) {
        super(type);
        this.shootingDirection = this.getContainer().getPosition();
    }

    public final Point2D getDirection() {
        return this.shootingDirection;
    }

    @Override
    public final void update(final double elapsed) {
        if (!this.shootingDirection.equals(this.getContainer().getPosition())) {
            super.getContainer().setPosition(super.getContainer().getPosition().add(this.shootingDirection.multiply(elapsed)));
          }
    }
}
