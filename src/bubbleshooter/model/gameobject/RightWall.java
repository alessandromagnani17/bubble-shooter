package bubbleshooter.model.gameobject;

import bubbleshooter.utility.GameCostants;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class RightWall extends AbstractGameObject {

    public RightWall() {
        super.setType(GameObjectsTypes.RIGHTWALL);
        super.setPosition(new Point2D(GameCostants.GUIWIDTH.getValue(), 0));
        super.setShape(new Line(super.getPosition().getX(), super.getPosition().getY(), GameCostants.GUIWIDTH.getValue(), GameCostants.GUIHEIGTH.getValue()));
    }

}
