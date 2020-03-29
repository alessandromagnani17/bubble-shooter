package bubbleshooter.model.highscore;

import java.io.Serializable;

public class Score implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -334117974678079971L;
    protected final long score;
    protected long start; // For survival mode
    protected long end;   // For survival mode
    
    /**
     * Construct a SurvivalMode Game.
     * @param score
     *              Score of this game
     * @param start
     *              Current timeMillis when the game started
     * @param end
     *              Current timeMillis when the game ended
     */
    public Score(final long score, final long start, final long end) {
        this.score = score;
        this.start = start;
        this.end = end;
    }
    
    /**
     * Construct a BasicMode Game.
     * @param score
     *              Score of this game
     */
    public Score(final long score) { 
        this.score = score;
    }

}
