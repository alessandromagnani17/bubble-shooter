package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.model.gameobject.BubbleGridManager;

public class GameObjectVisitor implements Visitor{

    private GameObject visitor;
    
    public GameObjectVisitor(final GameObject visitor) {
        this.visitor = visitor;
    }

    @Override
    public final void visit(final GameObject gameObject, final GameObjectsTypes type, final BubbleGridManager gridManager) {
        CollisionHandler handler = new GridCollisionHandler(this.visitor, gameObject, gridManager);
        handler.handle();
    }

}
