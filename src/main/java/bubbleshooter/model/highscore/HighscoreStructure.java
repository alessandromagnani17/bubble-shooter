package bubbleshooter.model.highscore;

import bubbleshooter.model.game.level.LevelType;

/**
 * Class used to store a {@link HighscoreStructure} with score, current game mode and the name.
 */
public class HighscoreStructure extends Score {

    private final String name;

    /**
     * Constructor for a new HighscoreStructure.
     * 
     * @param name      the player name.
     * @param score     the score made by the player.
     * @param gameMode  the current game modality.
     */
    public HighscoreStructure(final String name, final int score, final LevelType gameMode) {
        super(score, gameMode);
        this.name = name;
    }

    /**
     * Getter for the name.
     * 
     * @return the String value of the player name.
     */
    public final String getName() {
        return this.name;
    }

}
