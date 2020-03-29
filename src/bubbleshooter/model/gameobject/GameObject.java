package bubbleshooter.model.gameobject;


import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface GameObject {

    double getHeight();

    double getWidth();
    
    void setHeigth(double heigth);
    
    void setWidth(double width);

    Point2D getPosition();
    
    Point2D getDirection();

    void setPosition(Point2D position);

    void setDirection(Point2D direction);
    
    boolean isOver();

    void update(double elapsed);

    GameObjectsTypes getType();

    void setType(GameObjectsTypes type);

    Shape getShape();

}
