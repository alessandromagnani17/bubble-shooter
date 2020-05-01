package bubbleshooter.model.highscore;

import bubbleshooter.model.gamemodality.LevelTypes;
import javafx.beans.property.SimpleStringProperty;

public class HighscoreStructure extends Score {

    protected final SimpleStringProperty name;

    /**
     * Construct a new HighscoreStructure
     * @param name 
     *              the player username
     * @param score 
     *              the score made by the player
     */
    public HighscoreStructure(final String name, final Integer score, final LevelTypes gameMode) {
        super(score, gameMode);
        this.name = new SimpleStringProperty(name) ;
    }

    public String getName() {
        return name.get();
    }

    public String toString() {
        return "Player:" + this.getName() + " Score:" + super.getScore();
    }

}
