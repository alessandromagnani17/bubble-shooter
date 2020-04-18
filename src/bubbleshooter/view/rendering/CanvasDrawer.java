package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.Property;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasDrawer {
    
    private final Canvas canvas; 
    private static final Map<Property, ImagePath> COLOR_MAP;  
    		
    static {
    	COLOR_MAP = Map.of(
    			Property.BLUE, ImagePath.BLUE_BUBBLE,
    			Property.GREEN, ImagePath.GREEN_BUBBLE, 
    			Property.PURPLE, ImagePath.PURPLE_BUBBLE, 
    			Property.RED, ImagePath.RED_BUBBLE, 
    			Property.LIGHTBLUE, ImagePath.LIGHT_BLUE_BUBBLE, 
    			Property.YELLOW, ImagePath.YELLOW_BUBBLE); 	
    }
    

    public CanvasDrawer(Canvas canvas) {
        this.canvas = canvas; 
    }
    

    private Sprite generateSprite(final GameObject gameObject){
        try {
            return new SpriteImpl(this.canvas.getGraphicsContext2D(), gameObject, gameObject.getPosition(), COLOR_MAP.get(gameObject.getColor()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Canvas getCanvas() {
        return canvas;
    }
    
    public void draw(final List<GameObject> gameObjects) {
        final GraphicsContext gc = this.canvas.getGraphicsContext2D(); 
        this.createSpriteList(gameObjects).forEach(s -> {
            gc.save();
            try {
                s.draw();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            gc.restore();
        });; 
    }

    private List<Sprite> createSpriteList(List<GameObject> gameObjects) {
       return gameObjects.stream().map(this::generateSprite).collect(Collectors.toList()); 
        
    }
    
    
    
    
    
    

}
