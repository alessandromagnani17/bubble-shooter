package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.model.gameobject.bubble.BubbleGridManager;

public interface Visitor {

    void visit(GameObject gameObject, GameObjectsTypes type, BubbleGridManager gridManager);

}
