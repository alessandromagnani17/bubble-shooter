package bubbleshooter.model.game.gameMode;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import bubbleshooter.model.Model;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.BubbleFactory;
import bubbleshooter.model.bubble.BubblesManager;
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
	private static final int MILLISECONDS_IN_A_SECOND = 1000;

	private BubblesManager bubblesManager;
	private BubbleGridManager bubbleGridManager;
	private BubbleGridHelper bubbleGridHelper;
	private CollisionController collisionController;
	private GameInfoManager gameInfoManager;
	private GameOverChecker gameOverChecker;
	private BubbleFactory bubbleFactory;
	private GameStatus status = GameStatus.PAUSE;
	private GameType currentGameType;

	public AbstractGameMode() {
		this.bubblesManager = new BubblesManager();
		this.bubbleGridManager = new BubbleGridManager(this);
		this.bubbleGridHelper = new BubbleGridHelper(this.bubblesManager);
		this.collisionController = new CollisionController(this);
		this.gameInfoManager = new GameInfoManager();
		this.gameOverChecker = new GameOverChecker(this);
		this.bubbleFactory = new BubbleFactory();
		this.status = GameStatus.PAUSE;
	}

	@Override
	public final void start() {
		this.status = GameStatus.RUNNING;
		this.initBubbles();
	}

	@Override
	public final void update(final double elapsed) {
		this.bubblesManager.update(elapsed);
		this.collisionController.checkCollisions();
		this.gameInfoManager.updateGameTime(elapsed);
		this.updateScore(elapsed / MILLISECONDS_IN_A_SECOND);
		if (this.isTimeToNewRow(elapsed)) {
			this.createNewRow();
		}
		if (this.checkGameOver()) {
			this.status = GameStatus.GAMEOVER;
		}
	}

	/**
	 * initialize the bubbles in the game.
	 */
	private void initBubbles() {
		Stream.iterate(1, i -> i += 1).limit(NUM_ROWS).forEach(i -> this.createNewRow());
		this.loadSwitchBubble();
		this.loadShootingBubble();
	}

	/**
	 * creates new row of {@link Bubble}.
	 */
	private void createNewRow() {
		this.bubblesManager.addBubble(this.bubbleGridManager.createNewRow());
	}

	@Override
	public final void loadShootingBubble() {
		if (this.bubblesManager.getShootingBubble().isPresent()) {
			Bubble shootingBubble = this.bubblesManager.getShootingBubble().get();
			shootingBubble.setPosition(new Point2D(Model.WIDTH / 2, Model.HEIGTH - 50));
			shootingBubble.setDirection(shootingBubble.getPosition());
			shootingBubble.setColor(this.bubblesManager.getSwitchBubble().get().getColor());
		} else {
			this.bubblesManager.addBubble(Collections.singletonList(this.bubbleFactory.createShootingBubble(
					new Point2D(Model.WIDTH / 2, Model.HEIGTH - 50), BubbleColor.getRandomColor())));
		}
	}

	@Override
	public final void loadSwitchBubble() {
		if (this.bubblesManager.getSwitchBubble().isPresent()) {
			final Random rand = new Random();
			Bubble switchBubble = this.bubblesManager.getSwitchBubble().get();
			switchBubble.setPosition(new Point2D(Model.WIDTH / 4, Model.HEIGTH - 50));
			switchBubble.setColor(this.bubbleGridHelper.getRemainingColors()
					.get(rand.nextInt(this.bubbleGridHelper.getRemainingColors().size() - 1)));
		} else {
			this.bubblesManager.addBubble(Collections.singletonList(this.bubbleFactory.createSwitchBubble(
					new Point2D(Model.WIDTH / 4, Model.HEIGTH - 50), BubbleColor.getRandomColor())));
		}
	}

	@Override
	public final BubblesManager getBubblesManager() {
		return this.bubblesManager;
	}

	@Override
	public final void setCurrentGameType(final GameType gameType) {
		this.currentGameType = gameType;
	}

	/**
	 * checks if it's game over.
	 * 
	 * @return true if it's game over, false otherwise.
	 */
	private final boolean checkGameOver() {
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
		return this.bubblesManager.getAllBubbles();
	}

	@Override
	public final GameInfoManager getGameInfoManager() {
		return this.gameInfoManager;
	}

	@Override
	public final GameType getCurrentGameType() {
		return this.currentGameType;
	}
	
	@Override
	public final BubbleFactory getBubbleFactory() {
		return this.bubbleFactory;
	}

	@Override
	public int getNumRows() {
		return NUM_ROWS;
	}

	@Override
	public int getBubblesPerRow() {
		return NUM_BUBBLES;
	}

	/**
	 * updates the score
	 * 
	 * @param elapsed
	 */
	protected abstract void updateScore(double elapsed);

	/**
	 * check if it's time to create new row of bubbles
	 * 
	 * @param elapsed
	 * @return true if it's time to create new row, false otherwise
	 */
	protected abstract boolean isTimeToNewRow(double elapsed);
}
