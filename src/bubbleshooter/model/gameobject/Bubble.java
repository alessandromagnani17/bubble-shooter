package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface Bubble {
	
	Point2D getPosition(); 
	
	Point2D getDirection();
	
	Shape getShape();

	void setPosition(Point2D position);
	
	void setDirection(Point2D direction);
	
    boolean isDestroyed();

    void destroy();

    void update(double elapsed);

    double getRadius(); 
    
    double getWidth();

    BubbleType getType(); 

    void setType(BubbleType type); 

    BubbleColor getColor(); 

    void setColor(BubbleColor color); 
}
