package bubbleshooter.model.game.mode;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import bubbleshooter.model.Model;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.BubbleFactory;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.bubble.grid.BubbleGridHelper;
import bubbleshooter.model.bubble.grid.BubbleGridManager;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameOverChecker;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.GameType;
import javafx.geometry.Point2D;

public abstract class AbstractGameMode implements GameMode {

	private static final int NUM_BUBBLES = 19;
	private static final int NUM_ROWS = 8;

	private final BubblesManager gameObjectManager;
	private final BubbleGridManager bubbleGridManager;
	private final BubbleGridHelper bubbleGridHelper;
	private final CollisionController collisionController;
	private final GameInfoManager gameInfoManager;
	private final GameOverChecker gameOverChecker;
	private final BubbleFactory bubbleFactory;
	private GameStatus status = GameStatus.PAUSE;
	private GameType currentLevelTypes;

	public AbstractGameMode() {
		this.gameObjectManager = new BubblesManager();
		this.bubbleGridManager = new BubbleGridManager(this);
		this.bubbleGridHelper = new BubbleGridHelper(gameObjectManager);
		this.collisionController = new CollisionController(this);
		this.gameInfoManager = new GameInfoManager();
		this.gameOverChecker = new GameOverChecker(this);
		this.bubbleFactory = new BubbleFactory();
		this.status = GameStatus.PAUSE;
	}

	@Override
	public final void start() {
		this.status = GameStatus.RUNNING;
		this.initGameObject();
	}

	@Override
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
		this.loadSwitchBubble();
		this.loadShootingBubble();
	}

	private void createNewRow() {
		this.gameObjectManager.addBubble(this.bubbleGridManager.createNewRow());
	}

	@Override
	public final void loadShootingBubble() {
		if (this.gameObjectManager.getShootingBubble().isPresent()) {
			final Bubble shootingBubble = this.gameObjectManager.getShootingBubble().get();
			shootingBubble.setPosition(new Point2D(Model.WIDTH / 2, Model.HEIGTH - Bubble.WIDTH));
			shootingBubble.setDirection(shootingBubble.getPosition());
			shootingBubble.setColor(this.gameObjectManager.getSwitchBubble().get().getColor());
		} else {
			this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createShootingBubble(
					new Point2D(Model.WIDTH / 2, Model.HEIGTH - Bubble.WIDTH), BubbleColor.getRandomColor())));
		}
	}

	@Override
	public final void loadSwitchBubble() {
		if (this.gameObjectManager.getSwitchBubble().isPresent()) {
			final Random rand = new Random();
			final Bubble switchBubble = this.gameObjectManager.getSwitchBubble().get();
			switchBubble.setPosition(new Point2D(Model.WIDTH / 4, Model.HEIGTH - Bubble.WIDTH));
			switchBubble.setColor(this.bubbleGridHelper.getRemainingColors()
					.get(rand.nextInt(this.bubbleGridHelper.getRemainingColors().size() - 1)));
		} else {
			this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createSwitchBubble(
					new Point2D(Model.WIDTH / 4, Model.HEIGTH - Bubble.WIDTH), BubbleColor.getRandomColor())));
		}
	}

	@Override
	public final BubblesManager getGameObjectManager() {
		return this.gameObjectManager;
	}

	@Override
	public final void setGameOver() {
		this.setGameStatus(GameStatus.GAMEOVER);
	}

	@Override
	public final void setCurrentLevelTypes(final GameType level) {
		this.currentLevelTypes = level;
	}

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
	public final List<Bubble> getCurrentBubbles() {
		return this.gameObjectManager.getAllBubbles();
	}

	@Override
	public final GameInfoManager getGameInfoManager() {
		return this.gameInfoManager;
	}

	@Override
	public final GameType getCurrentLevelTypes() {
		return this.currentLevelTypes;
	}

	@Override
	public final BubbleFactory getBubbleFactory() {
		return this.bubbleFactory;
	}

	@Override
	public final int getNumRows() {
		return NUM_ROWS;
	}

	@Override
	public final int getBubblesPerRow() {
		return NUM_BUBBLES;
	}

	protected abstract void updateScore(double elapsed);

	protected abstract boolean isTimeToNewRow(double elapsed);
}
