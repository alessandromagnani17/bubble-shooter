package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.model.gameobject.bubble.BubbleGridManager;

public class GameObjectVisitor implements Visitor{

    private final GameObject visitor;
    
    public GameObjectVisitor(final GameObject visitor) {
        this.visitor = visitor;
    }

    @Override
    public final void visit(final GameObject gameObject, final GameObjectsTypes type, final BubbleGridManager gridManager) {
        final CollisionHandler handler = new GridCollisionHandler(this.visitor, gameObject, gridManager);
        handler.handle();
    }

}
