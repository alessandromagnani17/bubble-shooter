package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.controller.sound.SoundGameEngine;
import bubbleshooter.controller.engine.BasicGameLoop;
import bubbleshooter.model.Model;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.view.View;

public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;
    private GameLoop engine;
    //GESTIRE LA PARTE DELL INPUT PER STOPPARE E FAR PARTIRE IL GAME LOOP

    public ControllerImpl(final Model model, final View view) {
     this.model = model;
     this.view = view;
    }

     //METODO CHE VERRA INVOCATO DA UN CONTROLLERFXML QUANDO VIENE SPINTO 
     //IL PULSANTE PLAY TRAMITE GETCONTROLLER CHE RESTITUISCE IL CONTROLLER DELLA GUI .startGame()
    @Override
    public final void startGame(final LevelTypes levelType) {
     this.engine = new SoundGameEngine(new BasicGameLoop(this.view, this.model));
     this.startSelectedGame(levelType);
     this.engine.startLoop();
    }

    @Override
    public final void pause() {
        this.engine.pauseLoop();
    }

    @Override
    public final void resume() {
        this.engine.resumeLoop();
    }

    @Override
    public final void setGameOver() {
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
    public final List<Bubble> getBubbles() {
        return this.model.getBubbles();
    }
}
