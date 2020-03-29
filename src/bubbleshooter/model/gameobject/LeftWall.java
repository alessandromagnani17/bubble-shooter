package bubbleshooter.model.gameobject;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class LeftWall extends AbstractGameObject {

    private Line bound;
    
    public LeftWall() {
        super.setType(GameObjectsTypes.LEFTWALL);
        super.setPosition(new Point2D(0, 0));
        this.bound = new Line(super.getPosition().getX(), super.getPosition().getY(),0,100);
    }

    @Override
    public Shape getShape() {
        return this.bound;
    }
    
}
