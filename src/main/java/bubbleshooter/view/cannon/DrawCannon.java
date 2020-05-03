package bubbleshooter.view.cannon;

import bubbleshooter.controller.HandlerAdapterMouseClicked;
import bubbleshooter.controller.HandlerAdapterMouseMoved;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.rendering.Cannon;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

public class DrawCannon {

	private static final Point2D CANNON_POSITION = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() / 1.31);
	private static final Point2D SHOOTING_BUBBLE_POSITION = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() - Bubble.getWidth());

    private AnchorPane pane = new AnchorPane();
    private Rotate rotation = new Rotate();
    private Cannon cannon;
    private HandlerAdapterMouseMoved handlerAdapterMouseMoved;

    public DrawCannon(final AnchorPane pane, final Cannon cannon) {
        this.pane = pane;
        this.cannon = cannon;
        this.editCannon();
        this.setRotation();
        this.pane.getChildren().add(this.cannon.getCannon());

        this.pane.setOnMouseClicked(new HandlerAdapterMouseClicked(this.rotation, SHOOTING_BUBBLE_POSITION));
    }

    public final double getAngle() {
        return handlerAdapterMouseMoved.getRotationAngle();
    }

    private void editCannon() {
        this.cannon.getCannon().setLayoutX(CANNON_POSITION.getX() - this.cannon.getCannon().getImage().getWidth()/2);
        this.cannon.getCannon().setLayoutY(CANNON_POSITION.getY());
    }

    private void setRotation() {
        this.rotation.setPivotX(SHOOTING_BUBBLE_POSITION.getX() - CANNON_POSITION.getX() + this.cannon.getCannon().getImage().getWidth()/2);
        this.rotation.setPivotY(SHOOTING_BUBBLE_POSITION.getY() - CANNON_POSITION.getY());
        this.cannon.getCannon().getTransforms().add(rotation);
    }

	public Rotate getRotation() {
		return this.rotation;
	}

}
