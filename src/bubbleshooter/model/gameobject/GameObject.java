package bubbleshooter.model.gameobject;

import bubbleshooter.model.gameobject.bubble.Property;
import javafx.geometry.Point2D;

public interface GameObject {

    double getHeight();

    double getWidth();

    void setHeigth(double heigth);

    void setWidth(double width);

    Point2D getPosition();

    Point2D getDirection();

    void setPosition(Point2D position);

    void setDirection(Point2D direction);

    void update(double elapsed);

    GameObjectsTypes getType();

    void setType(GameObjectsTypes type);

    void setProperty(Property property);

    Property getProperty();

    boolean isDestroyed();

    void destroy();
}
