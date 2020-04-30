package bubbleshooter.model.component;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CollisionComponent extends AbstractComponent {

    public CollisionComponent() {
        this.setType(ComponentType.COLLISIONCOMPONENT);
    }

   public final Shape getCollisionShape() {
        final Point2D bubblePosition = super.getContainer().getPosition();
        return new Circle(bubblePosition.getX(), bubblePosition.getY(), super.getContainer().getRadius());
    }
}
