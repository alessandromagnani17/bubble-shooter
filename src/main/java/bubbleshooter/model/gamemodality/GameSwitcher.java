package bubbleshooter.model.gamemodality;

import bubbleshooter.model.gameobject.BubbleColor;
import bubbleshooter.model.gameobject.BubbleType;

public class GameSwitcher {

    private AbstractGameMode gameMode;

    public GameSwitcher(final AbstractGameMode gameMode) {
        super();
        this.gameMode = gameMode;
    }

    public final void switchBall() {
        BubbleColor bubbleColor = gameMode.getCurrentBubbles().stream()
                .filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getColor();

        gameMode.getCurrentBubbles().stream()
        .filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get()
        .setColor(gameMode.getCurrentBubbles().stream()
                .filter(a -> a.getType().equals(BubbleType.SWITCH_BUBBLE)).findFirst().get().getColor());

        gameMode.getCurrentBubbles().stream()
        .filter(a -> a.getType().equals(BubbleType.SWITCH_BUBBLE)).findFirst().get()
        .setColor(bubbleColor);
    }
}
