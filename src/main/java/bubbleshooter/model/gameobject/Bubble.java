package bubbleshooter.model.gameobject;

import java.util.Optional;
import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.Component;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.ShootingComponent;
import javafx.geometry.Point2D;

public interface Bubble {
	

	void setPosition(Point2D position);
	
    void setDirection(Point2D direction);
	
    void setType(BubbleType type); 

    void destroy();

    void update(double elapsed);

    void setColor(BubbleColor color); 

    void addComponent(Component component);

    double getRadius(); 

    double getWidth();

    boolean isDestroyed();

    BubbleType getType(); 

    BubbleColor getColor(); 

    Optional<Component> getComponent(ComponentType type);

	Point2D getPosition(); 
	
	Optional<Point2D> getDirection();
}
