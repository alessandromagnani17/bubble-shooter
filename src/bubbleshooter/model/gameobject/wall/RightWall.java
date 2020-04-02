package bubbleshooter.model.gameobject.wall;

import bubbleshooter.model.collision.CollisionAcceptor;
import bubbleshooter.model.collision.Visitor;
import bubbleshooter.model.gameobject.AbstractGameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class RightWall extends AbstractGameObject implements CollisionAcceptor {

    public RightWall() {
        super.setType(GameObjectsTypes.RIGHTWALL);
        super.setPosition(new Point2D(GameCostants.GUIWIDTH.getValue(), 0));
        super.setShape(new Line(super.getPosition().getX(), super.getPosition().getY(), GameCostants.GUIWIDTH.getValue(), GameCostants.GUIHEIGTH.getValue()));
    }

    @Override
    public final void accept(final Visitor visitor, final GameObjectManager gameObjectManager) {
        visitor.visit(this, GameObjectsTypes.RIGHTWALL, gameObjectManager);
    }

}
