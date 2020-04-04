package bubbleshooter.controller;

import java.util.LinkedList;
import javafx.scene.image.ImageView;
import java.util.List;

import javax.swing.JDialog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class InputController extends Application {

    Pane root = new Pane();
    private ImageView cannon = new ImageView(new Image("bubbles/cannon.png"));

    public InputController (Pane root) {
        this.root = root;
    }

    public final void setCannonInitiallyPosition () {
        cannon.setScaleX(0.4);
        cannon.setScaleY(0.3);
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
            cannon.setRotate(event.getX() - cannon.getLayoutX());
        }
    });
    }

    public final void stop() {
        cannon.setRotate(0);
    }
}