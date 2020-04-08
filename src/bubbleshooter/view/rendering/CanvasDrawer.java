package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Coordinate;
import javafx.geometry.Point2D;
import com.sun.source.tree.SwitchTree;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.Canvas;

public class CanvasDrawer {

    private final Canvas canvas;
    private List<Sprite> spriteList; 

    public CanvasDrawer(Canvas canvas) {
        this.canvas = canvas;
        this.spriteList = new LinkedList<>(); 
    }
    
    
    public void createSpriteList(List<GameObject> gameObjects) {
        gameObjects.forEach(o -> {
            try {
                this.spriteList.add(this.generateSprite(o, o.getPosition(), o.getType()));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
    
    public void draw(final List<GameObject> gameObjects) throws FileNotFoundException {
       this.createSpriteList(gameObjects);
        this.spriteList.forEach(s -> {
            this.canvas.getGraphicsContext2D().save();
            try {
                s.draw();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           this.canvas.getGraphicsContext2D().restore();
        });        
    }

    private Sprite generateSprite(final GameObject gameObject, Point2D position, GameObjectsTypes type)
            throws FileNotFoundException {

        ImagePath imageSource = null;

        switch (type) {
        case CANNON:
            imageSource = ImagePath.CANNON;
            break;
        case BASICBUBBLE:
            imageSource = ImagePath.BUBBLE;
            break;
        case MOVINGBUBBLE:
            imageSource = ImagePath.BUBBLE;
            break;
        default:
        }
        return new SpriteImpl(this.canvas.getGraphicsContext2D(), gameObject, position, imageSource);
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
