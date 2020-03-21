package bubbleshooter.model.collision;

import java.util.List;

import bubbleshooter.model.gameobject.GameObject;

public interface CollisionController {

   void checkCollisions(List<GameObject> gameObjects);

   boolean hasCollided(GameObject a, GameObject b);

   List<GameObject> getCollidedObjects();
}
