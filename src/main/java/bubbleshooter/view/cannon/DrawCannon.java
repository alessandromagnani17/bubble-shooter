package bubbleshooter.view.cannon;

import bubbleshooter.controller.HandlerAdapterMouseClicked;
import bubbleshooter.controller.HandlerAdapterMouseMoved;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.rendering.Cannon;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

public class DrawCannon {

    //private static final double CANNON_X = Settings.getGuiWidth()  / 2.23;
	private static final double CANNON_X = Settings.getGuiWidth() / 2;
    private static final double CANNON_Y = Settings.getGuiHeigth() / 1.31;
    private static final double SHOOTING_X = Settings.getGuiWidth() / 2;
    private static final double SHOOTING_Y = Settings.getGuiHeigth() - Bubble.getWidth();

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

        //this.handlerAdapterMouseMoved = new HandlerAdapterMouseMoved(this.rotation, SHOOTING_X, SHOOTING_Y);

        //this.pane.setOnMouseMoved(handlerAdapterMouseMoved);
        //this.pane.setOnMouseDragged(new HandlerAdapterMouseMoved(this.rotation, SHOOTING_X, SHOOTING_Y));
        this.pane.setOnMouseClicked(new HandlerAdapterMouseClicked(this.rotation, SHOOTING_X, SHOOTING_Y));
    }

    /*public final double getAngle() {
        return handlerAdapterMouseMoved.getRotationAngle();
    }*/

    private void editCannon() {
        this.cannon.getCannon().setLayoutX(CANNON_X - this.cannon.getCannon().getImage().getWidth()/2);
        this.cannon.getCannon().setLayoutY(CANNON_Y);
    }

    private void setRotation() {
        this.rotation.setPivotX(SHOOTING_X - CANNON_X + this.cannon.getCannon().getImage().getWidth()/2);
        this.rotation.setPivotY(SHOOTING_Y - CANNON_Y);
        this.cannon.getCannon().getTransforms().add(rotation);
    }

	public Rotate getRotation() {
		return this.rotation;
	}

}
