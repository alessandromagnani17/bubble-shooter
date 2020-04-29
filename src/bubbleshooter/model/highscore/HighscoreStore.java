package bubbleshooter.model.highscore;

import java.io.File;
import java.io.Serializable;
import bubbleshooter.model.gamemodality.LevelTypes;
import javafx.collections.ObservableList;

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
    void addScore(HighscoreStructure score);

    /**
     * 
     * @param gameMode 
     *              game modality which we want the highscores
     * @return the highscores for a game modality
     */
    ObservableList<HighscoreStructure> getHighscoresForModality(LevelTypes gameMode);


}
