package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.controller.sound.SoundGameEngine;
import bubbleshooter.controller.engine.BasicGameLoop;
import bubbleshooter.model.Model;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.highscore.HighscoreStore;
import bubbleshooter.model.highscore.HighscoreStoreImpl;
import bubbleshooter.model.highscore.HighscoreStructure;

import bubbleshooter.view.View;
import javafx.collections.ObservableList;

/**
 * Class which implements the {@link Controller} interface.
 * Used to communicate with {@link Model} , {@link View} and to start the {@link GameLoop}.
 */
public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;
    private GameLoop engine;
    private HighscoreStore highscoreStore;

    /**
     * @param model The {@link Model} of the Game.
     * @param view The {@link View} of the Game.
     */
    public ControllerImpl(final Model model, final View view) {
     this.model = model;
     this.view = view;
     this.highscoreStore = new HighscoreStoreImpl();
    }

    /**
    * The method called by the {@link View} to start the Game in the {@link Model}.
    * @param levelType
    */
    @Override
    public final void startGame(final LevelTypes levelType) {
     this.engine = new SoundGameEngine(new BasicGameLoop(this.view, this.model));
     this.startSelectedGame(levelType);
     this.engine.startLoop();
    }

    private void startSelectedGame(final LevelTypes levelType) {
        if (levelType.equals(LevelTypes.BASICMODE)) {
            this.model.startBasicGame();
        } else if (levelType.equals(LevelTypes.SURVIVALMODE)) {
            this.model.startSurvivalGame();
        }
    }

    /**
     * @return The List of the current Bubble in the Game.
     */
    @Override
    public final List<Bubble> getBubbles() {
        return this.model.getBubbles();
    }

	@Override
	public ObservableList<HighscoreStructure> getHighscoreList(LevelTypes gameMode) {
		return this.highscoreStore.getHighscoresForModality(gameMode);
	}

	@Override
	public int getScore() {
		return this.model.getLevel().getGameInfoManager().getScore();
	}
	
	@Override
	public int getDestroyedBubbles() {
		return this.model.getLevel().getGameInfoManager().getDestroyedBubbles();
	}
	
	@Override
	public double getGameTime() {
		return this.model.getLevel().getGameInfoManager().getGameTime();
	}
	
	@Override
	public int getWrongShoots() {
		return this.model.getLevel().getGameInfoManager().getWrongShoots();
	}

	@Override
	public void saveScore(String text) {
		this.highscoreStore.addScore(new HighscoreStructure(text.replace(" ", "_"), this.getScore(), this.model.getLevel().getCurrentLevelTypes()));
	}

    /**It's called by the {@link View} to stop the {@link GameLoop} of the Game.
     * @return The Engine of the Game.
     */
	@Override
	public final GameLoop getGameEngine() {
		return this.engine;
	}
}
