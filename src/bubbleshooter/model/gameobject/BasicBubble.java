package bubbleshooter.model.gameobject;
import javafx.geometry.Point2D;

public class BasicBubble extends AbstractGameObject {
    
    public BasicBubble(Point2D position) {
        super(position); 
        super.setType(GameObjectsTypes.BASICBUBBLE);
    }

    @Override
    public GameObjectsTypes getType() {
        return super.getType();
    }

}
