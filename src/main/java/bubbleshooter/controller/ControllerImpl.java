package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.controller.sound.SoundGameEngine;
import bubbleshooter.controller.engine.BasicGameLoop;
import bubbleshooter.model.Model;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.game.GameType;
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
    }

    /**
    * The method called by the {@link View} to start the Game in the {@link Model}.
    * @param levelType
    */
    @Override
    public final void startGame(final GameType levelType) {
     this.engine = new SoundGameEngine(new BasicGameLoop(this.view, this.model));
     this.startSelectedGame(levelType);
     this.scoresManager = new ScoreManager(this.model.getLevel().getGameInfoManager());
     this.engine.startLoop();
    }

    private void startSelectedGame(final GameType levelType) {
        if (levelType.equals(GameType.BASICMODE)) {
            this.model.startBasicGame();
        } else if (levelType.equals(GameType.SURVIVALMODE)) {
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


    /**
     * Method used for save the scores in the highscores.
     * 
     * @param text the name of the player.
     */
    @Override
    public final void saveScore(final String text) {
        this.scoresManager.saveScore(text, this.model.getLevel().getCurrentLevelTypes());
    }

    /**
     * Method called by {@link GameOverController} and {@link HighscoreController}
     * for have informations about the scores.
     * 
     * @return the ScoreManager.
     */
    @Override
    public final ScoreManager getScoreManager() {
        return this.scoresManager;
    }


    /**
     * Method used to have the current game modality.
     * 
     * @return the current game modality.
     */
    @Override
    public final GameType getCurrentLevel() {
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
