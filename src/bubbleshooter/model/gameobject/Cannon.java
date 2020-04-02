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
        super.setShape(new Rectangle(super.getPosition().getX(), super.getPosition().getY(), super.getWidth(), super.getHeight())) ;
    }

    @Override
    public final void accept(final Visitor visitor, final GameObjectManager gameObjectManager) {
        visitor.visit(this, GameObjectsTypes.CANNON, gameObjectManager);
    }

}
