package bubbleshooter.model.game;

import bubbleshooter.model.bubble.BubbleType;
import bubbleshooter.model.game.mode.Level;

/**
 * Class that checks if the {@link Level} is in GameOver.
 * Used by {@link AbstractLevel}.
 */
public class GameOverChecker {

    private static final double LIMITS = 574;
    private final Level gameMode;

    /**
     * Constructor for a new GameOverChecker.
     * 
     * @param gameMode , the rapresentation of the game.
     */
    public GameOverChecker(final Level gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * Method that checks if the {@link Level} is in GameOver.
     * @return the position of the {@link Bubble}s is greater than the maximum limit
     */
    public final boolean checkGameOver() {
        return this.gameMode.getCurrentBubbles().stream().filter(b -> b.getType()
                .equals(BubbleType.GRID_BUBBLE)).anyMatch(b -> b.getPosition().getY() > LIMITS); 
    }

    /**
     * Method that checks if the {@link Level} is in GameOver.
     * @param bubblePosition , the position of {@link Bubble}
     * @return the position of the {@link Bubble}s is greater than the maximum limit
     */
    public final boolean isGameOver(final double bubblePosition) {
        return bubblePosition > LIMITS;
    }
}
