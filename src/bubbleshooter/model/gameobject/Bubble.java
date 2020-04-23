package bubbleshooter.model.gameobject;

import java.util.List;
import java.util.Optional;

import bubbleshooter.model.component.Component;
import bubbleshooter.model.component.ComponentType;
import javafx.geometry.Point2D;

public interface Bubble {
	
	Point2D getPosition(); 
	
	Point2D getDirection();
	
	List<Component> getComponents();

	void addComponent(Component component);

	void setPosition(Point2D position);
	
	void setDirection(Point2D direction);
	
    boolean isDestroyed();

    void destroy();

    void update(double elapsed);

    double getRadius(); 

    void setRadius(double radius);

    BubbleType getType(); 

    void setType(BubbleType type); 

    BubbleColor getColor(); 

    void setColor(BubbleColor color); 
}
