package bubbleshooter.model.highscore;


import bubbleshooter.model.gamemodality.LevelTypes;
import javafx.beans.property.SimpleIntegerProperty;

public class Score {

    protected final SimpleIntegerProperty score;
    protected final LevelTypes gameMode;

    /**
     * Construct a new score specifying the modality.
     * @param score
     *              Score of this game
     * @param gameMode
     *              The modality
     */
    public Score(final Integer score, final LevelTypes gameMode) {
        this.score = new SimpleIntegerProperty(score);
        this.gameMode = gameMode;
    }
    /**
     * Getter for score
     * @return the Integer value of score
     */
    public Integer getScore() {
        return score.get();
    }
    
	public LevelTypes getGameMode() {
		return gameMode;
	}

}
