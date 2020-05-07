package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.controller.sound.SoundGameEngine;
import bubbleshooter.controller.engine.BasicGameLoop;
import bubbleshooter.model.Model;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.highscore.ScoreManager;
import bubbleshooter.view.View;

/**
 * Class which implements the {@link Controller} interface.
 * Used to communicate with {@link Model} , {@link View} and to start the {@link GameLoop}.
 */
public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;
    private GameLoop engine;
    private ScoreManager scoresManager;

    /**
     * @param model The {@link Model} of the Game.
     * @param view The {@link View} of the Game.
     */
    public ControllerImpl(final Model model, final View view) {
     this.model = model;
     this.view = view;
     
     //this.highscoreStore = new HighscoreStoreImpl();
    }

    /**
    * The method called by the {@link View} to start the Game in the {@link Model}.
    * @param levelType
    */
    @Override
    public final void startGame(final LevelTypes levelType) {
     this.engine = new SoundGameEngine(new BasicGameLoop(this.view, this.model));
     this.startSelectedGame(levelType);
     this.scoresManager = new ScoreManager(this.model.getLevel().getGameInfoManager());
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
	public void saveScore(String text) {
		this.scoresManager.saveScore(text, this.model.getLevel().getCurrentLevelTypes());
	}
	
	@Override
	public ScoreManager getScoreManager() {
		return this.scoresManager;
	}
	
	@Override
	public final LevelTypes getCurrentLevel() {
		return this.model.getLevel().getCurrentLevelTypes();
	}

    /**It's called by the {@link View} to stop the {@link GameLoop} of the Game.
     * @return The Engine of the Game.
     */
	@Override
	public final GameLoop getGameEngine() {
		return this.engine;
	}
}
