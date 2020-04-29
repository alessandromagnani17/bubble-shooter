package bubbleshooter.model.gamemodality;

public class GameOverChecker {

	private AbstractGameMode gameMode;

	public GameOverChecker(AbstractGameMode gameMode) {
		super();
		this.gameMode = gameMode;
	}

	public boolean checkGameOver() {
		// metodo che controlla se la pallina più bassa si trova ad altezza shooting
		// bubble
		// risalire alle palline tramite il livello
		return false;
	}

}
