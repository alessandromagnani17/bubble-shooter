package bubbleshooter.controller.collision;

import bubbleshooter.model.gameobject.GameObject;

public class Collision {

    private final GameObject shootingBubble;
    private final GameObject collided;
	
	public Collision(final GameObject shootingBubble, final GameObject collided) {
		this.shootingBubble = shootingBubble;
		this.collided = collided;
	}

    public final GameObject getShootingBubble() {
		return this.shootingBubble;
	}

	public final GameObject getCollided() {
		return this.collided;
	}
}
