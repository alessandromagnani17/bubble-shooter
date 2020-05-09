package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import bubbleshooter.view.images.ImagePath;

public interface Sprite {

    void setPosition(Point2D coordinate); 

    Point2D getPosition(); 

    void setSource(ImagePath source) throws FileNotFoundException;

    void draw() throws FileNotFoundException; 

    double getWidth(); 

    double getHeigth(); 

    void setHeigth(double heigth); 

    void setWidth(double width); 

}
