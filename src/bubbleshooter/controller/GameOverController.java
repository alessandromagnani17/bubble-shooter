package bubbleshooter.controller;

import java.util.List;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleType;

public class GameOverController {

    private List<Bubble> bubbles;
    private double yCannon;

    public GameOverController(final List<Bubble> bubbles, final double yCannon) {
        this.bubbles = bubbles;
        this.yCannon = yCannon;
    }

    public final boolean isGameOver() { 
        for (Bubble bubble : bubbles) {
            if (bubble.getType().equals(BubbleType.GRID_BUBBLE)) {
                if (bubble.getPosition().getY() > yCannon) {
                    System.out.println("GAME OVEEEERRR");
                    return true;
                }
            }
        }
        return false;
    }
}
