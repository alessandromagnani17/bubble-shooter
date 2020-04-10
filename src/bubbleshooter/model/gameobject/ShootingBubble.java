package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;


public class ShootingBubble extends BasicBubble  {
    
    public ShootingBubble(Point2D position) {
        super(position);
        super.setType(GameObjectsTypes.MOVINGBUBBLE); 
    }
}
