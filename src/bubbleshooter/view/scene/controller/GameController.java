package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.View;
import bubbleshooter.view.rendering.CanvasDrawer;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class GameController extends AbstractController{
    
    @FXML
    private Canvas canvas;
    
    private CanvasDrawer canvasDrawer; 
    private boolean isGameOver; 
    
    
    @Override
    public void init(final Controller controller, final View view) {
        super.init(controller, view);
        this.canvasDrawer = new CanvasDrawer(canvas); 
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
}