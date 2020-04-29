package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.controller.sound.SoundGameEngine;
import bubbleshooter.controller.engine.BasicGameLoop;
import bubbleshooter.model.Model;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.highscore.HighscoreStoreImpl;
import bubbleshooter.model.highscore.HighscoreStructure;
import bubbleshooter.view.View;
import javafx.collections.ObservableList;

public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;
    private GameLoop engine;
    private HighscoreStoreImpl highscoreStore;
    //GESTIRE LA PARTE DELL INPUT PER STOPPARE E FAR PARTIRE IL GAME LOOP

    public ControllerImpl(final Model model, final View view) {
     this.model = model;
     this.view = view;
     this.highscoreStore = new HighscoreStoreImpl();
    }

     //METODO CHE VERRA INVOCATO DA UN CONTROLLERFXML QUANDO VIENE SPINTO 
     //IL PULSANTE PLAY TRAMITE GETCONTROLLER CHE RESTITUISCE IL CONTROLLER DELLA GUI .startGame()
    @Override
    public void startGame(final LevelTypes levelType) {
     this.engine = new SoundGameEngine(new BasicGameLoop(this.view, this.model));
     this.startSelectedGame(levelType);
     this.engine.startLoop();
    }

    @Override
    public void pause() {
        this.engine.pauseLoop();
    }

    @Override
    public void resume() {
        this.engine.resumeLoop();
    }

    @Override
    public void setGameOver() {
        this.engine.stopLoop();
    }

    private void startSelectedGame(final LevelTypes levelType) {
        if (levelType.equals(LevelTypes.BASICMODE)) {
            this.model.startBasicGame();
        } else if (levelType.equals(LevelTypes.SURVIVALMODE)) {
            this.model.startSurvivalGame();
        }
    }

	@Override
	public List<Bubble> getBubbles() {
		return this.model.getBubbles();
	}

	@Override
	public ObservableList<HighscoreStructure> getHighscoreList(LevelTypes gameMode) {
		ObservableList<HighscoreStructure> scoreList;
		scoreList = this.highscoreStore.getHighscoresForModality(gameMode);
		return scoreList;
	}

}
