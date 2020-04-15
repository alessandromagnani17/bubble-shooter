package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.model.gameobject.Property;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasDrawer {
    
    private final Canvas canvas; 

    public CanvasDrawer(Canvas canvas) {
        this.canvas = canvas; 
    }
    

    private Sprite generateSprite(final GameObject gameObject){
        try {
            return new SpriteImpl(this.canvas.getGraphicsContext2D(), gameObject, gameObject.getPosition(), this.getImagePath(gameObject));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private ImagePath getImagePath(GameObject gameObject) {
        if (gameObject.getType() == GameObjectsTypes.BASICBUBBLE || gameObject.getType() == GameObjectsTypes.SHOOTINGBUBBLE) {
           
            if(gameObject.getColor() == Property.BLUE) {
                return ImagePath.BLUE_BUBBLE; 
            }
            else if(gameObject.getColor() == Property.GREEN) {
                return ImagePath.GREEN_BUBBLE; 
            }
            else if(gameObject.getColor() == Property.LIGHTBLUE) {
                return ImagePath.LIGHT_BLUE_BUBBLE; 
            }
            else if(gameObject.getColor() == Property.YELLOW) {
                return ImagePath.YELLOW_BUBBLE; 
            }
            else if(gameObject.getColor() == Property.PURPLE) {
                return ImagePath.PURPLE_BUBBLE; 
            }
            else if(gameObject.getColor() == Property.RED) {
                return ImagePath.RED_BUBBLE; 
            }
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
