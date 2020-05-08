package collision;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.BubbleFactory;
import javafx.geometry.Point2D;

public class testprova {
	
	private BubbleFactory factory = new BubbleFactory(); 
	private Bubble bubble = factory.createGridBubble(new Point2D(0,  0), BubbleColor.getRandomColor()); 
	
	@Test
	public void test() {
		assertTrue(bubble.getPosition() == new Point2D(0, 0));
		assertTrue(Bubble.getRadius() == 1);		
	}
}
