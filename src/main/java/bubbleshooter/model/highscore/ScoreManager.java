package bubbleshooter.model.highscore;

import bubbleshooter.model.game.GameInfoManager;

/**
 * 
 * Class called by {@link ControllerImpl} used to get information about the score.
 * The informations are taken by calling the {@link GameInfoManager}.
 *
 */
public class ScoreManager {

    private final GameInfoManager scoresInfo;

    /**
     * Constructor for a new ScoreManager.
     * 
     * @param scoresInfo the GameInfoManager.
     */
    public ScoreManager(final GameInfoManager scoresInfo) {
        this.scoresInfo = scoresInfo;
    }

    /**
     * @return the score of the game.
     */
    public final int getScore() {
        return this.scoresInfo.getScore();
    }

    /**
     * @return the destroyed balls of the game.
     */
    public final int getDestroyedBubbles() {
        return this.scoresInfo.getDestroyedBubbles();
    }

    /**
     * @return the game time.
     */
    public final double getGameTime() {
        return this.scoresInfo.getGameTime();
    }

}
