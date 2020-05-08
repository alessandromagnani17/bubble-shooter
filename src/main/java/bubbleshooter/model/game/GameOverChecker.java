package bubbleshooter.model.game;

import bubbleshooter.model.bubble.BubbleType;
import bubbleshooter.model.game.mode.GameMode;

public class GameOverChecker {

    private static final double LIMITS = 574;
    private final GameMode gameMode;

    public GameOverChecker(final GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public final boolean checkGameOver() {
        return this.gameMode.getCurrentBubbles().stream().filter(b -> b.getType()
                .equals(BubbleType.GRID_BUBBLE)).anyMatch(b -> b.getPosition().getY() > LIMITS); 
    }
}
