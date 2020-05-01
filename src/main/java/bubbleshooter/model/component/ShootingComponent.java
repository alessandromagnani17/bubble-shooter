package bubbleshooter.model.component;

import bubbleshooter.model.gameobject.Bubble;
import javafx.geometry.Point2D;

public class ShootingComponent extends AbstractComponent {

    private static final double BUBBLESPEED = 0.9;
    private Point2D direction;

    public ShootingComponent(final Bubble container) {
        super(container);
        this.direction = container.getPosition();
        this.setType(ComponentType.SHOOTINGCOMPONENT);
    }

    @Override
    public final void update(final double elapsed) {
        if (!this.getContainer().getPosition().equals(this.direction)) {
            this.moveBubble(elapsed);
          }
    }

    private void moveBubble(final double elapsed) {
        this.getContainer().setPosition(this.getContainer().getPosition().add(this.direction.multiply(elapsed).multiply(BUBBLESPEED)));
    }

    public final void setDirection(final Point2D direction) {
        this.direction = direction;
    }

    public final Point2D getDirection() {
        return this.direction;
    }
}
