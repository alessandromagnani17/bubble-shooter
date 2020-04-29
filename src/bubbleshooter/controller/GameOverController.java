package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleType;

public class GameOverController {

    private List<Bubble> bubbles;
    private double limits;

    public GameOverController(final List<Bubble> bubbles, final double limits) {
        this.bubbles = bubbles;
        this.limits = limits;
    }

    public final boolean isGameOver() { 
        for (Bubble bubble : bubbles) {
            if (bubble.getType().equals(BubbleType.GRID_BUBBLE)) {
                if (bubble.getPosition().getY() > limits) {
                    System.out.println("GAME OVER");
                    return true;
                }
            }
        }
        return false;
    }
}
