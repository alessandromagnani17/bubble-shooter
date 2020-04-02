package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;

public class BubbleToGridHandler implements CollisionHandler {

    private GameObject shootingBubble;
    private GameObject bubbleCollided;

    public BubbleToGridHandler(final GameObject shootingBubble, final GameObject bubbleCollided) {
        this.shootingBubble = shootingBubble;
        this.bubbleCollided = bubbleCollided;
    }
    @Override
    public void handle() {
        //CONTROLLO IL COLORE E SE ATTACCARE O SCOPPIARE
    }

    private void linkToGrid() {
    }

    private void explode() {
    }
}
