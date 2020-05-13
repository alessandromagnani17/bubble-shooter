package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;

/**
 * Interface that represent 
 */
public interface SceneController {

    /**
     * Method that initialized the controller and the view.
     * 
     * @param controller the controller of the game.
     * @param view       the controller of the view.
     */
    void init(Controller controller, View view);

    /**
     * @return The {@link Controller}.
     */
    Controller getController();

    /**
     * @return The {@link View}.
     */
    View getView();

    /**
     * Redraws the scene on the screen.
     */
    void render();

    /**
     * Method that load the next scene.
     */
    void loadNextScene();

    /**
     * Method that set the next {@link GameScenes}.
     * 
     * @param nextScene the scene to load.
     */
    void setNextScene(FXMLPath nextScene);

}
