package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;

public interface Bubble {
	
	Point2D getPosition(); 
	
	void setPosition(Point2D position);
	
    boolean isDestroyed();

    void destroy();
    
    double getRadius(); 
    
    void setRadius(double radius);
    
    BubbleType getType(); 
    
    void setType(BubbleType type); 
    
    BubbleColor getColor(); 
    
    void setColor(BubbleColor color); 
    
    
    
    
    
    

}
