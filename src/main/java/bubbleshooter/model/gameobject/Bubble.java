package bubbleshooter.model.gameobject;

import java.util.Optional;
import bubbleshooter.model.component.Component;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;

public interface Bubble {

    void setPosition(Point2D position);

    void setDirection(Point2D direction);

    void setType(BubbleType type); 

    void destroy();

    void update(double elapsed);

    void setColor(BubbleColor color); 

    void addComponent(Component component);

    static double getRadius() {
        return Bubble.getWidth() / 2;
    }

    static double getWidth() {
        return Settings.getGuiWidth() / (Settings.getNumBubbles() + 0.5);
    }

    boolean isDestroyed();

    BubbleType getType(); 

    BubbleColor getColor(); 

    Optional<Component> getComponent(ComponentType type);

    Point2D getPosition(); 

    Optional<Point2D> getDirection();
}
