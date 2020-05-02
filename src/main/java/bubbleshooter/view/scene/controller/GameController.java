package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.controller.SwitcherController;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleType;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.view.View;
import bubbleshooter.view.cannon.DrawCannon;
import bubbleshooter.view.images.ImagePath;
import bubbleshooter.view.rendering.Cannon;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GameController extends AbstractController {

    private static final double MAXANGLE =  64.9;
    private static final double MINANGLE = -64.9;
	
	@FXML
	private Canvas canvas;

	@FXML
	private AnchorPane pane;

	@FXML
	private CheckBox helpCheckBox = new CheckBox("Help");
	private CanvasDrawer canvasDrawer;
	private boolean gameOver;
	private GameState currentState;
	private GameState inGameState;
	private GameState inPauseState;
	private DrawHelpLine help;
	private DrawCannon drawCannon;
	private Cannon cannon;
	private SwitcherController switcherController;

	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		this.help  = new DrawHelpLine(this.pane);
	    this.cannon = new Cannon(new Image(ImagePath.CANNON.getPath()));
		this.drawCannon = new DrawCannon(this.pane, this.cannon);
		this.canvasDrawer = new CanvasDrawer(this.canvas);
		this.inGameState = new InGameState(this, controller);
		this.inPauseState = new InPauseState(this, controller);
		this.setCurrentState(this.inGameState);

		double xBubble = getController().getBubbles().stream()
				.filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getX();

		this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				Bubble shootingBubble = getController().getBubbles().stream()
						.filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get();
				if (shootingBubble.getPosition().getX() == xBubble && checkAngle(drawCannon.getAngle())) {
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

		// da aggiungere anche la chiamata al controller per sapere lo score corrente
		this.clearCanvas();
		canvasDrawer.draw(this.getController().getBubbles());
	}
	
	public final void switchBall() {
		 this.switcherController = new SwitcherController();
		 this.switcherController.switchControl();
	}
	
    public final void helpSelected() {
		if (this.helpCheckBox.isSelected()) {
			this.help.drawLine();
		} else {
			this.help.deleteLine();
		}
	}
    
    public void pause() {
    	this.getController().getGameEngine().pauseLoop();
    	this.getView().loadScene(FXMLPath.PAUSE);
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

	public final GameState getCurrentState() {
		return currentState;
	}

	public final void setCurrentState(final GameState state) {
		if (currentState != null) {
			this.currentState.exit();
		}
		this.currentState = state;
		this.currentState.enter();
	}

	public final GameState getInGameState() {
		return inGameState;
	}

	public final GameState getInPauseState() {
		return inPauseState;
	}
}
