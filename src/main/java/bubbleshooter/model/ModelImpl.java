package bubbleshooter.model;

import java.util.List;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.mode.BasicLevel;
import bubbleshooter.model.game.mode.Level;
import bubbleshooter.model.game.mode.SurvivalLevel;

/**
 *The class which manage the logic of the game.
 *Implements the {@link Model} interface.
 */
public class ModelImpl implements Model {

    private Level gameMode;

    @Override
    public final void startBasicGame() {
        this.gameMode = new BasicLevel();
        this.gameMode.start();
    }

    @Override
    public final void startSurvivalGame() {
        this.gameMode = new SurvivalLevel();
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
    public final BubblesManager getGameObjectManager() {
        return this.gameMode.getBubblesManager();
    }

    @Override
    public final List<Bubble> getBubbles() {
        return this.gameMode.getBubblesManager().getAllBubbles();
    }

    @Override
    public final Level getLevel() {
        return this.gameMode;
    }
}
