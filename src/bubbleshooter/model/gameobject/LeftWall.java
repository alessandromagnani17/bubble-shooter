package bubbleshooter.model.gameobject;

import bubbleshooter.utility.GameCostants;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class LeftWall extends AbstractGameObject {

    public LeftWall() {
        super.setType(GameObjectsTypes.LEFTWALL);
        super.setPosition(new Point2D(0, 0));
        super.setShape(new Line(super.getPosition().getX(), super.getPosition().getY(), 0, GameCostants.GUIHEIGTH.getValue()));
    }

}
