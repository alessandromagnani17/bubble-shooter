package bubbleshooter.model.gamemodality;

import java.util.Collections;
import java.util.List;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleFactory;
import bubbleshooter.model.gameobject.BubbleGridManager;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public abstract class AbstractGameMode {

	private GameObjectManager gameObjectManager;
	private BubbleGridManager bubbleGridManager;
	private CollisionController collisionController;
	private GameInfoManager gameInfoManager;
	private GameStatus status = GameStatus.PAUSE;
	// gameDataManager per gestire punteggio

	public AbstractGameMode() {
		this.gameObjectManager = new GameObjectManager();
		this.bubbleGridManager = new BubbleGridManager(this.gameObjectManager);
		this.collisionController = new CollisionController(this);
		this.gameInfoManager = new GameInfoManager();

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
		this.checkGameOver();
		this.updateScore(elapsed);
		if (this.isTimeToNewRow(elapsed)) {
			this.createNewRow();
		}

	}

	public final void initGameObject() {
		for (int i = 0; i < GameCostants.ROWS.getValue(); i++) {
			this.createNewRow();
		}
		this.loadShootingBubble();
	}

	private void createNewRow() {
		this.gameObjectManager.addBubble(this.bubbleGridManager.createNewRow());
	}

	public void loadShootingBubble() {
		this.gameObjectManager.addBubble(Collections.singletonList(
				BubbleFactory.createShootingBubble(new Point2D(GameCostants.GUIWIDTH.getValue() / 2, 600))));
	}

	public final GameObjectManager getGameObjectManager() {
		return this.gameObjectManager;
	}

	public void setGameOver() {
		this.setGameStatus(GameStatus.GAMEOVER);
	}

	public boolean checkGameOver() {
		// da implementare da qualche parte il metodo che controlla il gameOver
		return false;
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

	public List<Bubble> getCurrentBubbles() {
		return this.gameObjectManager.getAllBubbles();
	}

	public GameInfoManager getGameInfoManager() {
		return this.gameInfoManager;
	}

	public abstract void updateScore(double elapsed);

	public abstract boolean isTimeToNewRow(double elapsed);
}