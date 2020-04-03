package bubbleshooter.model.gameobject.bubble;

import bubbleshooter.model.gameobject.AbstractGameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class BasicBubble extends AbstractGameObject{

    public BasicBubble(final Point2D position) {
        super.setType(GameObjectsTypes.BASICBUBBLE);
        super.setPosition(position);
        super.setHeigth(GameCostants.RADIUS.getValue() * 2);
        super.setWidth(super.getHeight()); 
    }

    @Override
    public final void setPosition(final Point2D position) {
        super.setPosition(position);
    }

}
