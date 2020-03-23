package bubbleshooter.model.gameobject;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;

public class CreateGameObject {
    
    public BasicBubble createBubble(Coordinate position, double width, double heigth) {
        return new BasicBubble(position, width, heigth); 
    }
    
    public List<BasicBubble> createBubbleGrid(){
        
    }

}
