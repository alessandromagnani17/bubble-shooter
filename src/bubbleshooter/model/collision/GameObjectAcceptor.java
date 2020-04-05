package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.bubble.BubbleGridManager;

public class GameObjectCollided implements CollisionAcceptor {

    private GameObject gameObjectCollided;

    public GameObjectCollided(final GameObject collided) {
        this.gameObjectCollided = collided;
    }

    @Override
    public final void accept(final Visitor visitor, final BubbleGridManager gridManager) {
        visitor.visit(this.gameObjectCollided, this.gameObjectCollided.getType(), gridManager);
    }

}
