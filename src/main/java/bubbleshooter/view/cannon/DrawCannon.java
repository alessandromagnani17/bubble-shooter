package bubbleshooter.view.cannon;

import bubbleshooter.controller.input.HandlerAdapterMouseMoved;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

public class DrawCannon {

    private static final Point2D CANNON_POSITION = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() / 1.36);

    private AnchorPane pane = new AnchorPane();
    private Rotate rotation = new Rotate();
    private Cannon cannon;
    private Point2D shootingBubblePosition;
    private HandlerAdapterMouseMoved handlerAdapterMouseMoved;

    public DrawCannon(final AnchorPane pane, final Cannon cannon, final Point2D shootingBubblePosition) {
        this.pane = pane;
        this.cannon = cannon;
        this.shootingBubblePosition = shootingBubblePosition;
        this.editCannon();
        this.setRotation();
        this.pane.getChildren().add(this.cannon.getCannon());
    }

    public final double getAngle() {
        return handlerAdapterMouseMoved.getRotationAngle();
    }

    private void editCannon() {
        this.cannon.getCannon().setLayoutX(CANNON_POSITION.getX() - this.cannon.getCannon().getImage().getWidth() / 2);
        this.cannon.getCannon().setLayoutY(CANNON_POSITION.getY());
    }

    private void setRotation() {
        this.rotation.setPivotX(shootingBubblePosition.getX() - CANNON_POSITION.getX() + this.cannon.getCannon().getImage().getWidth() / 2);
        this.rotation.setPivotY(shootingBubblePosition.getY() - CANNON_POSITION.getY());
        this.cannon.getCannon().getTransforms().add(rotation);
    }

    public final Rotate getRotation() {
        return this.rotation;
    }
}
