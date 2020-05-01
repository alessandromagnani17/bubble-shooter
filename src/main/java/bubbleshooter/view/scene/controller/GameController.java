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
import bubbleshooter.view.states.GameState;
import bubbleshooter.view.states.InGameState;
import bubbleshooter.view.states.InPauseState;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class GameController extends AbstractController {

    private static final double MAXANGLE =  65.0;
    private static final double MINANGLE = -65.0;
	
	@FXML
	private Canvas canvas;

	@FXML
	private AnchorPane pane;

	@FXML
	private CheckBox help = new CheckBox("Help");
	private CanvasDrawer canvasDrawer;
	private boolean gameOver;
	private GameState currentState;
	private GameState inGameState;
	private GameState inPauseState;

	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		this.canvasDrawer = new CanvasDrawer(this.canvas);
		this.inGameState = new InGameState(this, controller);
		this.inPauseState = new InPauseState(this, controller);
		this.setCurrentState(this.inGameState);
		ImageView cannon = new ImageView(new Image(ImagePath.CANNON.getPath()));
		Rotate rotation = new Rotate();
		double xBubble = getController().getBubbles().stream()
				.filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getX();
		double yBubble = getController().getBubbles().stream()
				.filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getY();

		cannon.setLayoutX(315.5);
		cannon.setLayoutY(455.0);

		rotation.setPivotX(xBubble - cannon.getLayoutX());
		rotation.setPivotY(yBubble - cannon.getLayoutY());
		cannon.getTransforms().add(rotation);

		pane.getChildren().add(cannon);

		canvas.setOnMouseMoved(new HandlerAdapterMouseMoved(rotation, xBubble, yBubble));
		canvas.setOnMouseDragged(new HandlerAdapterMouseMoved(rotation, xBubble, yBubble));
		canvas.setOnMouseClicked(new HandlerAdapterMouseClicked(rotation, xBubble, yBubble));

		this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				Bubble shootingBubble = getController().getBubbles().stream()
						.filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get();
				if (shootingBubble.getPosition().getX() == xBubble && checkAngle(rotation.getAngle())) {
					shootingBubble.setDirection(PhysicHelper.calculateShootingDirection(
							new Point2D(event.getX(), event.getY()), shootingBubble.getPosition()));
				}
			}
		});
	}

	public final void render() {
		if (this.isGameOver()) {
			this.nextScene();
		}
		if (this.help.isSelected()) {
			// Disegnare la linea tratteggiata
		}
		// da aggiungere anche la chiamata al controller per sapere lo score corrente
		this.clearCanvas();
		canvasDrawer.draw(this.getController().getBubbles());
	}

	@Override
	public final FXMLPath getNextScene() {
		return FXMLPath.GAMEOVER;
	}

	@Override
	protected final FXMLPath getPreviousScene() {
		return FXMLPath.MAIN;
	}

	public final boolean isGameOver() {
		return this.gameOver;
	}

	public final void setGameOver() {
		this.gameOver = true;
	}

	public final boolean checkAngle(final double angle) {
		return !(angle > MAXANGLE || angle < MINANGLE);
	}
	
	// Clear the canvas after every render. It avoids ghosting effect.
	private void clearCanvas() {
		this.canvas.getGraphicsContext2D().restore();
		this.canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public GameState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(GameState state) {
		if (currentState != null) {
			this.currentState.exit();
		}
		this.currentState = state;
		this.currentState.enter();
	}

	public GameState getInGameState() {
		return inGameState;
	}

	public GameState getInPauseState() {
		return inPauseState;
	}
	

}
