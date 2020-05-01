package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.Bubble;

public class Collision {

    private final Bubble shootingBubble;
    private final Bubble collided;

    public Collision(final Bubble shootingBubble, final Bubble collided) {
        this.shootingBubble = shootingBubble;
        this.collided = collided;
    }

    public final Bubble getShootingBubble() {
        return this.shootingBubble;
    }

    public final Bubble getCollided() {
        return this.collided;
    }
}
