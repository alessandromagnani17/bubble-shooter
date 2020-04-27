package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.controller.HandlerAdapterMouseClicked;
import bubbleshooter.controller.HandlerAdapterMouseMoved;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleType;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.view.View;
import bubbleshooter.view.images.ImagePath;
import bubbleshooter.view.rendering.CanvasDrawer;
import bubbleshooter.view.scene.FXMLPath;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

public class GameController extends AbstractController {

    @FXML
    private Canvas canvas;

    @FXML
    private AnchorPane pane;

    @FXML
    private CheckBox help = new CheckBox("Help");
    private CanvasDrawer canvasDrawer;
    private boolean gameOver;

    @Override
    public final void init(final Controller controller, final View view) {
        super.init(controller, view);

        ImageView cannon = new ImageView(new Image(ImagePath.CANNON.getPath()));

        cannon.setLayoutX(315.5);
        cannon.setLayoutY(460.0);


        Rotate rotation = new Rotate();
        rotation.setPivotX(this.getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getX() - cannon.getLayoutX());
        rotation.setPivotY(this.getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getY() - cannon.getLayoutY());
        cannon.getTransforms().add(rotation);

        pane.getChildren().add(cannon);

        canvas.setOnMouseMoved(new HandlerAdapterMouseMoved(rotation, 
                getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getX(), 
                getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getY()));
        canvas.setOnMouseClicked(new HandlerAdapterMouseClicked(rotation, 
                getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getX(), 
                getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getY()));
        canvas.setOnMouseDragged(new HandlerAdapterMouseMoved(rotation, 
                getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getX(), 
                getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getY()));


        this.canvasDrawer = new CanvasDrawer(this.canvas);
        //canvasDrawer.draw(this.getController().getBubbles());
        getController().resume();
        this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                Bubble shootingBubble = getController().getBubbles().stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get();
                shootingBubble.setDirection(PhysicHelper.calculateShootingDirection(
                         new Point2D(event.getX(), event.getY()), shootingBubble.getPosition()));
            }
        });
    }


    public final void render() {
        if (this.isGameOver()) {
            this.nextScene();
        }
		if (this.help.isSelected()) {
			//Disegnare la linea tratteggiata
		}
		// da aggiungere anche la chiamata al controller per sapere lo score corrente
		this.clearCanvas();
		canvasDrawer.draw(this.getController().getBubbles());
	}

	@Override
	public FXMLPath getNextScene() {
		return FXMLPath.MAIN;
	}

	@Override
	protected FXMLPath getPreviousScene() {
		return FXMLPath.MAIN;
	}

	public boolean isGameOver() {
		return this.gameOver;
	}

	public void setGameOver() {
		this.gameOver = true;
	}

    // Clear the canvas after every render. It avoids ghosting effect.
    private void clearCanvas() {
        this.canvas.getGraphicsContext2D().restore();
    	this.canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
