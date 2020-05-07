package bubbleshooter.view.scene.controller;

import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import bubbleshooter.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public abstract class AbstractController {

    private Controller controller;
    private View view;

    /**
     * Method that initialized the controller and the view.
     * 
     * @param controller the controller of the game.
     * @param view       the controller of the view.
     */
    public void init(final Controller controller, final View view){
        this.controller = controller;
        this.view = view;
    }

    /**
     * 
     * @return The {@link Controller}.
     */
    public Controller getController() {
        return this.controller;
    }

    /**
     * 
     * @return The {@link View}.
     */
    protected View getView() {
        return this.view;
    }

    /**
     * Redraws the scene on the screen.
     */
    public void render() {
        // Empty for subclasses.
    }

    /**
     * Loads the next scene.
     */
    @FXML
    public void nextScene() {
        this.view.loadScene(this.getNextScene());
    }
 
    /**
     * Method that return the next {@link GameScenes}.
     * 
     * @return the next {@link GameScenes}.
     */
    public abstract FXMLPath getNextScene();

    /**
     * Event handler.
     * 
     * @param event the information about the event.
     */

    @FXML
    public void backScene() {
        this.view.loadScene(this.getPreviousScene());
    }

    /**
     * Method that return the previous {@link GameScenes}.
     * 
     * @return the previous {@link GameScenes}.
     */
    protected abstract FXMLPath getPreviousScene();
  /*  @FXML
    public void onKeyPressed(final KeyEvent event) {
        // Empty for subclasses.
    }*/

    /**
     * 
     * @param gameover true if the player lose.
     */
    public void setGameover() {
        // Empty for subclasses.
    }

    @FXML
    public void onKeyPressed(KeyEvent event) {
        //empty
    }
}
