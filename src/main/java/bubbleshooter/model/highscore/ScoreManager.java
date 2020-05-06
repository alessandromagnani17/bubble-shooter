package bubbleshooter.model.highscore;

import bubbleshooter.model.gamemodality.GameInfoManager;
import bubbleshooter.model.gamemodality.LevelTypes;
import javafx.collections.ObservableList;

public class ScoreManager {
	
	GameInfoManager scoresManager;
	private HighscoreStore highscoreStore;

	public ScoreManager(GameInfoManager scoresManager) {
		this.scoresManager = scoresManager;
		this.highscoreStore = new HighscoreStoreImpl();
	}

	public ObservableList<HighscoreStructure> getHighscores(LevelTypes gameMode) {
		return this.highscoreStore.getHighscoresForModality(gameMode);
	}

	public int getScore() {
		return this.scoresManager.getScore();
	}

	public int getDestroyedBubbles() {
		return this.scoresManager.getDestroyedBubbles();
	}

	public double getGameTime() {
		return this.scoresManager.getGameTime();
	}

	public int getWrongShoots() {
		return this.scoresManager.getWrongShoots();
	}

	public void saveScore(String text, LevelTypes currentLevelTypes) {
		this.highscoreStore.addScore(new HighscoreStructure(text.replace(" ", "_"), this.getScore(), currentLevelTypes));
	}

}
