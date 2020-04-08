package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;


public class ShootingBubble extends BasicBubble  {

    
    private GameObjectsTypes type; 
    
    public ShootingBubble(Point2D position, Property property) {
        super(position, property);
        super.setType(GameObjectsTypes.MOVINGBUBBLE); 
    }
    
    @Override
    public GameObjectsTypes getType() {
        return this.type;
    }

    @Override
    public void setType(final GameObjectsTypes type) {
        this.type = type;
    }

    /*private Vector2D direction;
    
    public ShootingBubble(final Coordinate position, final Color color) {
        super(position, color);
    }

    public final void setDirection(final Vector2D direction) {
        this.direction = direction;
    }
    
    public final Vector2D getDirection() {
        return this.direction;
    }*/
}
