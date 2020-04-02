package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;

import org.locationtech.jts.geom.Coordinate;

import javafx.geometry.Point2D;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpriteImpl implements Sprite{

    private static final double DEFAULT = 60;
    private final GraphicsContext gc;
    private final GameObject gameObject;
    private Point2D gameObjectPosition;
    private double gameObjectWidth;
    private double gameObjectHeight;
    private Point2D position;
    private Image image;
  
    public SpriteImpl(final GraphicsContext gc, final GameObject gameObject, Point2D position, ImagePath imageSource) throws FileNotFoundException {
     
        this.gc = gc;
        this.gameObject = gameObject;
        this.position = position;
        this.gameObjectHeight = DEFAULT; 
        this.gameObjectWidth = DEFAULT; 
        this.setSource(imageSource);
     
    }
    
    @Override
    public void draw() throws FileNotFoundException {
       
        this.gc.drawImage(this.image, this.getTopLeftFromCenter(this.getPosition()).getX(), this.getTopLeftFromCenter(this.getPosition()).getY(), this.getGameObjectWidth(), this.getGameObjectHeight() );
    }
    
    private Point2D getTopLeftFromCenter(Point2D center) {
        return new Point2D(this.position.getX()-(this.gameObjectWidth/2), this.position.getY()-(this.getGameObjectHeight()/2)); 
    }

    @Override
    public void setPosition(Point2D coordinate) {
        this.position = coordinate; 
        
    }

    @Override
    public Point2D getPosition() {
        return this.position; 
    }

    @Override
    public void setSource(ImagePath source) throws FileNotFoundException {
        System.out.println("image path = " + source.getPath());
        this.image = ImageLoader.getLoader().getImage(source); 
        System.out.println("image = " + ImageLoader.getLoader().getImage(source));
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
    public void setGameObjectPosition(Point2D position) {
        this.gameObjectPosition = position; 
        
    }

    @Override
    public Point2D getGameObjectPosition() {
        return this.gameObjectPosition; 
    }


}
