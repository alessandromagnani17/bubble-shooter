package bubbleshooter.model.game;

import java.util.List;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.BubbleType;

public class GameSwitcher {

    private final List<Bubble> bubbles;

    public GameSwitcher(final List<Bubble> bubbles) {
        this.bubbles = bubbles;
    }

    public final void switchBall() {
        final BubbleColor bubbleColor = bubbles.stream()
                                               .filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE))
                                               .findFirst().get().getColor();
        this.bubbles.stream()
                    .filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE))
                    .findFirst().get()
                    .setColor(bubbles.stream()
                    .filter(a -> a.getType().equals(BubbleType.SWITCH_BUBBLE))
                    .findFirst().get().getColor());
        this.bubbles.stream()
                    .filter(a -> a.getType().equals(BubbleType.SWITCH_BUBBLE))
                    .findFirst().get()
                    .setColor(bubbleColor);
    }
}
