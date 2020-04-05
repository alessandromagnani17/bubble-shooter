package bubbleshooter.controller;

import javafx.scene.image.ImageView;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

public class InputController extends Application {

    Pane root = new Pane();
    private ImageView cannon = new ImageView(new Image("bubbles/cannon.png"));

    public InputController(Pane root) {
        this.root = root;
    }

    public final void setCannonInitiallyPosition() {
        cannon.setLayoutX(350);
        cannon.setLayoutY(360);
    }

    public final void start(final Stage stage) throws Exception {

        Scene scene = new Scene(root, 960, 700);
        stage.setScene(scene);
        stage.show();

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

        @Override
        public void handle(final MouseEvent event) {
            cannon.setRotate(calculateAngle(event));

        }
    });
    }

    public double calculateAngle (MouseEvent event) {
        double ipotenuse = Math.sqrt(Math.pow(event.getX() - cannon.getLayoutX(), 2) + Math.pow(event.getY() - cannon.getLayoutY(), 2));
        double x = (event.getX() - cannon.getLayoutX());
        double angle = Math.toDegrees(Math.asin(x/ipotenuse));

        System.out.println(event.getX() + ", " + event.getY() + "    " + cannon.getLayoutX() + ", " + cannon.getLayoutY() + "    " + x + "    . " + angle + ", " + ipotenuse);

        return angle;
    }
    
    public final void stop() {
        cannon.setRotate(0);
    }
}