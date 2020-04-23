package bubbleshooter.model.gamemodality;

import java.util.Collections;
import java.util.List;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleFactory;

import bubbleshooter.model.gameobject.BubbleGridManager;

public class BasicMode implements GameModality {

    private GameObjectManager gameObjectManager;
    private BubbleGridManager bubbleGridManager; 
    private CollisionController collisionController;
    private GameStatus status = GameStatus.PAUSE;
    // gameDataManager per gestire punteggio

    public BasicMode() {
        this.gameObjectManager = new GameObjectManager(); 
        this.bubbleGridManager = new BubbleGridManager(this.gameObjectManager); 
        this.collisionController = new CollisionController(this); 
        this.status = GameStatus.PAUSE;
    }

    @Override
    public void start() {
        this.status = GameStatus.RUNNING;
        this.initGameObject(); 
    }

    public final void initGameObject() {
       for (int i = 0; i < GameCostants.ROWS.getValue(); i++) {
           this.gameObjectManager.addGameObject(this.bubbleGridManager.createNewRow());
       }
       this.loadShootingBubble();
    }
    
    public void loadShootingBubble() {
    	this.gameObjectManager.addGameObject
        (Collections.singletonList(BubbleFactory.createShootingBubble(new Point2D(GameCostants.GUIWIDTH.getValue()/2, 600))));
    }

    public final GameObjectManager getGameObjectManager() {
        return this.gameObjectManager;
    }
    
    @Override
    public void update(final double elapsed) {
       this.gameObjectManager.update(elapsed);
       this.collisionController.checkCollisions();
    }

    @Override
    public void setGameStatus(final GameStatus status) {
        this.status = status;
    }

    @Override
    public List<Bubble> getCurrentBubbles() {
        return this.gameObjectManager.getBubbles();
    }

    @Override
    public void setGameOver() {
        this.setGameStatus(GameStatus.GAMEOVER);
    }

    @Override
    public GameStatus getGameStatus() {
        return this.status;
    }

    @Override
    public BubbleGridManager getGridManager() {
        return this.bubbleGridManager;
    }

	@Override
	public LevelTypes getLevelType() {
		return LevelTypes.BASICMODE;
	}

}
