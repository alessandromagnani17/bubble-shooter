package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;

public final class BubbleFactory {
	
	public static Bubble createGridBubble(Point2D position) {
		return new GridBubble(position); 
	}
	public static Bubble createShootingBubble(Point2D position) {
		return new ShootingBubble(position); 
	}
}
