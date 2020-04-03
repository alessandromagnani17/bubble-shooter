package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.bubble.BubbleGridManager;

public interface CollisionAcceptor {

    void accept(Visitor visitor, BubbleGridManager gridManager);

}
