package bubbleshooter.model;

import java.util.List;

import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gamemodality.BasicMode;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.model.gamemodality.SurvivalMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.GameObjectManager;

public class ModelImpl implements Model {

    private AbstractGameMode gameMode;

    @Override
    public void startBasicGame() {
        this.gameMode = new BasicMode();
        this.gameMode.start();
    }

    @Override
    public void startSurvivalGame() {
        this.gameMode = new SurvivalMode();
        this.gameMode.start();
    }


    @Override
    public void update(final double elapsed) {
        this.gameMode.update(elapsed);
    }

    @Override
    public GameStatus getGameStatus() {
        return this.gameMode.getGameStatus();
    }

	@Override
	public GameObjectManager getGameObjectManager() {
		return this.gameMode.getGameObjectManager();
	}

	@Override
	public List<Bubble> getBubbles() {
		return this.gameMode.getGameObjectManager().getAllBubbles();
	}
}
