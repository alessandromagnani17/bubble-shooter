package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.BubbleGridManager;

public interface Acceptor {

    void accept(Visitor visitor, BubbleGridManager gridManager);

}
