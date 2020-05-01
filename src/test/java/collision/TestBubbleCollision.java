package collision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gamemodality.BasicMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.GridBubble;
import bubbleshooter.model.gameobject.ShootingBubble;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class TestBubbleCollision {

	private BasicMode level = new BasicMode();
    private CollisionController collisionController = new CollisionController(level);

	
	public void testCollision() {
	}
	

	
}
