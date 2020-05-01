package bubbleshooter.model.gamemodality;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleFactory;
import bubbleshooter.model.gameobject.BubbleGridHelper;
import bubbleshooter.model.gameobject.BubbleGridManager;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public abstract class AbstractGameMode {

	private GameObjectManager gameObjectManager;
	private BubbleGridManager bubbleGridManager;
	private BubbleGridHelper bubbleGridHelper;
	private CollisionController collisionController;
	private GameInfoManager gameInfoManager;
	private GameOverChecker gameOverChecker;
	private GameStatus status = GameStatus.PAUSE;
	private LevelTypes currentLevelTypes;
	// gameDataManager per gestire punteggio

	public AbstractGameMode() {
		this.gameObjectManager = new GameObjectManager();
		this.bubbleGridManager = new BubbleGridManager(this.gameObjectManager);
		this.bubbleGridHelper = new BubbleGridHelper(gameObjectManager);
		this.collisionController = new CollisionController(this);
		this.gameInfoManager = new GameInfoManager();
		this.gameOverChecker = new GameOverChecker(this);
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
		this.updateScore(elapsed);
		if (this.isTimeToNewRow(elapsed)) {
			this.createNewRow();
		}
		this.checkGameOver();

	}

	public final void initGameObject() {
		Stream.iterate(1, i -> i += 1).limit((long) GameCostants.ROWS.getValue()).forEach(i -> this.createNewRow());
		this.loadShootingBubble();
		this.loadSwitchBubble();
	}

	private void createNewRow() {
		this.gameObjectManager.addBubble(this.bubbleGridManager.createNewRow());
	}

	public final void loadShootingBubble() {
		this.gameObjectManager.addBubble(Collections.singletonList(
				BubbleFactory.createShootingBubble(new Point2D(GameCostants.GUIWIDTH.getValue() / 2, 600))));
	}
	
	public final void loadSwitchBubble() {
		this.gameObjectManager.addBubble(Collections.singletonList(
				BubbleFactory.createSwitchBubble(new Point2D(600, 600))));
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

	public List<Bubble> getCurrentBubbles() {
		return this.gameObjectManager.getAllBubbles();
	}

	public GameInfoManager getGameInfoManager() {
		return this.gameInfoManager;
	}
	
	public LevelTypes getCurrentLevelTypes() {
		return this.currentLevelTypes;
	}

	public abstract void updateScore(double elapsed);

	public abstract boolean isTimeToNewRow(double elapsed);
}