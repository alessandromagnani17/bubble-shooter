package bubbleshooter.model.highscore;

import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameType;

/**
 * 
 * Class called by {@link ControllerImpl} used to get information about the score.
 * The informations are taken by calling the {@link GameInfoManager}.
 *
 */
public class ScoreManager {

    private GameInfoManager scoresInfo;
    private HighscoreStore highscoreStore;

    /**
     * Constructor for a new ScoreManager.
     * 
     * @param scoresInfo the GameInfoManager.
     */
    public ScoreManager(final GameInfoManager scoresInfo) {
        this.scoresInfo = scoresInfo;
        this.highscoreStore = new HighscoreStoreImpl();
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
    
    /**
     * @return the highscoreStore.
     */
    public final HighscoreStore getHighscoreStore() {
    	return this.highscoreStore;
    }

    /**
     * Method for save the score in the highscores list.
     * 
     * @param username          the name of the player.
     * @param currentLevelTypes the current game modality.
     */
    public final void saveScore(final String username, final GameType currentLevelTypes) {
        this.highscoreStore.addScore(new HighscoreStructure(username.replace(" ", "_"), this.getScore(), currentLevelTypes));
    }

}
