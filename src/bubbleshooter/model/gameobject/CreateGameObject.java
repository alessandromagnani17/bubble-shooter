package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;

public class CreateGameObject {
    
    private static final double BUBBLE_WIDTH = 30; 
    private static final double BUBBLE_HEIGTH = 30; 
    private static final double ROWS_NUMBER = 8; 
    private static final double ROW_BUBBLES = 15; 
    private static final double OFFSET = 15; 
    
    
    
    
    
    public BasicBubble createBasicBubble(Coordinate position) {
        return new BasicBubble(position, BUBBLE_WIDTH, BUBBLE_HEIGTH); 
        
    }
    
    public List<BasicBubble> createBubbleGrid(){
        List<BasicBubble> grid = new LinkedList<>(); 
        for(int x = 0; x <=  ROW_BUBBLES*BUBBLE_WIDTH; x += BUBBLE_WIDTH) {
            for (int y = 0; y <= ROWS_NUMBER*ROW_BUBBLES; y += BUBBLE_WIDTH) {
                grid.add(this.createBasicBubble(new Coordinate(x, y))); 
            }
        }
        return grid; 
    }

}
