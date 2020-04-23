package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import bubbleshooter.utility.Utility;
import javafx.geometry.Point2D;


public class GameObjectManager {

    private List<Bubble> bubbles;

    public GameObjectManager() {
        this.bubbles = new LinkedList<>();
    } 

    public final void update(final double elapsed) {
       // this.getShootingBubble().update(elapsed);
        //this.bubbles.removeAll(this.bubbles.stream().filter(a -> a.isDestroyed()).collect(Collectors.toList()));
    }

    public final void addGameObject(final List<Bubble> bubbles) {
        this.bubbles.addAll(bubbles);
    }

    public final void removeGameObject(final Bubble bubble) {
        this.bubbles.remove(bubble);
    }

    public final ShootingBubble getShootingBubble() {
        return (ShootingBubble) this.bubbles.stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).iterator().next();
    }

    public final void reloadShootingBubble() {

        ShootingBubble shootingBubble = this.getShootingBubble();
        shootingBubble.setPosition(new Point2D(Utility.getGuiWidth() / 2, 600));
        shootingBubble.setDirection(shootingBubble.getPosition());
        shootingBubble.setColor(BubbleColor.getRandomColor());
    }

    public final List<Bubble> getBubbles() {
        return this.bubbles; 
    }

}

