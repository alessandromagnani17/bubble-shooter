package bubbleshooter.controller;

import bubbleshooter.controller.engine.GameEngine;
import bubbleshooter.controller.engine.GameEngineImpl;
import bubbleshooter.model.Model;
import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.view.View;

public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;
    private GameEngine engine;
    //GESTIRE LA PARTE DELL INPUT PER STOPPARE E FAR PARTIRE IL GAME LOOP

    public ControllerImpl(final Model model, final View view) {
     this.model = model;
     this.view = view;
    }

     //METODO CHE VERRA INVOCATO DA UN CONTROLLERFXML QUANDO VIENE SPINTO 
     //IL PULSANTE PLAY TRAMITE GETCONTROLLER CHE RESTITUISCE IL CONTROLLER DELLA GUI .startGame()
    @Override
    public void startGame(final LevelTypes levelType) {
     this.engine = new GameEngineImpl(this.view, this.model);
     this.startSelectedGame(levelType);
     this.engine.startLoop();
     //far partire la musica
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
}
