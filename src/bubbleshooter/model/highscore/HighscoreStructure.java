package bubbleshooter.model.highscore;

public class HighscoreStructure extends Score {

    private static final long serialVersionUID = -4128959199732910429L;
    private final String username;

    /**
     * Construct a new HighscoreStructure
     * @param name 
     *              the player username
     * @param score 
     *              the score made by the player
     */
    public HighscoreStructure(final String name, final long score) {
        super(score);
        this.username = name;
    }

    /**
     * @return the current username of the player
     */
    public String getUsername() {
        return this.username;
    }

}
