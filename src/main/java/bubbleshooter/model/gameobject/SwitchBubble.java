package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.SwitchComponent;
import javafx.geometry.Point2D;

public class SwitchBubble extends AbstractBubble {

	public SwitchBubble(Point2D position) {
		super(BubbleType.SWITCH_BUBBLE, position);
	}

	@Override
	protected final void setComponents() {
		this.addComponent(new SwitchComponent(this));
	}
	
	@Override
	public final void update(final double elapsed) {
        this.getComponent(ComponentType.SWITCHCOMPONENT).get().update(elapsed);
	}

}
