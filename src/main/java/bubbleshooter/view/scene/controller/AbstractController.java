package bubbleshooter.view.scene.controller;

import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import bubbleshooter.controller.Controller;

/**
 * Abstract class used like a basic controller, the other controller will extends it.
 * Implements the {@SceneController} interface.
 */
public abstract class AbstractController implements SceneController {

    private Controller controller;
    private View view;
    private FXMLPath nextScene;

    @Override
	public void init(final Controller controller, final View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public final Controller getController() {
        return this.controller;
    }

    @Override
    public final View getView() {
        return this.view;
    }

    @Override
    public void render() {
        // Empty for subclasses.
    }

    @Override
    public final void loadNextScene() {
        this.view.loadScene(this.nextScene);
    }

    @Override
    public final void setNextScene(final FXMLPath nextScene) {
        this.nextScene = nextScene;
    }

}
