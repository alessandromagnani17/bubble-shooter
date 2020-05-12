package bubbleshooter.model.game.level;

import java.util.Collections;
import java.util.Random;
import bubbleshooter.model.Model;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.BubbleFactory;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.bubble.grid.BubbleGridHelper;
import bubbleshooter.model.bubble.grid.BubbleGridManager;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.game.GameData;
import bubbleshooter.model.game.GameOverChecker;
import bubbleshooter.model.game.GameStatus;
import javafx.geometry.Point2D;

public abstract class AbstractLevel implements Level {

    private static final int MILLISECONDS_IN_A_SECOND = 1000;
    private static final double LIMITS_SHOOTING_BUBBLE_Y = 1.08;

    private final BubblesManager bubblesManager;
    private final BubbleGridManager bubbleGridManager;
    private final BubbleGridHelper bubbleGridHelper;
    private final CollisionController collisionController;
    private final GameData gameData;
    private final GameOverChecker gameOverChecker;
    private final BubbleFactory bubbleFactory;
    private GameStatus status;
    private LevelType currentGameType;

    public AbstractLevel() {
        this.bubblesManager = new BubblesManager();
        this.bubbleGridManager = new BubbleGridManager(this);
        this.bubbleGridHelper = new BubbleGridHelper(this.bubblesManager);
        this.collisionController = new CollisionController(this);
        this.gameData = new GameData();
        this.gameOverChecker = new GameOverChecker(this);
        this.bubbleFactory = new BubbleFactory();
        this.status = GameStatus.PAUSE;
    }

    @Override
    public final void update(final double elapsed) {
        this.bubblesManager.update(elapsed);
        this.collisionController.checkCollisions();
        this.gameData.updateGameTime(elapsed);
        this.updateScore(elapsed / MILLISECONDS_IN_A_SECOND);
        if (this.isTimeToNewRow(elapsed / MILLISECONDS_IN_A_SECOND)) {
            this.createNewRow();
        }
        if (this.checkGameOver()) {
            this.status = GameStatus.GAMEOVER;
        }
    }

    @Override
    public final void start() {
        this.status = GameStatus.RUNNING;
        this.initBubbles();
    }

    /**
     * initialize the bubbles in the game.
     */
    private void initBubbles() {
        for (int i = 0; i < NUM_ROWS; i++) {
            this.createNewRow();
        }
        this.loadSwitchBubble();
        this.loadShootingBubble();
    }

    /**
     * creates new row of {@link Bubble}.
     */
    private void createNewRow() {
        this.bubblesManager.addBubbles(this.bubbleGridManager.createNewRow(NUM_BUBBLES_PER_ROW));
    }

    @Override
    public final void loadShootingBubble() {
        if (this.bubblesManager.getShootingBubble().isPresent()) {
            Bubble shootingBubble = this.bubblesManager.getShootingBubble().get();
            shootingBubble
                    .setPosition(new Point2D(Model.WORLD_WIDTH / 2, Model.WORLD_HEIGHT / LIMITS_SHOOTING_BUBBLE_Y));
            shootingBubble.setDirection(shootingBubble.getPosition());
            shootingBubble.setColor(this.bubblesManager.getSwitchBubble().get().getColor());
        } else {
            this.bubblesManager.addBubbles(Collections.singletonList(this.bubbleFactory.createShootingBubble(
                    new Point2D(Model.WORLD_WIDTH / 2, Model.WORLD_HEIGHT / LIMITS_SHOOTING_BUBBLE_Y),
                    BubbleColor.getRandomColor())));
        }
    }

    @Override
    public final void loadSwitchBubble() {
        if (this.bubblesManager.getSwitchBubble().isPresent()) {
            final Random rand = new Random();
            Bubble switchBubble = this.bubblesManager.getSwitchBubble().get();
            switchBubble.setPosition(new Point2D(Model.WORLD_WIDTH / 4, Model.WORLD_HEIGHT / LIMITS_SHOOTING_BUBBLE_Y));
            switchBubble.setColor(this.bubbleGridHelper.getRemainingColors()
                    .get(rand.nextInt(this.bubbleGridHelper.getRemainingColors().size() - 1)));
        } else {
            this.bubblesManager.addBubbles(Collections.singletonList(this.bubbleFactory.createSwitchBubble(
                    new Point2D(Model.WORLD_WIDTH / 4, Model.WORLD_HEIGHT / LIMITS_SHOOTING_BUBBLE_Y),
                    BubbleColor.getRandomColor())));
        }
    }

    public final BubblesManager getBubblesManager() {
        return this.bubblesManager;
    }

    @Override
    public final void setLevelType(final LevelType gameType) {
        this.currentGameType = gameType;
    }

    /**
     * checks if it's game over.
     * 
     * @return true if it's game over, false otherwise.
     */
    private boolean checkGameOver() {
        return this.gameOverChecker.checkGameOver();
    }

    @Override
    public final void setGameStatus(final GameStatus status) {
        this.status = status;
    }

    @Override
    public final GameStatus getGameStatus() {
        return this.status;
    }

    @Override
    public final BubbleGridManager getGridManager() {
        return this.bubbleGridManager;
    }

    @Override
    public final BubbleGridHelper getGridHelper() {
        return this.bubbleGridHelper;
    }

    @Override
    public final CollisionController getCollisionController() {
        return this.collisionController;
    }

    @Override
    public final GameData getGameData() {
        return this.gameData;
    }

    public final LevelType getLevelType() {
        return this.currentGameType;
    }

    @Override
    public final BubbleFactory getBubbleFactory() {
        return this.bubbleFactory;
    }

    /**
     * Updates the score.
     * 
     * @param elapsed
     */
    protected abstract void updateScore(double elapsed);

    /**
     * Check if it's time to create new row of bubbles.
     * 
     * @param elapsed
     * @return true if it's time to create new row, false otherwise
     */
    protected abstract boolean isTimeToNewRow(double elapsed);

}
