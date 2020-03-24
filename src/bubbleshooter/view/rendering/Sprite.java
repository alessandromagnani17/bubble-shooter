package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;

import org.locationtech.jts.geom.Coordinate;

import bubbleshooter.view.images.ImagePath;

public interface Sprite {
    
    void setPosition(Coordinate coordinate); 
    
    Coordinate getPosition(); 
    
    void setSource(ImagePath source) throws FileNotFoundException;
    
    double getImageSourceHeight();
    
    double getImageSourceWidth();
    
    void setGameObjectWidth(double width);
    
    double getGameObjectWidth();
    
    void setGameObjectHeight(double height);
    
    double getGameObjectHeight();
    
    void setGameObjectPosition(Coordinate position);
    
    Coordinate getGameObjectPosition();
    
    void render(); 
    
    
    
    
    
    
}
