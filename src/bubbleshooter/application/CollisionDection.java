package bubbleshooter.application;
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
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
/**
 *
 * @author blj0011
 */
public class CollisionDection extends Application {

    private Point2D shootingDirection;
    private double angle;
    private final double bubbleSpeed = 40;
    private Image img = new Image("bubbles/red.png");
    private final double radius = 50;
    private List<Circle> list = new LinkedList<>();
    private Circle movingBubble = new Circle();
    private double xVel, yVel;
    
    @Override
    public void start(final Stage stage) throws Exception {
        Pane root = new Pane();
        movingBubble.setStroke(Color.BLACK);
        movingBubble.setStrokeWidth(3);
        movingBubble.setCenterX(500);
        movingBubble.setCenterY(650);
        movingBubble.setRadius(50);
       this.movingBubble.setFill(new ImagePattern(img));
       
        for (int i = 30; i <950; i+=60) {
            Circle bubble = new Circle(i,30,26);
            bubble.setFill(new ImagePattern(new Image("bubbles/green.png")));
            bubble.setStroke(Color.BLACK);
            bubble.setStrokeWidth(2);
            list.add(bubble);
        }
        
        for (int i = 60; i < 950; i += 60) {
            Circle bubble = new Circle(i, 90, 26);
            bubble.setFill(new ImagePattern(new Image("bubbles/yellow.png")));
            bubble.setStroke(Color.BLACK);
            bubble.setStrokeWidth(2);
            list.add(bubble);
        }
        
        for (int i = 30; i < 950; i += 60) {
            Circle bubble = new Circle(i, 150, 26);
            bubble.setFill(new ImagePattern(new Image("bubbles/orange.png")));
            bubble.setStroke(Color.BLACK);
            bubble.setStrokeWidth(2);
            list.add(bubble);
        }

        root.getChildren().addAll(list);
        root.getChildren().add(movingBubble);
        root.setBackground(new Background(new BackgroundFill(Color.CYAN,null,null)));
        Scene scene = new Scene(root, 960, 700);
        stage.setTitle("Collision example");
        stage.setScene(scene);
        stage.show();
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                shootingDirection = new Point2D(event.getX(), event.getY());
                angle = Math.atan2(shootingDirection.getY() - movingBubble.getCenterY(),
                                   shootingDirection.getX() - movingBubble.getCenterX());
                xVel = bubbleSpeed * Math.cos(angle);
                yVel = bubbleSpeed * Math.sin(angle);

                    movingBubble.setCenterX(movingBubble.getCenterX() + xVel);
                    movingBubble.setCenterY(movingBubble.getCenterY() + yVel);


                for (Circle bubble : list) {
                    Shape intersect = Shape.intersect(movingBubble, bubble);
                   if (intersect.getBoundsInParent().getWidth() != -1) {
                       System.out.println("cccccccccccccc");
                       list.remove(bubble);
                     root.getChildren().remove(bubble);
                    movingBubble.setCenterX(500);
                    movingBubble.setCenterY(650);
                   }
                }
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
