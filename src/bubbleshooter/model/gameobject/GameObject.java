package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.math.Vector2D;

public interface GameObject {

    double getHeight();

    double getWidth();
    
    void setHeigth(double heigth);
    
    void setWidth(double width);

    Vector2D getPosition();

    void setPosition(Vector2D position);

    boolean isOver();

    void update(double elapsed);

    GameObjectsTypes getType();

    void setType(GameObjectsTypes type);
    
    Geometry setCollisionBox();
    
    Geometry getCollisionBox();

}
