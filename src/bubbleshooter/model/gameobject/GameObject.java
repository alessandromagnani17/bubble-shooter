package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;

import org.locationtech.jts.geom.Geometry;

public interface GameObject {

    double getHeight();

    double getWidth();
    
    void setHeigth(double heigth);
    
    void setWidth(double width);

    Coordinate getPosition();

    void setPosition(Coordinate position);

    boolean isOver();

    void update(double elapsed);

    GameObjectsTypes getType();

    void setType(GameObjectsTypes type);
    
    Geometry setCollisionBox();
    
    Geometry getCollisionBox();

}
