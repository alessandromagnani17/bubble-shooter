package bubbleshooter.view.rendering;

import java.util.List;


import bubbleshooter.model.gameobject.GameObject;
import javafx.scene.canvas.Canvas;

public class CanvasDrawer {
    
    private final Canvas canvas;

    public CanvasDrawer(Canvas canvas) {
        this.canvas = canvas;
    } 
    
    public void draw(final List<GameObject> gameObjects) {
        gameObjects.forEach(o -> {
            this.generateSprite(o).render();      
        });
    }
    
    private Sprite generateSprite(final GameObject gameObject) {
        return new SpriteImpl(this.canvas.getGraphicsContext2D(), gameObject);
    }

    public Canvas getCanvas() {
        return canvas;
    }
    
    
}
