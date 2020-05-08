package bubbleshooter.model.bubble;

import java.util.Optional;
import bubbleshooter.model.component.Component;
import bubbleshooter.model.component.ComponentType;
import javafx.geometry.Point2D;

public interface Bubble {
	static final double RADIUS = 18;
	static final double WIDTH = RADIUS * 2;
	

    void setPosition(Point2D position);

    void setDirection(Point2D direction);

    void setType(BubbleType type); 

    void destroy();

    void update(double elapsed);

    void setColor(BubbleColor color); 

    void addComponent(Component component);

    double getRadius(); 

    double getWidth(); 
    
    double getHeigth(); 

    boolean isDestroyed();

    BubbleType getType(); 

    BubbleColor getColor(); 

    Optional<Component> getComponent(ComponentType type);

    Point2D getPosition(); 

    Optional<Point2D> getDirection();
}
