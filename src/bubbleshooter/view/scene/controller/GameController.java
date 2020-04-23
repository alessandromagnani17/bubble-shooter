package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.ShootingComponent;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleType;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.view.View;
import bubbleshooter.view.rendering.CanvasDrawer;
import bubbleshooter.view.scene.FXMLPath;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class GameController extends AbstractController {

	@FXML
	private Canvas canvas;

	private CanvasDrawer canvasDrawer;
	private boolean gameOver;

    @Override
    public void init(final Controller controller, final View view) {
        super.init(controller, view);
        this.canvasDrawer = new CanvasDrawer(this.canvas);
        // canvasDrawer.draw(this.getController().getGameObjects()); se il gameLoop
        getController().resume();
		this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				Bubble shootingBubble = getController().getBubbles().stream()
						.filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).iterator().next();
				ShootingComponent shootingComponent = (ShootingComponent) shootingBubble.getComponents().stream()
                        .filter(a -> a.getComponentType().equals(ComponentType.SHOOTINGCOMPONENT))
                        .findFirst().get();
				shootingComponent.setDirection(PhysicHelper.calculateShootingDirection(
						new Point2D(event.getX(), event.getY()), shootingBubble.getPosition()));
				getController().resume();
			}
		});
	}


	public void render() {
		if (this.isGameOver()) {
			this.nextScene();
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