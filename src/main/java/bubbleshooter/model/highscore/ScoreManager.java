package bubbleshooter.model.highscore;

import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameType;
import javafx.collections.ObservableList;

public class ScoreManager {

	private GameInfoManager scoresInfo;
	private HighscoreStore highscoreStore;

    public ScoreManager(final GameInfoManager scoresInfo) {
        this.scoresInfo = scoresInfo;
        this.highscoreStore = new HighscoreStoreImpl();
    }

    public final ObservableList<HighscoreStructure> getHighscores(final GameType gameMode) {
        return this.highscoreStore.getHighscoresForModality(gameMode);
    }

    public final int getScore() {
        return this.scoresInfo.getScore();
    }

    public final int getDestroyedBubbles() {
        return this.scoresInfo.getDestroyedBubbles();
	}

    public final double getGameTime() {
        return this.scoresInfo.getGameTime();
	}

    public final void saveScore(String text, GameType currentLevelTypes) {
        this.highscoreStore.addScore(new HighscoreStructure(text.replace(" ", "_"), this.getScore(), currentLevelTypes));
    }

}
