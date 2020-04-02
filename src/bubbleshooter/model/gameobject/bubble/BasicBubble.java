package bubbleshooter.model.gameobject.bubble;

import bubbleshooter.model.collision.CollisionAcceptor;
import bubbleshooter.model.collision.Visitor;
import bubbleshooter.model.gameobject.AbstractGameObject;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class BasicBubble extends AbstractGameObject implements CollisionAcceptor {

    public BasicBubble(final Point2D position) {
        super.setType(GameObjectsTypes.BASICBUBBLE);
        super.setPosition(position);
        super.setHeigth(GameCostants.RADIUS.getValue() * 2);
        super.setWidth(super.getHeight()); 
        super.setShape(new Circle(super.getPosition().getX(), super.getPosition().getY(), GameCostants.RADIUS.getValue()));
    }

    @Override
    public final void setPosition(final Point2D position) {
        super.setPosition(position);
        ((Circle) super.getShape()).setCenterX(position.getX());
        ((Circle) super.getShape()).setCenterY(position.getY());
    }

    @Override
    public final void accept(final Visitor visitor, final GameObjectManager gameObjectManager) {
        visitor.visit(this, GameObjectsTypes.BASICBUBBLE, gameObjectManager);
    }

}
