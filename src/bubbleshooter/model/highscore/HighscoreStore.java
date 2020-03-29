package bubbleshooter.model.highscore;

import java.io.File;
import java.io.Serializable;
import bubbleshooter.model.gamemodality.GameModality;

public interface HighscoreStore extends Serializable{
    
    /**
     * @return the file where the highscores are saved
     */
    File getFile();
    
    /**
     * Add a highscore for a game modality
     * @param gameMode 
     *              current game modality
     * @param score 
     *              current score to save
     */
    void addScore(GameModality gameMode, Score score);
    
    /**
     * Clear the highscores
     */
    void clear();
    
    /**
     * Save the highscores to a file
     */
    void save();
    
    /**
     * Read the highscores from a file
     */
    void read();
    
    /**
     * 
     * @param gameMode 
     *              game modality which we want the highscores
     * @return the highscores for a game modality
     */
    HighscoreStore getHighscoresForModality(GameModality gameMode);

}
