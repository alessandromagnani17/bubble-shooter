package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.GameObjectsTypes;

public interface Visitor {

    void visit(GameObject gameObject, GameObjectsTypes type, GameObjectManager gameObjectManager);

}
