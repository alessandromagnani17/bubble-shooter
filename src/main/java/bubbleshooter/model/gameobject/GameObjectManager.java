package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.ShootingComponent;
import bubbleshooter.model.component.SwitchComponent;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class GameObjectManager {

    private List<Bubble> bubbles;

    
    public GameObjectManager() {
        this.bubbles = new LinkedList<>();
    } 

    public final void update(final double elapsed) {
        this.getShootingBubble().update(elapsed);
        this.bubbles.removeAll(this.bubbles.stream().filter(a -> a.isDestroyed()).collect(Collectors.toList()));
    }

    public final List<Bubble> getAllBubbles() {
        return this.bubbles;
    }

    public final void addBubble(final List<Bubble> bubbles) {
        this.bubbles.addAll(bubbles);
    }

    public final void removeGameObject(final Bubble bubble) {
        this.bubbles.remove(bubble);
    }

    public final Bubble getShootingBubble() {
        return this.bubbles.stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get();
    }

    public final Bubble getSwitchBubble() {
        return this.bubbles.stream().filter(a -> a.getType().equals(BubbleType.SWITCH_BUBBLE)).findFirst().get();
    }

    public final void reloadShootingBubble() {
        Bubble shootingBubble = this.getShootingBubble();
        shootingBubble.setPosition(new Point2D(GameCostants.GUIWIDTH.getValue() / 2, 600));
        if (shootingBubble.getComponent(ComponentType.SHOOTINGCOMPONENT).isPresent()) {
            ShootingComponent shooter = (ShootingComponent) shootingBubble.getComponent(ComponentType.SHOOTINGCOMPONENT).get();
            shooter.setDirection(shootingBubble.getPosition());
        }
        shootingBubble.setColor(getSwitchBubble().getColor());
    }

    public final void reloadSwitchBubble() {
    	Bubble switchBubble = this.getSwitchBubble();
    	switchBubble.setPosition(new Point2D(600, 600));
    	if (switchBubble.getComponent(ComponentType.SWITCHCOMPONENT).isPresent()) {
    		SwitchComponent switcher = (SwitchComponent) switchBubble.getComponent(ComponentType.SWITCHCOMPONENT).get();
    		switcher.setBubbleColor(switchBubble.getColor());
    	}
    	switchBubble.setColor(BubbleColor.getRandomColor());
    }

    public final List<Bubble> getBubbleGrid() {
        return this.bubbles.stream().filter(a -> a.getType().equals(BubbleType.GRID_BUBBLE)).collect(Collectors.toList());
    }

}

