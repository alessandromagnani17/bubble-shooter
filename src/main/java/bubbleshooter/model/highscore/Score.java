package bubbleshooter.model.highscore;

import bubbleshooter.model.game.GameType;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * Class which represent a basic score with score and his game modality.
 *
 */
public class Score {

    private final SimpleIntegerProperty score;
    private final GameType gameMode;

    /**
     * Constructor for a new score specifying the modality.
     * 
     * @param score       Score of this game.
     * @param gameMode    The modality of this game.
     */
    public Score(final Integer score, final GameType gameMode) {
        this.score = new SimpleIntegerProperty(score);
        this.gameMode = gameMode;
    }

    /**
     * Getter for score.
     * 
     * @return the Integer value of score.
     */
    public Integer getScore() {
        return score.get();
    }

    /**
     * Getter for game modality.
     * 
     * @return the game modality of this score.
     */
    public final GameType getGameMode() {
        return gameMode;
    }

}
