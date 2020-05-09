package bubbleshooter.model.highscore;

import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameType;
import javafx.collections.ObservableList;

public class ScoreManager {

    private GameInfoManager scoresManager;
    private HighscoreStore highscoreStore;

<<<<<<< HEAD
    public ScoreManager(final GameInfoManager scoresManager) {
        this.scoresManager = scoresManager;
        this.highscoreStore = new HighscoreStoreImpl();
    }
=======
	public ObservableList<HighscoreStructure> getHighscores(GameType gameMode) {
		return this.highscoreStore.getHighscoresForModality(gameMode);
	}
>>>>>>> a08d0405b5852e285e466fbdd984491a0c2dab8e

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

<<<<<<< HEAD
    public final int getWrongShoots() {
        return this.scoresManager.getWrongShoots();
    }
=======
	public void saveScore(String text, GameType currentLevelTypes) {
		this.highscoreStore.addScore(new HighscoreStructure(text.replace(" ", "_"), this.getScore(), currentLevelTypes));
	}
>>>>>>> a08d0405b5852e285e466fbdd984491a0c2dab8e

    public final void saveScore(final String text, final LevelTypes currentLevelTypes) {
        this.highscoreStore.addScore(new HighscoreStructure(text.replace(" ", "_"), this.getScore(), currentLevelTypes));
    }
}
