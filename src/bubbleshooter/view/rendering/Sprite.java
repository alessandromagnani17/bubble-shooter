package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import bubbleshooter.view.images.ImagePath;

public interface Sprite {
    
    void setPosition(Point2D coordinate); 
    
    Point2D getPosition(); 
    
    void setSource(ImagePath source) throws FileNotFoundException;
    
    double getImageSourceHeight();
    
    double getImageSourceWidth();
    
    void setGameObjectWidth(double width);
    
    double getGameObjectWidth();
    
    void setGameObjectHeight(double height);
    
    double getGameObjectHeight();
    
    void setGameObjectPosition(Point2D position);
    
    Point2D getGameObjectPosition();
    
    void draw() throws FileNotFoundException; 
    
    
    
    
    
    
}
