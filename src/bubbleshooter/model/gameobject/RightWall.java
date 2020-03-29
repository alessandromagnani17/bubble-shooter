package bubbleshooter.model.gameobject;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class RightWall extends AbstractGameObject {

    private Line bound;

    public RightWall() {
        super.setType(GameObjectsTypes.RIGHTWALL);
        super.setPosition(new Point2D(100, 0));
        this.bound = new Line(super.getPosition().getX(), super.getPosition().getY(), 100, 100);
    }

    
    @Override
    public Shape getShape() {
        return bound;
    }

}
