package bubbleshooter.model.gamemodality;

import java.util.LinkedList;
import java.util.List;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.collision.CollisionControllerImpl;
import bubbleshooter.model.gameobject.BasicBubble;
import bubbleshooter.model.gameobject.Cannon;
import bubbleshooter.model.gameobject.GameObject;

public class BasicMode implements GameModality{

    private List<GameObject> currentGameObjects;
    private CollisionController collisionController;
    private GameStatus status = GameStatus.PAUSE;
    //gameDataManager per gestire punteggio

    @Override
    public void startLevel() {
        this.currentGameObjects = new LinkedList<GameObject>();
        this.collisionController = new CollisionControllerImpl();
        this.status = GameStatus.RUNNING;
        this.initGameObjects();
    }

    private void initGameObjects() {
        this.currentGameObjects.add(new Cannon());
        //this.currentGameObjects.add(new BubbleGrid(6,10)):
        this.update(0);
    }

    @Override
    public void update(final double elapsed) {
       for (GameObject gameObj : this.currentGameObjects) {
           gameObj.update(elapsed);
       }
       //this.collisionController.checkCollsions(this.currentGameObjects) 
    }

    @Override
    public void setGameStatus(final GameStatus status) {
        this.status = status;
    }

    @Override
    public List<GameObject> getCurrentGameObjects() {
        return this.currentGameObjects;
    }

    @Override
    public void setGameOver() {
        this.setGameStatus(GameStatus.GAMEOVER);
    }

    @Override
    public CollisionController getCollisionController() {
        return this.collisionController;
    }

    @Override
    public GameStatus getGameStatus() {
        return this.status;
    }

}
