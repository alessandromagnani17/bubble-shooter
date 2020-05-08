package bubbleshooter.model.game.gameMode;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.BubbleFactory;
import bubbleshooter.model.bubble.GameObjectManager;
import bubbleshooter.model.bubble.ShootingBubble;
import bubbleshooter.model.bubble.SwitchBubble;
import bubbleshooter.model.bubble.bubbleGrid.BubbleGridHelper;
import bubbleshooter.model.bubble.bubbleGrid.BubbleGridManager;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameOverChecker;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.GameType;
import javafx.geometry.Point2D;

public abstract class AbstractGameMode implements GameMode {
	
	 private static final int NUM_BUBBLES = 19;
	 private static final int NUM_ROWS = 8;

	private GameObjectManager gameObjectManager;
	private BubbleGridManager bubbleGridManager;
	private BubbleGridHelper bubbleGridHelper;
	private CollisionController collisionController;
	private GameInfoManager gameInfoManager;
	private GameOverChecker gameOverChecker;
	private BubbleFactory bubbleFactory;
	private GameStatus status = GameStatus.PAUSE;
	private GameType currentLevelTypes;

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

	private void initGameObject() {
		Stream.iterate(1, i -> i += 1).limit(NUM_ROWS).forEach(i -> this.createNewRow());
		this.loadShootingBubble();
		this.loadSwitchBubble();
	}

	private void createNewRow() {
		this.gameObjectManager.addBubble(this.bubbleGridManager.createNewRow());
	}

	public final void loadShootingBubble() {
		this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createShootingBubble(
				new Point2D(350, 670),
				BubbleColor.getRandomColor())));
	}

	public final void loadSwitchBubble() {
		this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createSwitchBubble(
				new Point2D(175, 670),
				BubbleColor.getRandomColor())));
	}

	/**
	 * Method to reload the {@link ShootingBubble} after a {@link Collision}.
	 */
	public final void reloadShootingBubble() {
		Bubble shootingBubble = this.gameObjectManager.getShootingBubble();
		shootingBubble
				.setPosition(new Point2D(350, 670));
		shootingBubble.setDirection(shootingBubble.getPosition());
		shootingBubble.setColor(this.gameObjectManager.getSwitchBubble().getColor());
	}

	/**
	 * Method to reload the {@link SwitchBubble} after a {@link Collision}.
	 */
	public final void reloadSwitchBubble() {
		Bubble switchBubble = this.gameObjectManager.getSwitchBubble();
		switchBubble.setPosition(new Point2D(175, 670));
		final Random rand = new Random();
		switchBubble.setColor(this.bubbleGridHelper.getRemainingColors()
				.get(rand.nextInt(this.bubbleGridHelper.getRemainingColors().size() - 1)));
	}

	public final GameObjectManager getGameObjectManager() {
		return this.gameObjectManager;
	}

	public final void setGameOver() {
		this.setGameStatus(GameStatus.GAMEOVER);
	}

	public final void setCurrentLevelTypes(final GameType level) {
		this.currentLevelTypes = level;
	}

	private final boolean checkGameOver() {
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

	public final GameType getCurrentLevelTypes() {
		return this.currentLevelTypes;
	}

	public final BubbleFactory getBubbleFactory() {
		return this.bubbleFactory;
	}

	public int getNumRows() {
		return NUM_ROWS; 
	}
	
	public int getBubblesPerRow() {
		return NUM_BUBBLES; 
	}
	protected abstract void updateScore(double elapsed);

	protected abstract boolean isTimeToNewRow(double elapsed);
}
