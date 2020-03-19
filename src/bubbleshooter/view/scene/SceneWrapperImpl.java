package bubbleshooter.view.scene;

import bubbleshooter.view.scene.controller.AbstractController;
import javafx.scene.Scene;

public class SceneWrapperImpl implements SceneWrapper {

    private final Scene scene;
    private final AbstractController guiController;
    
    public SceneWrapperImpl(final Scene scene, final AbstractController controller) {
        this.scene = scene;
        this.guiController = controller;
    }
    
    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public AbstractController getController() {
        return this.guiController;
    }
    
}