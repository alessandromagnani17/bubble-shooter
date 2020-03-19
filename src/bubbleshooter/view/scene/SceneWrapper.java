package bubbleshooter.view.scene;

import bubbleshooter.view.scene.controller.AbstractController;
import javafx.scene.Scene;

public interface SceneWrapper {

    Scene getScene();
    
    AbstractController getController();
    
}
