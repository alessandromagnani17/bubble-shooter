package bubbleshooter.model.highscore;

import bubbleshooter.model.game.level.LevelType;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * Class which represent a basic score with score and his game modality.
 *
 */
public class Score {


    private final double theScore;
    private final LevelType level;

    /**
     * Constructor for a new score specifying the modality.
     * 
     * @param score       Score of this game.
     * @param level    The modality of this game.
     */
    public Score(final double score, final LevelType level) {
        this.theScore = score;
        this.level = level;
    }

    /**
     * Getter for score.
     * 
     * @return the Integer value of score.
     */
    public double getScore() {
        return this.theScore;
    }

    /**
     * Getter for game modality.
     * 
     * @return the game modality of this score.
     */
    public final LevelType getGameMode() {
        return this.level;
    }

}
