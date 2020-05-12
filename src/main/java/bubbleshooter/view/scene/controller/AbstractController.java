package bubbleshooter.view.scene.controller;

import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import bubbleshooter.controller.Controller;

public abstract class AbstractController {

    private Controller controller;
    private View view;

    /**
     * Method that initialized the controller and the view.
     * 
     * @param controller the controller of the game.
     * @param view       the controller of the view.
     */
    public void init(final Controller controller, final View view) {
        this.controller = controller;
        this.view = view;
    }

    /**
     * @return The {@link Controller}.
     */
    public Controller getController() {
        return this.controller;
    }

    /**
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
     * Method that set the next {@link GameScenes}.
     * 
     * @param nextScene the scene to load.
     */
    public abstract void setNextScene(FXMLPath nextScene);

}
