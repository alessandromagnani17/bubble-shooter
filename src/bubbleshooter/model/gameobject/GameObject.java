package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;

import javafx.geometry.Point2D;

public interface GameObject {
 
    
    Property getColor(); 
    
    double getHeight();

    double getWidth();

    void setHeigth(double heigth);

    void setWidth(double width);

    Point2D getPosition();

    Point2D getDirection();

    void setDirection(Point2D direction);

    void setPosition(Point2D position);
    
    GameObjectsTypes getType();

    void setType(GameObjectsTypes type);
    
    void update(double elapsed); 
    
    void setProperty(Property property);

    boolean isDestroyed();

    void destroy();
}
