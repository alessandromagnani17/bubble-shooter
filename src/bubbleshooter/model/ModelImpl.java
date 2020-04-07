package bubbleshooter.model;

import java.util.List;

import bubbleshooter.model.gamemodality.BasicMode;
import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.model.gamemodality.SurvivalMode;
import bubbleshooter.model.gameobject.GameObject;

public class ModelImpl implements Model {

    private GameModality gameMode;

    @Override
    public void startBasicGame() {
        this.gameMode = new BasicMode();
        this.gameMode.startLevel();
    }

    @Override
    public void startSurvivalGame() {
        this.gameMode = new SurvivalMode();
        this.gameMode.startLevel();
    }

    @Override
    public List<GameObject> getGameObjects() {
        return this.gameMode.getCurrentGameObjects();
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
    public GameModality getGameModality() {
        return this.gameMode;
    }


}
