package bubbleshooter.model.gameobject;

import bubbleshooter.model.collision.Visitor;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class Cannon extends AbstractGameObject {

    public Cannon() {
        this.initCannon();
    }

    private void initCannon() {
        super.setType(GameObjectsTypes.CANNON);
        super.setPosition(new Point2D(0, GameCostants.GUIHEIGTH.getValue() - GameCostants.CANNONHEIGTH.getValue()));
        super.setHeigth(GameCostants.CANNONHEIGTH.getValue());
        super.setWidth(GameCostants.GUIWIDTH.getValue());
        }

}
