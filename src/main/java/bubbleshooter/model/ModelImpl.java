package bubbleshooter.model;

import java.util.List;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gamemodality.BasicMode;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.model.gamemodality.SurvivalMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.GameObjectManager;

/**
 *The class which manage the logic of the game.
 *Implements the {@link Model} interface.
 */
public class ModelImpl implements Model {

    private AbstractGameMode gameMode;

    @Override
    public final void startBasicGame() {
        this.gameMode = new BasicMode();
        this.gameMode.start();
    }

    @Override
    public final void startSurvivalGame() {
        this.gameMode = new SurvivalMode();
        this.gameMode.start();
    }


    @Override
    public final void update(final double elapsed) {
        this.gameMode.update(elapsed);
    }

    @Override
    public final GameStatus getGameStatus() {
        return this.gameMode.getGameStatus();
    }

    @Override
    public final GameObjectManager getGameObjectManager() {
        return this.gameMode.getGameObjectManager();
    }

    @Override
    public final List<Bubble> getBubbles() {
        return this.gameMode.getGameObjectManager().getAllBubbles();
    }

    @Override
    public final AbstractGameMode getLevel() {
        return this.gameMode;
    }
}
