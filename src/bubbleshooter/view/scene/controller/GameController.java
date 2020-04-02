package bubbleshooter.view.scene.controller;

import java.io.FileNotFoundException;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.View;
import bubbleshooter.view.rendering.CanvasDrawer;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

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
        this.resetGameCanvasCoordinates();
    }

    private void resetGameCanvasCoordinates() {

    }
}