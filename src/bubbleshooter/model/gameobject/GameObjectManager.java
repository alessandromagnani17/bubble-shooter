package bubbleshooter.model.gameobject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GameObjectManager {
    
    private List<GameObject> gameObjects;
    
    public GameObjectManager() {
        this.gameObjects = new LinkedList<>();    
    } 
    
    public final void update(final double elapsed) {
        //this.gameObjects.forEach(x -> x.update(elapsed));     
        this.removeGameObject(); 
    }

    private void removeGameObject() {
        this.gameObjects = gameObjects.stream()
                .filter(x -> !x.isDestroyed())
                .collect(Collectors.toList());        
    }

    public void addGameObject(final List<GameObject> gameObjects) {
         this.gameObjects.addAll(gameObjects); 
    }
    
    public final List<GameObject> getGameObjects(){
        return Collections.unmodifiableList(gameObjects); 
    }

}
