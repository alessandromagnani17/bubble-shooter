package bubbleshooter.model.gameobject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;


public class GameObjectManager {

    private List<GameObject> gameObjects;
    
    public GameObjectManager() {
        this.gameObjects = new LinkedList<>();
    } 

    public final void update(final double elapsed) {
        this.getShootingBubble().update(elapsed);
        this.gameObjects.removeAll(this.gameObjects.stream().filter(a -> a.isDestroyed()).collect(Collectors.toList()));
    }

    public final void addGameObject(final List<GameObject> gObj) {
        this.gameObjects.addAll(gObj);
    }

    public final void removeGameObject(final GameObject gObj) {
        this.gameObjects.remove(gObj);
    }

    public final GameObject getShootingBubble() {
        return this.gameObjects.stream().filter(a -> a.getType().equals(GameObjectsTypes.SHOOTINGBUBBLE)).iterator().next();
    }
    
    public final void reloadShootingBubble() {
        GameObject shootingBubble = this.getShootingBubble();
        shootingBubble.setPosition(new Point2D(GameCostants.GUIWIDTH.getValue()/2, 600));
        shootingBubble.setDirection(shootingBubble.getPosition());
        shootingBubble.setProperty(Property.getRandomColor());
    }

    public final List<GameObject> getGameObjects() {
        return Collections.unmodifiableList(gameObjects); 
    }

}

