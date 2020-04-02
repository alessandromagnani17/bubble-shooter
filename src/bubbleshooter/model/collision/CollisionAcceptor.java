package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObjectManager;

public interface CollisionAcceptor {

    void accept(Visitor visitor, GameObjectManager gameObjectManager);

}
