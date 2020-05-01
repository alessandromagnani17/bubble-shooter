package bubbleshooter.model.component;

import bubbleshooter.model.gameobject.Bubble;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CollisionComponent extends AbstractComponent {

    public CollisionComponent(final Bubble container) {
        super(container);
        this.setType(ComponentType.COLLISIONCOMPONENT);
    }

   public final Shape getCollisionShape() {
        final Point2D containerPosition = super.getContainer().getPosition();
        return new Circle(containerPosition.getX(), containerPosition.getY(), super.getContainer().getRadius());
    }
}
