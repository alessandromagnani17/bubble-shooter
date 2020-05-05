package bubbleshooter.model.gamemodality;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleColor;
import bubbleshooter.model.gameobject.BubbleFactory;
import bubbleshooter.model.gameobject.BubbleGridHelper;
import bubbleshooter.model.gameobject.BubbleGridManager;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;

public abstract class AbstractGameMode {

    private GameObjectManager gameObjectManager;
    private BubbleGridManager bubbleGridManager;
    private BubbleGridHelper bubbleGridHelper;
    private CollisionController collisionController;
    private GameInfoManager gameInfoManager;
    private GameOverChecker gameOverChecker;
    private BubbleFactory bubbleFactory;
    private GameStatus status = GameStatus.PAUSE;
    private LevelTypes currentLevelTypes;

    public AbstractGameMode() {
        this.gameObjectManager = new GameObjectManager();
        this.bubbleGridManager = new BubbleGridManager(this);
        this.bubbleGridHelper = new BubbleGridHelper(gameObjectManager);
        this.collisionController = new CollisionController(this);
        this.gameInfoManager = new GameInfoManager();
        this.gameOverChecker = new GameOverChecker(this);
        this.bubbleFactory = new BubbleFactory();
        this.status = GameStatus.PAUSE;
    }

    public final void start() {
        this.status = GameStatus.RUNNING;
        this.initGameObject();
    }

    public final void update(final double elapsed) {
        this.gameObjectManager.update(elapsed);
        this.collisionController.checkCollisions();
        this.gameInfoManager.updateGameTime(elapsed);
        this.updateScore(elapsed / 1000);
        if (this.isTimeToNewRow(elapsed)) {
            this.createNewRow();
        }
        if (this.checkGameOver()) {
            this.status = GameStatus.GAMEOVER;
        }
    }

    public final void initGameObject() {
        Stream.iterate(1, i -> i += 1).limit((long) Settings.getNumRows()).forEach(i -> this.createNewRow());
        this.loadShootingBubble();
        this.loadSwitchBubble();
    }

    private void createNewRow() {
        this.gameObjectManager.addBubble(this.bubbleGridManager.createNewRow());
    }

    public final void loadShootingBubble() {
        this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createShootingBubble(
                    new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() - Bubble.getWidth()), BubbleColor.getRandomColor())));
    }

    public final void loadSwitchBubble() {
        this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createSwitchBubble(
                new Point2D(Settings.getGuiWidth() / 4, Settings.getGuiHeigth() - Bubble.getWidth()), BubbleColor.getRandomColor())));
    }

    public final GameObjectManager getGameObjectManager() {
        return this.gameObjectManager;
    }

    public final void setGameOver() {
        this.setGameStatus(GameStatus.GAMEOVER);
    }

    public final void setCurrentLevelTypes(final LevelTypes level) {
        this.currentLevelTypes = level;
    }

    public final boolean checkGameOver() {
        return this.gameOverChecker.checkGameOver();
    }

    public final void setGameStatus(final GameStatus status) {
        this.status = status;
    }

    public final GameStatus getGameStatus() {
        return this.status;
    }

    public final BubbleGridManager getGridManager() {
        return this.bubbleGridManager;
    }

    public final BubbleGridHelper getGridHelper() {
        return this.bubbleGridHelper;
    }

    public final CollisionController getCollisionController() {
        return this.collisionController;
    }

    public final List<Bubble> getCurrentBubbles() {
        return this.gameObjectManager.getAllBubbles();
    }

    public final GameInfoManager getGameInfoManager() {
        return this.gameInfoManager;
    }

    public final LevelTypes getCurrentLevelTypes() {
        return this.currentLevelTypes;
    }

    public final BubbleFactory getBubbleFactory() {
        return this.bubbleFactory;
    }

    public abstract void updateScore(double elapsed);

    public abstract boolean isTimeToNewRow(double elapsed);
}
