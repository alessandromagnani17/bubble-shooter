package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;

import org.locationtech.jts.geom.Coordinate;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpriteImpl implements Sprite{

    private static final double DEFAULT = 100.0;
    private final GraphicsContext gc;
    private final GameObject gameObject;
    private Coordinate gameObjectPosition;
    private double gameObjectWidth;
    private double gameObjectHeight;
    private Coordinate position;
    private Image image;
  
    public SpriteImpl(final GraphicsContext gc, final GameObject gameObject) {
        super();
        this.gc = gc;
        this.gameObject = gameObject;
        this.position = new Coordinate(0, 0); 
        this.gameObjectHeight = DEFAULT; 
        this.gameObjectWidth = DEFAULT; 
        this.gameObjectPosition = null; 
    }
    
    @Override
    public void render() {
        this.gc.drawImage(this.image, this.getPosition().x, this.getGameObjectPosition().y, this.getGameObjectWidth(), this.getGameObjectHeight() );
        
    }

    @Override
    public void setPosition(Coordinate coordinate) {
        this.position = coordinate; 
        
    }

    @Override
    public Coordinate getPosition() {
        return this.position; 
    }

    @Override
    public void setSource(ImagePath source) throws FileNotFoundException {
        this.image = ImageLoader.getLoader().getImage(source); 
    }
    
    public Image getSource(){
        return this.image; 
        
    }
    @Override
    public double getImageSourceHeight() {
        return this.image.getHeight(); 
    }

    @Override
    public double getImageSourceWidth() {
        return this.image.getWidth(); 
    }

    @Override
    public void setGameObjectWidth(double width) {
       this.gameObjectWidth = width; 
        
    }

    @Override
    public double getGameObjectWidth() {
        return this.gameObjectWidth; 
    }

    @Override
    public void setGameObjectHeight(double height) {
        this.gameObjectHeight = height; 
    }

    @Override
    public double getGameObjectHeight() {
        return this.gameObjectHeight; 
    }

    @Override
    public void setGameObjectPosition(Coordinate position) {
        this.gameObjectPosition = position; 
        
    }

    @Override
    public Coordinate getGameObjectPosition() {
        return this.gameObjectPosition; 
    }


}
