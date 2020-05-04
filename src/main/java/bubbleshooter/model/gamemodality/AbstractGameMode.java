package bubbleshooter.model.gamemodality;

import java.util.Collections;
import java.util.List;
import java.util.Random;
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

	public void start() {
		this.status = GameStatus.RUNNING;
		this.initGameObject();
	}

	public void update(final double elapsed) {
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
		Random rnd = new Random();
		List<BubbleColor> remainingColors = this.bubbleGridHelper.getRemainingColors();
		this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createShootingBubble(
				new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() - Bubble.getWidth()),
				remainingColors.get(rnd.nextInt(remainingColors.size() - 1)))));
	}

	public final void loadSwitchBubble() {
		Random rnd = new Random();
		List<BubbleColor> remainingColors = this.bubbleGridHelper.getRemainingColors();
		this.gameObjectManager.addBubble(Collections.singletonList(this.bubbleFactory.createSwitchBubble(
				new Point2D(Settings.getGuiWidth() / 1.1, Settings.getGuiHeigth() - Bubble.getWidth()),
				remainingColors.get(rnd.nextInt(remainingColors.size() - 1)))));
	}

	public final GameObjectManager getGameObjectManager() {
		return this.gameObjectManager;
	}

	public void setGameOver() {
		this.setGameStatus(GameStatus.GAMEOVER);
	}

	public void setCurrentLevelTypes(final LevelTypes level) {
		this.currentLevelTypes = level;
	}

	public boolean checkGameOver() {
		return this.gameOverChecker.checkGameOver();
	}

	public void setGameStatus(final GameStatus status) {
		this.status = status;
	}

	public GameStatus getGameStatus() {
		return this.status;
	}

	public BubbleGridManager getGridManager() {
		return this.bubbleGridManager;
	}

	public BubbleGridHelper getGridHelper() {
		return this.bubbleGridHelper;
	}

	public CollisionController getCollisionController() {
		return this.collisionController;
	}

	public List<Bubble> getCurrentBubbles() {
		return this.gameObjectManager.getAllBubbles();
	}

	public GameInfoManager getGameInfoManager() {
		return this.gameInfoManager;
	}

	public LevelTypes getCurrentLevelTypes() {
		return this.currentLevelTypes;
	}

	public BubbleFactory getBubbleFactory() {
		return this.bubbleFactory;
	}

	public abstract void updateScore(double elapsed);

	public abstract boolean isTimeToNewRow(double elapsed);
}