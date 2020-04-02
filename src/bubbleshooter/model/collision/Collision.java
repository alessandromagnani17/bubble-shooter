package bubbleshooter.model.collision;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import bubbleshooter.model.gameobject.GameObject;

public class Collision {

    private GameObject firstGameObj;
    private GameObject secondGameObj;
    private CollisionType type;

    public Collision(final GameObject first, final GameObject second, final CollisionType type) {
        this.firstGameObj = first;
        this.secondGameObj = second;
        this.type = type;
    }

    public final List<GameObject> getCollidedObjects() {
       return Arrays.asList(this.firstGameObj, this.secondGameObj);
    }

    public final GameObject getFirstCollided() {
        return this.firstGameObj;
    }

    public final GameObject getSecondCollided() {
        return this.secondGameObj;
    }

    public final CollisionType getCollistionType() {
        return this.type;
    }
}
