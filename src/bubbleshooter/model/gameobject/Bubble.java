package bubbleshooter.model.gameobject;

import java.util.List;
import bubbleshooter.model.component.Component;
import javafx.geometry.Point2D;

public interface Bubble {
	
	Point2D getPosition(); 
	
	List<Component> getComponents();
	
	void addComponent(Component component);
	
	void setPosition(Point2D position);
	
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
