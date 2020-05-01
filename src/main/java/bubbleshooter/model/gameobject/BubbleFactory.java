package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;

public final class BubbleFactory {

	private BubbleFactory() {
	}
	
	public static Bubble createGridBubble(final Point2D position) {
		return new GridBubble(position); 
	}
	public static Bubble createShootingBubble(final Point2D position) {
		return new ShootingBubble(position); 
	}
	public static Bubble createSwitchBubble(final Point2D position) {
		return new SwitchBubble(position); 
	}
}
