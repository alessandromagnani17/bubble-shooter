package bubbleshooter.model.gameobject;

import bubbleshooter.utility.GameCostants;
import bubbleshooter.view.images.Color;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class BasicBubble extends AbstractGameObject implements Bubble {

    private Color color;

    public BasicBubble(final Point2D position, final Color color) {
        super.setType(GameObjectsTypes.BASICBUBBLE);
        super.setPosition(position);
        this.color = color;
        super.setHeigth(GameCostants.RADIUS.getValue() * 2);
        super.setWidth(super.getHeight()); 
        super.setShape(new Circle(super.getPosition().getX(), super.getPosition().getY(), GameCostants.RADIUS.getValue()));
    }

    @Override
    public final void setPosition(final Point2D position) {
        super.setPosition(position);
        ((Circle) super.getShape()).setCenterX(position.getX());
        ((Circle) super.getShape()).setCenterY(position.getY());
    }

    @Override
    public final void setColor(final Color bubbleColor) {
        this.color = bubbleColor;
    }

    @Override
    public final Color getColor() {
        return this.color;
    }

}
