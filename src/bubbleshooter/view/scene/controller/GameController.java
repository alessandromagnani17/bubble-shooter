package bubbleshooter.view.scene.controller;

import java.io.FileNotFoundException;


import bubbleshooter.controller.Controller;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.view.View;
import bubbleshooter.view.rendering.CanvasDrawer;
import bubbleshooter.view.scene.FXMLPath;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class GameController extends AbstractController {

    @FXML
    private Canvas canvas;

    private CanvasDrawer canvasDrawer;
    private boolean isGameOver;


    @Override
    public void init(final Controller controller, final View view) throws FileNotFoundException {
        super.init(controller, view);
        this.canvasDrawer = new CanvasDrawer(this.canvas);
        canvasDrawer.draw(this.getController().getGameObjects());
        

        this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
			GameObject shootingBubble = getController().getGameObjects().stream()
									   .filter(a -> a.getType().equals(GameObjectsTypes.SHOOTINGBUBBLE))
									   .iterator().next();
			shootingBubble.setDirection(PhysicHelper.calculateShootingDirection(new Point2D(event.getX(), event.getY()), shootingBubble.getPosition()));
			getController().resume();
			}
		});
    }


    public void render() {
        this.clearCanvas();
        canvasDrawer.draw(this.getController().getGameObjects());
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
        return this.isGameOver;
    }

    // Clear the canvas after every render. It avoids ghosting effect.
    private void clearCanvas() {
        this.canvas.getGraphicsContext2D().restore();
    	this.canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

    }

}