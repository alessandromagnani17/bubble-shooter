package bubbleshooter.view;

import bubbleshooter.view.scene.FXMLPath;
import bubbleshooter.controller.Controller;

public interface View {

    void launch(Controller controller);

    void loadScene(FXMLPath scene);

    void showGameOver();
    
    void update();

    void render();

}