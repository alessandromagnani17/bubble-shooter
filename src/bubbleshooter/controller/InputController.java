package bubbleshooter.controller;

import javafx.scene.image.ImageView;
import bubbleshooter.model.gameobject.ShootingBubble;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage; 

public class InputController extends Application {

	//POSIZIONI TEMPORANEE
	public static final double CANNON_POSITIONX = 458;
	public static final double CANNON_POSITIONY = 490;
	public static final double SHOOTINGBUBBLE_CENTERX = 498;
	public static final double SHOOTINGBUBBLE_CENTERY = 650;

    Pane root = new Pane();
    
    //private Cannon cannon = new Cannon(new Point2D(CANNON_POSITIONX, CANNON_POSITIONY));
    private ImageView cannon = new ImageView(new Image("bubbles/cannon.png"));
    private ShootingBubble shootingBubble = new ShootingBubble(new Point2D(SHOOTINGBUBBLE_CENTERX, SHOOTINGBUBBLE_CENTERY));

    private Rotate rotation = new Rotate();

    public InputController(Pane root) {
        this.root = root;
    }

    public final void start(final Stage stage) throws Exception {

        Scene scene = new Scene(root, 960, 700);
        stage.setScene(scene);
        stage.show();

        rotation.setPivotX(SHOOTINGBUBBLE_CENTERX - CANNON_POSITIONX);
        rotation.setPivotY(SHOOTINGBUBBLE_CENTERY - CANNON_POSITIONY);
        cannon.getTransforms().add(rotation);

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

        @Override
        public void handle(final MouseEvent event) {
            cannon.setRotate(calculateAngle(event));

        }
    });
    }

    public double calculateAngle (MouseEvent event) {
        double ipotenuse = Math.sqrt(Math.pow(event.getX() - SHOOTINGBUBBLE_CENTERX, 2) + Math.pow(event.getY() - SHOOTINGBUBBLE_CENTERY, 2));
        double x = (event.getX() - SHOOTINGBUBBLE_CENTERX);

        return Math.toDegrees(Math.asin(x/ipotenuse));

    }
    
    public final void stop() {
        cannon.setRotate(0);
    }
}