package bubbleshooter.model.highscore;

import bubbleshooter.model.game.level.LevelType;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * Class which represent a basic score with score and his game modality.
 *
 */
public class Score {

    private final SimpleIntegerProperty score;
    private final LevelType level;

    /**
     * Constructor for a new score specifying the modality.
     * 
     * @param score       Score of this game.
     * @param gameMode    The modality of this game.
     */
    public Score(final Integer score, final LevelType gameMode) {
        this.score = new SimpleIntegerProperty(score);
        this.level = gameMode;
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
    public final LevelType getGameMode() {
        return level;
    }

}
