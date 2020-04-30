package bubbleshooter.view.states;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.scene.controller.GameController;

public class InGameState extends GameState {

	public InGameState(GameController gameScene, Controller controller) {
		super(gameScene, controller);
	}

	@Override
	public void enter() {

	}

	@Override
	public void exit() {

	}

	public void mouseClick() {
		// si richiama il controller per dire al model di far partire la pallina
	}

	//metodo che si attiva quando si clicca il tasto pausa
	public void pauseGame() {
		this.getGameScene().setCurrentState(this.getGameScene().getInPauseState());
	}
	
	// da aggiungere in metodi per restart
	
	//da implementare metodi per i listener del cannone
}
