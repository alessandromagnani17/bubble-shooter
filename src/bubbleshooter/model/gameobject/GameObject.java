package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Geometry;

import javafx.geometry.Point2D;

public interface GameObject {

    double getHeight();

    double getWidth();
    
    void setHeigth(double heigth);
    
    void setWidth(double width);

    Point2D getPosition();

    void setPosition(Point2D position);

    boolean isOver();

    void update(double elapsed);

    GameObjectsTypes getType();

    void setType(GameObjectsTypes type);
    
    Geometry setCollisionBox();
    
    Geometry getCollisionBox();

}
