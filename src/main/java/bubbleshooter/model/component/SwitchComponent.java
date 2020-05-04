package bubbleshooter.model.component;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleColor;

public class SwitchComponent extends AbstractComponent {

    private BubbleColor bubbleColor;

    public SwitchComponent(final Bubble container) {
        super(container);
        this.setBubbleColor(container.getColor());
        this.setType(ComponentType.SWITCHCOMPONENT);
    }

    public final BubbleColor getBubbleColor() {
        return bubbleColor;
    }

    public final void setBubbleColor(final BubbleColor bubbleColor) {
        this.bubbleColor = bubbleColor;
    }
}
