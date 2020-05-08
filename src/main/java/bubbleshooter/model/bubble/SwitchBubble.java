package bubbleshooter.model.bubble;

import javafx.geometry.Point2D;

public class SwitchBubble extends AbstractBubble {

    public SwitchBubble(final Point2D position, final BubbleColor color) {
        super(BubbleType.SWITCH_BUBBLE, position, color);
    }

	@Override
	protected void setComponents() {		
	}
}
