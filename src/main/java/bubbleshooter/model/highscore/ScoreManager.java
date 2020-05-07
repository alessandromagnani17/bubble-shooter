package bubbleshooter.model.highscore;

import bubbleshooter.model.gamemodality.GameInfoManager;
import bubbleshooter.model.gamemodality.LevelTypes;
import javafx.collections.ObservableList;

public class ScoreManager {

    private GameInfoManager scoresManager;
    private HighscoreStore highscoreStore;

    public ScoreManager(final GameInfoManager scoresManager) {
        this.scoresManager = scoresManager;
        this.highscoreStore = new HighscoreStoreImpl();
    }

    public final ObservableList<HighscoreStructure> getHighscores(final LevelTypes gameMode) {
        return this.highscoreStore.getHighscoresForModality(gameMode);
    }

    public final int getScore() {
        return this.scoresManager.getScore();
    }

    public final int getDestroyedBubbles() {
        return this.scoresManager.getDestroyedBubbles();
    }

    public final double getGameTime() {
        return this.scoresManager.getGameTime();
    }

    public final int getWrongShoots() {
        return this.scoresManager.getWrongShoots();
    }

    public final void saveScore(final String text, final LevelTypes currentLevelTypes) {
        this.highscoreStore.addScore(new HighscoreStructure(text.replace(" ", "_"), this.getScore(), currentLevelTypes));
    }
}
